package gym.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class GymMain{
    static JFrame frame;

    public static void main(String[] args){
        mainFrame();
    }
    public static void mainFrame(){
        frame = new JFrame();
        frame.setSize(900,500);
        frame.setLayout(null);
        mainGui();
    }
    public static void mainGui(){

     
        ImageIcon img = new ImageIcon("gymMain.jpg");
        JLabel background = new JLabel("",img,JLabel.CENTER);
        background.setSize(900, 500);
        background.setLayout(null);
        frame.add(background);
      

        JLabel devMusclesGym = new JLabel("VIGOROSO FITNESS GYM");
        devMusclesGym.setBounds(340, 20, 600, 50);
        Font welcomeFont = new Font("Constantia", Font.PLAIN, 40);
        devMusclesGym.setFont(welcomeFont);
        devMusclesGym.setForeground(Color.black);
		background.add(devMusclesGym);

        JLabel userName = new JLabel("ENTER NAME");
        userName.setBounds(470, 100, 200, 50);
        userName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        userName.setForeground(Color.black);
        background.add(userName);

        JTextField nameField = new JTextField();
        nameField.setBounds(470, 140, 300,35);
        nameField.setBackground(new Color(90,90,90));
        nameField.setFont(new Font("Times New Roman", Font.BOLD, 12));
        nameField.setForeground(Color.white);
        nameField.setOpaque(false);
        nameField.setFocusable(true);
        background.add(nameField);

        JLabel pass = new JLabel("ENTER PASSWORD");
        pass.setBounds(470, 190, 200, 50);
        pass.setFont(new Font("Times New Roman", Font.BOLD, 12));
        pass.setForeground(Color.black);
        background.add(pass);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(470, 230, 300,35);
        passField.setBackground(new Color(90,90,90));
        passField.setFont(new Font("Times New Roman", Font.BOLD, 12));
        passField.setForeground(Color.white);
        passField.setOpaque(false);
        background.add(passField);

        JLabel prompLabel = new JLabel();
        prompLabel.setBounds(470, 260, 300, 35);
        prompLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
        prompLabel.setForeground(Color.black);
        background.add(prompLabel);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(540, 300, 200, 35);
        loginBtn.setBackground(new Color(0,0,0));
        loginBtn.setForeground(Color.white);
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginBtn.setFocusable(false);
        loginBtn.setBorderPainted(false);
        background.add(loginBtn);
        LoginLogic login = new LoginLogic(loginBtn, frame, nameField, passField, prompLabel);
        loginBtn.addActionListener(login);
       

        JLabel registerLabel = new JLabel("No account yet?  ");
        registerLabel.setBounds(550, 390, 250, 35);
        Font regFont = new Font("Segoe UI", Font.BOLD, 12);
        registerLabel.setFont(regFont);
        registerLabel.setForeground(Color.black);
		background.add(registerLabel);

        JButton registerBtn = new JButton("REGISTER HERE");
        registerBtn.setBounds(615, 390, 150, 35);
        registerBtn.setBackground(new Color(0,0,0));
        registerBtn.setForeground(Color.black);
        registerBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        registerBtn.setFocusable(false);
        registerBtn.setBorderPainted(false);
        registerBtn.setOpaque(false);
        background.add(registerBtn);
        GymRegister register = new GymRegister(registerBtn, frame);
        registerBtn.addActionListener(register);




        background.setVisible(true);
        frame.setVisible(true);
    }
}

