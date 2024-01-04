package gym.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class OwnerLogin {

    JFrame frame;
    JButton login;

    JTabbedPane tabbedPane;
    JList<String> pendingList;
    DefaultListModel<String> pendingListModel;
    JList<String> trainerList;
    DefaultListModel<String> trainerListModel;

    OwnerLogin(JFrame frame) {
        this.frame = frame;
    }

    public void ownersPanel() {
        Container contentPane = frame.getContentPane();
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();

        ImageIcon img = new ImageIcon("gymOwner.jpg");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setSize(900, 500);
        background.setLayout(null);
        frame.add(background);

        JLabel hello = new JLabel("Good Day Owner!");
        hello.setBounds(20, 70, 350, 50);
        Font helloFont = new Font("Segoe UI", Font.ITALIC, 18);
        hello.setFont(helloFont);
        hello.setForeground(Color.black);
        background.add(hello);

        JLabel devMusclesGym = new JLabel("VIGOROSO FITNESS GYM");
        devMusclesGym.setBounds(220, 20, 600, 50);
        Font welcomeFont = new Font("Constantia", Font.PLAIN, 40);
        devMusclesGym.setFont(welcomeFont);
        devMusclesGym.setForeground(Color.black);
        background.add(devMusclesGym);

        JButton logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBounds(10, 400, 95, 35);
        logoutBtn.setBackground(new Color(0, 0, 0));
        logoutBtn.setForeground(Color.white);
        logoutBtn.setFocusable(false);
        logoutBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(logoutBtn);
        BackButtonForAll logout = new BackButtonForAll(logoutBtn, frame);
        logoutBtn.addActionListener(logout);

      	JButton member = new JButton("MEMBERS");
        member.setBounds(300, 150, 300, 35);
        member.setBackground(new Color(0, 0, 0));
        member.setForeground(Color.white);
        member.setFocusable(false);
        member.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(member);
        member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent vej) {
                if (vej.getSource() == member) {
                    displayMembers();
                }
            }
        });

        JButton trainer = new JButton("TRAINERS");
        trainer.setBounds(300, 250, 300, 35);
        trainer.setBackground(new Color(0, 0, 0));
        trainer.setForeground(Color.white);
        trainer.setFocusable(false);
        trainer.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(trainer);
        trainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ebidzi) {
                if (ebidzi.getSource() == trainer) {
                    displayTrainers();
                }
            }
        });

        background.setVisible(true);
        frame.setVisible(true);

    }

 	public void displayMembers() {
		Container contentPane = frame.getContentPane();
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();
	
		ImageIcon imge = new ImageIcon("gymOwner.jpg");
		JLabel background2 = new JLabel("", imge, JLabel.CENTER);
		background2.setSize(900, 500);
		background2.setLayout(null);
		frame.add(background2);
	
		ImageIcon backIcon = new ImageIcon("backButton.png");
		JButton backButton = new JButton("");
		backButton.setBounds(10, 400, 70, 50);
		backButton.setBackground(new Color(0, 0, 0));
		backButton.setForeground(Color.white);
		backButton.setIcon(backIcon);
		backButton.setOpaque(false);
		backButton.setFocusable(false);
		backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		backButton.setBorderPainted(false);
		background2.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ownersPanel();
			}
		});
	
		JLabel devMusclesGym = new JLabel("VIGOROSO FITNESS GYM");
		devMusclesGym.setBounds(220, 20, 600, 50);
		Font welcomeFont = new Font("Constantia", Font.PLAIN, 40);
		devMusclesGym.setFont(welcomeFont);
		devMusclesGym.setForeground(Color.black);
		background2.add(devMusclesGym);
	
		JLabel membersLabel = new JLabel("List of Members:");
		membersLabel.setBounds(90, 80, 200, 30);
		membersLabel.setForeground(Color.black);
		membersLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		background2.add(membersLabel);
	
		File membersDirectory = new File("members");
		File[] memberFiles = membersDirectory.listFiles();
	
		DefaultListModel<String> memberListModel = new DefaultListModel<>();
		JList<String> memberList = new JList<>(memberListModel);
		memberList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	
		if (memberFiles != null) {
			for (File memberFile : memberFiles) {
				String fileName = memberFile.getName();
				memberListModel.addElement(fileName);
			}
		}
	
		JScrollPane scrollPane = new JScrollPane(memberList);
		scrollPane.setBounds(90, 120, 670, 250);
		background2.add(scrollPane);
	
		JButton removeBtn = new JButton("REMOVE");
		removeBtn.setBounds(90, 370, 670, 25);
		removeBtn.setBackground(new Color(0,0,0));
		removeBtn.setForeground(Color.white);
		removeBtn.setFocusable(false);
		background2.add(removeBtn);
		removeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = memberList.getSelectedIndex();
				if (selectedIndex != -1) {
					DefaultListModel<String> model = (DefaultListModel<String>) memberList.getModel();
					String selectedFileName = model.getElementAt(selectedIndex);
	
					
					String filePath = "members/" + selectedFileName;
	
				
					model.remove(selectedIndex);
	
					
					File selectedFile = new File(filePath);
					if (selectedFile.exists()) {
						if (selectedFile.delete()) {
							System.out.println("File deleted successfully");
						} else {
							System.out.println("Error: File could not be deleted");
						}
					} else {
						System.out.println("Error: File not found at path: " + filePath);
					}
				}
			}
		});
	
		background2.setVisible(true);
		frame.setVisible(true);
	}
	
	


 
    public void displayTrainers() {
        Container contentPane = frame.getContentPane();
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();

        ImageIcon img = new ImageIcon("gymOwner.jpg");
        JLabel background3 = new JLabel("", img, JLabel.CENTER);
        background3.setSize(900, 500);
        background3.setLayout(null);
        frame.add(background3);

        ImageIcon backIcon = new ImageIcon("backButton.png");
        JButton backButton = new JButton("");
        backButton.setBounds(10, 400, 70, 50);
        backButton.setBackground(new Color(0, 0, 0));
        backButton.setForeground(Color.white);
        backButton.setIcon(backIcon);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background3.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ownersPanel();
            }
        });

		JLabel devMusclesGym = new JLabel("VIGOROSO FITNESS GYM");
		devMusclesGym.setBounds(220, 20, 600, 50);
		Font welcomeFont = new Font("Constantia", Font.PLAIN, 40);
		devMusclesGym.setFont(welcomeFont);
		devMusclesGym.setForeground(Color.black);
		background3.add(devMusclesGym);
      

        tabbedPane = new JTabbedPane();

        
        JPanel pendingPanel = createTabPanel();
        JLabel pendingLabel = createTabLabel("Pending Trainers");
        pendingPanel.add(pendingLabel);

        File pendingTrainersDirectory = new File("pending trainers");
        File[] pendingTrainerFiles = pendingTrainersDirectory.listFiles();

        pendingListModel = new DefaultListModel<>();
        pendingList = createJList(pendingListModel);
        if (pendingTrainerFiles != null) {
            for (File trainerFile : pendingTrainerFiles) {
                if (trainerFile.isFile()) {
                    pendingListModel.addElement(trainerFile.getName());
                }
            }
        }
        JScrollPane pendingScrollPane = new JScrollPane(pendingList);
        pendingPanel.add(pendingScrollPane);

        JButton accept = new JButton("ACCEPT");
        accept.setBounds(100, 400, 95, 35);
		accept.setBackground(Color.black);
		accept.setForeground(Color.white);
		accept.setFont(new Font("Segoe UI", Font.BOLD, 14));
		accept.setFocusable(false);
        pendingPanel.add(accept);
        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFileName = pendingList.getSelectedValue();
                if (selectedFileName != null) {
                    moveTrainerFromPendingToRegistered(selectedFileName);
                    refreshLists();
                }
            }
        });

        tabbedPane.addTab("Pending Trainers", null, pendingPanel, "Pending Trainers");

        
        JPanel registeredPanel = createTabPanel();
        JLabel trainerListLabel = createTabLabel("Registered Trainers");
        registeredPanel.add(trainerListLabel);

        File registeredTrainersDirectory = new File("trainers");
        File[] registeredTrainersFiles = registeredTrainersDirectory.listFiles();

        trainerListModel = new DefaultListModel<>();
        trainerList = createJList(trainerListModel);
        if (registeredTrainersFiles != null) {
            for (File trainerFile : registeredTrainersFiles) {
                if (trainerFile.isFile()) {
                    trainerListModel.addElement(trainerFile.getName());
                }
            }
        }
        JScrollPane scrollPane = new JScrollPane(trainerList);
        registeredPanel.add(scrollPane);

        tabbedPane.addTab("Registered Trainers", null, registeredPanel, "Registered Trainers");

        tabbedPane.setBounds(150, 90, 600, 300);
        background3.add(tabbedPane);

		JButton removeTrainerBtn = new JButton("REMOVE");
    	removeTrainerBtn.setBounds(100, 400, 95, 35);
		removeTrainerBtn.setBackground(Color.black);
		removeTrainerBtn.setForeground(Color.white);
		removeTrainerBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		removeTrainerBtn.setFocusable(false);
    	registeredPanel.add(removeTrainerBtn);
		removeTrainerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = trainerList.getSelectedIndex();
				if (selectedIndex != -1) {
					DefaultListModel<String> model = (DefaultListModel<String>) trainerList.getModel();
					String selectedFileName = model.getElementAt(selectedIndex);
	
					
					String filePath = "trainers/" + selectedFileName;
	
				
					model.remove(selectedIndex);
	
					
					File selectedFile = new File(filePath);
					if (selectedFile.exists()) {
						if (selectedFile.delete()) {
							System.out.println("File deleted successfully");
						} else {
							System.out.println("Error: File could not be deleted");
						}
					} else {
						System.out.println("Error: File not found at path: " + filePath);
					}
				}
			}
		});
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

    private void moveTrainerFromPendingToRegistered(String selectedFileName) {
        try {
            Path sourcePath = Paths.get("pending trainers", selectedFileName);
            Path destinationPath = Paths.get("trainers", selectedFileName.replace(" PENDING TRAINER.txt", " TRAINER.txt"));
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
        File pendingTrainersDirectory = new File("pending trainers");
        File[] pendingTrainersFiles = pendingTrainersDirectory.listFiles();
        if (pendingTrainersFiles != null) {
            for (File trainerFile : pendingTrainersFiles) {
                if (trainerFile.isFile()) {
                    pendingListModel.addElement(trainerFile.getName());
                }
            }
        }
    }

    private void refreshMemberList() {
        trainerListModel.clear();
        File registeredTrainersDirectory = new File("trainers");
        File[] registeredTrainersFiles = registeredTrainersDirectory.listFiles();
        if (registeredTrainersFiles != null) {
            for (File trianerFile : registeredTrainersFiles) {
                if (trianerFile.isFile()) {
                    trainerListModel.addElement(trianerFile.getName());
                }
            }
        }
    }
	
	
}

	



