package gym.system;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class TrainerRegister implements ActionListener{
    JButton trainer;
    JFrame frame;
    TrainerRegister(JButton trainer, JFrame frame){
        this.trainer = trainer;
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == trainer){
            trainerPanel();
        }
    }
    public void trainerPanel(){
        Container ContentPane = frame.getContentPane();
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();

        ImageIcon img = new ImageIcon("gymTrainer.jpg");
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

        JLabel devMusclesGym2 = new JLabel("TRAINER REGISTRATION");
        devMusclesGym2.setBounds(40,60,250,50);
        Font devFont2 = new Font("Segoe UI", Font.BOLD, 14); 
        devMusclesGym2.setFont(devFont2);
        devMusclesGym2.setForeground(Color.black);
        background.add(devMusclesGym2);

        
        ImageIcon backIcon = new ImageIcon("backButton.png");
        JButton cancel = new JButton("");
        cancel.setBounds(10,10,70,50);
        cancel.setBackground(new Color(0,0,0));
        cancel.setForeground(Color.black);
        cancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancel.setIcon(backIcon);
        cancel.setFocusable(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(false);
        background.add(cancel);
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent vj){
                if(vj.getSource() == cancel){
                     Container ContentPane = frame.getContentPane();
                     frame.getContentPane().removeAll();
                     frame.getContentPane().repaint();
                     frame.getContentPane().revalidate();

                    GymRegister reg = new GymRegister(frame);
                    reg.registerPanel();
                }
            }
        });

        ImageIcon hm = new ImageIcon("homeButton.png");
        JButton home = new JButton("");
        home.setBounds(90, 10, 70, 50);
        home.setBackground(new Color(158, 200, 185));
        home.setFont(new Font("Segoe UI", Font.BOLD, 13));
        home.setIcon(hm);
        home.setOpaque(false);
        home.setBorderPainted(false);
        home.setFocusable(false);
        background.add(home);
        home.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evj){
                if(evj.getSource() == home){
                     Container ContentPane = frame.getContentPane();
                     frame.getContentPane().removeAll();
                     frame.getContentPane().repaint();
                     frame.getContentPane().revalidate();

                   GymMain.mainGui();
                }
            }
        });


        JLabel enterName = new JLabel("Enter full name:");
        enterName.setBounds(10, 140, 100, 35);
        Font nameFont = new Font("Segoe UI", Font.BOLD, 12);
        enterName.setFont(nameFont);
        enterName.setForeground(Color.white);
        background.add(enterName);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(130, 140, 250, 35);
        nameTextField.setBackground(new Color(158, 200, 185));
        nameTextField.setFont(new Font("Times New Roman", Font.BOLD, 12));
        nameTextField.setOpaque(false);
        nameTextField.setForeground(Color.black);
        background.add(nameTextField);

        JLabel enterAge = new JLabel("Enter age:");
        enterAge.setBounds(10, 190, 100, 35);
        Font ageFont = new Font("Segoe UI", Font.BOLD, 12);
        enterAge.setFont(ageFont);
        enterAge.setForeground(Color.white);
		background.add(enterAge);


        JTextField ageTextField = new JTextField();
        ageTextField.setBounds(130, 190, 250, 35);
        ageTextField.setBackground(new Color(158, 200, 185));
        ageTextField.setFont(new Font("Times New Roman", Font.BOLD, 12));
        ageTextField.setOpaque(false);
        ageTextField.setForeground(Color.black);
        background.add(ageTextField);

        JLabel enterGender = new JLabel("Enter gender:");
        enterGender.setBounds(10, 240, 100, 35);
        Font genderFont = new Font("Segoe UI", Font.BOLD, 12);
        enterGender.setFont(genderFont);
        enterGender.setForeground(Color.white);
        background.add(enterGender);

        JTextField genderTextField = new JTextField();
        genderTextField.setBounds(130, 240, 250, 35);
        genderTextField.setBackground(new Color(158, 200, 185));
        genderTextField.setFont(new Font("Times New Roman", Font.BOLD, 12));
        genderTextField.setOpaque(false);
        genderTextField.setForeground(Color.black);
        background.add(genderTextField);
      
        JLabel enterPassword = new JLabel("Enter password:");
        enterPassword.setBounds(10, 290, 100, 35);
        Font passFont = new Font("Segoe UI", Font.BOLD, 12);
        enterPassword.setFont(passFont);
        enterPassword.setForeground(Color.white);
        background.add(enterPassword);

        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(130, 290, 250, 35);
        passwordTextField.setBackground(new Color(158, 200, 185));
        passwordTextField.setFont(new Font("Times New Roman", Font.BOLD, 12));
        passwordTextField.setOpaque(false);
        passwordTextField.setForeground(Color.black);
        background.add(passwordTextField);

        JLabel enterPassword2 = new JLabel("Re-enter password:");
        enterPassword2.setBounds(10, 340, 150, 35);
        Font repassFont = new Font("Segoe UI", Font.BOLD, 12);
        enterPassword2.setFont(repassFont);
        enterPassword2.setForeground(Color.white);
        background.add(enterPassword2);

        JTextField passwordTextField2 = new JTextField();
        passwordTextField2.setBounds(130, 340, 250, 35);
        passwordTextField2.setBackground(new Color(158, 200, 185));
        passwordTextField2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        passwordTextField2.setOpaque(false);
        passwordTextField2.setForeground(Color.black);
        background.add(passwordTextField2);

        JLabel prompLabel = new JLabel();
        prompLabel.setBounds(170, 380, 400, 35);
        Font prompFont = new Font("Segoe UI", Font.BOLD, 12);
        prompLabel.setFont(prompFont);
        prompLabel.setForeground(Color.black);
        background.add(prompLabel);
        
        JButton register = new JButton("REGISTER");
        register.setBounds(170, 410, 200, 35);
        register.setBackground(new Color(0, 0, 0));
        register.setForeground(Color.white);
        register.setFocusable(false);
        register.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(register);
        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == register){
                    String name = nameTextField.getText();
                    String age = ageTextField.getText();
                    String gender = genderTextField.getText();
                    String pass1 = passwordTextField.getText();
                    String pass2 = passwordTextField2.getText();


                    while(name.isEmpty() || age.isEmpty() || gender.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
                        prompLabel.setText("Please fill all the fields");
                        return;
                    }
                    while(!pass1.equals(pass2)){
                        prompLabel.setText("Passwords do not match");
                        return;
                    }

                    try{
                        File directory = new File("pending trainers");
                        directory.mkdirs();
                        File file = new File(directory, name + pass1 +" PENDING TRAINER.txt");
                    if(!file.exists()){
                        file.createNewFile();
                        PrintWriter print = new PrintWriter(file);
                        print.println("Coach "+ name);
                        print.println(age);
                        print.println(gender);
                        print.println(pass1);
                        print.close();
                        prompLabel.setText("Pending Registration");
                    }else{
                        prompLabel.setText("We have recieved your registration, please wait for the owner");
                    }
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                   
                    
                }
            }
        });

    }
}
   