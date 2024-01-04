package gym.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class CashierLogin {

    JFrame frame;
    JTabbedPane tabbedPane;
    JList<String> pendingList;
    DefaultListModel<String> pendingListModel;
    JList<String> memberList;
    DefaultListModel<String> memberListModel;

    CashierLogin(JFrame frame) {
        this.frame = frame;
    }

    public void cashierPanel() {
        Container contentPane = frame.getContentPane();
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();

        ImageIcon img = new ImageIcon("gymCashier.jpg");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setSize(900, 500);
        background.setLayout(null);
        frame.add(background);

        JLabel devMusclesGym = new JLabel("VIGOROSO FITNESS GYM");
        devMusclesGym.setBounds(220, 20, 600, 50);
        Font welcomeFont = new Font("Constantia", Font.PLAIN, 40);
        devMusclesGym.setFont(welcomeFont);
        devMusclesGym.setForeground(Color.black);
        background.add(devMusclesGym);

        JLabel hello = new JLabel("Hello Cashier!");
        hello.setBounds(20, 70, 350, 50);
        Font helloFont = new Font("Segoe UI", Font.ITALIC, 18);
        hello.setFont(helloFont);
        hello.setForeground(Color.black);
        background.add(hello);

        JButton logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBounds(10, 400, 95, 35);
        logoutBtn.setBackground(new Color(0, 0, 0));
        logoutBtn.setForeground(Color.white);
        logoutBtn.setFocusable(false);
        logoutBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(logoutBtn);
        BackButtonForAll logout = new BackButtonForAll(logoutBtn, frame);
        logoutBtn.addActionListener(logout);

        tabbedPane = new JTabbedPane();

        // Tab for Pending Members
        JPanel pendingPanel = createTabPanel();
        JLabel pendingLabel = createTabLabel("Pending Members");
        pendingPanel.add(pendingLabel);

        File pendingMembersDirectory = new File("pending members");
        File[] pendingMemberFiles = pendingMembersDirectory.listFiles();

        pendingListModel = new DefaultListModel<>();
        pendingList = createJList(pendingListModel);
        if (pendingMemberFiles != null) {
            for (File memberFile : pendingMemberFiles) {
                if (memberFile.isFile()) {
                    pendingListModel.addElement(memberFile.getName());
                }
            }
        }
        JScrollPane pendingScrollPane = new JScrollPane(pendingList);
        pendingPanel.add(pendingScrollPane);

        JButton paid = new JButton("PAID ₱500");
        paid.setBounds(100, 400, 95, 35);
        paid.setFocusable(false);
        paid.setBackground(Color.black);
        paid.setForeground(Color.white);
        paid.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pendingPanel.add(paid);

        paid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFileName = pendingList.getSelectedValue();
                if (selectedFileName != null) {
                    moveMemberFromPendingToRegistered(selectedFileName);
                    refreshLists();
                }
            }
        });

        tabbedPane.addTab("Pending Members", null, pendingPanel, "Pending Members");

        // Tab for Registered Members
        JPanel registeredPanel = createTabPanel();
        JLabel memberListLabel = createTabLabel("Registered Members");
        registeredPanel.add(memberListLabel);

        File registeredMembersDirectory = new File("members");
        File[] registeredMemberFiles = registeredMembersDirectory.listFiles();

        memberListModel = new DefaultListModel<>();
        memberList = createJList(memberListModel);
        if (registeredMemberFiles != null) {
            for (File memberFile : registeredMemberFiles) {
                if (memberFile.isFile()) {
                    memberListModel.addElement(memberFile.getName());
                }
            }
        }
        JScrollPane scrollPane = new JScrollPane(memberList);
        registeredPanel.add(scrollPane);

        tabbedPane.addTab("Registered Members", null, registeredPanel, "Registered Members");

        tabbedPane.setBounds(150, 90, 500, 300);
        background.add(tabbedPane);
    }

    private JPanel createTabPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return panel;
    }

    private JLabel createTabLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.black);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        return label;
    }

    private JList<String> createJList(DefaultListModel<String> model) {
        JList<String> list = new JList<>(model);
        list.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        list.setBackground(Color.WHITE);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return list;
    }

    private void moveMemberFromPendingToRegistered(String selectedFileName) {
        try {
            Path sourcePath = Paths.get("pending members", selectedFileName);
            Path destinationPath = Paths.get("members", selectedFileName.replace(" PENDING MEMBER.txt", " MEMBER.txt"));
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void refreshLists() {
        refreshPendingList();
        refreshMemberList();
    }

    private void refreshPendingList() {
        pendingListModel.clear();
        File pendingMembersDirectory = new File("pending members");
        File[] pendingMemberFiles = pendingMembersDirectory.listFiles();
        if (pendingMemberFiles != null) {
            for (File memberFile : pendingMemberFiles) {
                if (memberFile.isFile()) {
                    pendingListModel.addElement(memberFile.getName());
                }
            }
        }
    }

    private void refreshMemberList() {
        memberListModel.clear();
        File registeredMembersDirectory = new File("members");
        File[] registeredMemberFiles = registeredMembersDirectory.listFiles();
        if (registeredMemberFiles != null) {
            for (File memberFile : registeredMemberFiles) {
                if (memberFile.isFile()) {
                    memberListModel.addElement(memberFile.getName());
                }
            }
        }
    }
}
