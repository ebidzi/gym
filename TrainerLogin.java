package gym.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TrainerLogin {
    
    JTextField nameField;
    JFrame frame;
	String name;
	String password;

    TrainerLogin(JFrame frame, JTextField nameField){
        this.frame = frame;
		this.nameField = nameField;
    }

    
	public void trainerPanel(){
							Container ContentPane = frame.getContentPane();
							frame.getContentPane().removeAll();
							frame.getContentPane().repaint();
							frame.getContentPane().revalidate();

							ImageIcon img = new ImageIcon("gymTrainer2.jpg");
							JLabel background = new JLabel("",img,JLabel.CENTER);
							background.setSize(900, 500);
							background.setLayout(null);
							frame.add(background);
					
							JLabel devMusclesGym = new JLabel("VIGOROSO FITNESS GYM");
							devMusclesGym.setBounds(220, 20, 600, 50);
							Font welcomeFont = new Font("Constantia", Font.PLAIN, 40);
							devMusclesGym.setFont(welcomeFont);
							devMusclesGym.setForeground(Color.black);
							background.add(devMusclesGym);

							JButton back = new JButton("LOGOUT");
							back.setBounds(5, 5, 95, 35);
							back.setBackground(new Color(0,0,0));
							back.setForeground(Color.white);
							back.setFocusable(false);
							back.setFont(new Font("Segoe UI", Font.BOLD, 14));
							background.add(back);
							BackButtonForAll logout = new BackButtonForAll(back, frame);
							back.addActionListener(logout);

							name = nameField.getText();
							JLabel hello = new JLabel("Hello Coach " + name +"! , are you ready to train?");
							hello.setBounds(5,50,450,50);
							Font helloFont = new Font("Segoe UI", Font.ITALIC, 14); 
							hello.setFont(helloFont);
							hello.setForeground(Color.black);
							background.add(hello);

												
							JLabel memberListLabel = new JLabel("Gym Trainees");
							memberListLabel.setBounds(90, 90, 200, 30);
							memberListLabel.setForeground(Color.black);
							memberListLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
							background.add(memberListLabel);
						
							
							File membersDirectory = new File("members");
							File[] memberFiles = membersDirectory.listFiles();
						
							JTextArea memberListArea = new JTextArea();
							memberListArea.setEditable(false);
							memberListArea.setBackground(new Color(255,255,255));
							memberListArea.setOpaque(false);
							memberListArea.setForeground(Color.black);
							memberListArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
						
							if (memberFiles != null) {
								for (File memberFile : memberFiles) {
									if (memberFile.isFile()) {
										try (BufferedReader read = new BufferedReader(new FileReader(memberFile))) {
											String firstLine = read.readLine();
											memberListArea.append(firstLine + "\n");
										} catch (IOException ex) {
											ex.printStackTrace();
										}
									}
								}
							}
						
							JScrollPane scrollPane = new JScrollPane(memberListArea);
							scrollPane.setBounds(90, 120, 300, 300);
							background.add(scrollPane);
				
	}
	
	
}