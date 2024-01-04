package gym.system;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class GymRegister implements ActionListener{
    JButton register;
    JFrame frame;
    
    GymRegister(JFrame frame){
        this.frame = frame;
    }
    
    GymRegister(JButton register, JFrame frame){
        this.register = register;
        this.frame = frame;    
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == register){
            registerPanel();
        }
    }
    public void registerPanel(){

        Container ContentPane = frame.getContentPane();
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();

        ImageIcon img = new ImageIcon("gymRegister.jpg");
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

        JButton member = new JButton("MEMBERSHIP REGISTRATION");
        member.setBounds(300, 150, 300, 35);
        member.setBackground(new Color(0,0,0));
        member.setForeground(Color.white);
        member.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(member);
        MemberRegister mem = new MemberRegister(member, frame);
        member.addActionListener(mem);

        JButton trainer = new JButton("TRAINER REGISTRATION");
        trainer.setBounds(300, 250, 300, 35);
        trainer.setBackground(new Color(0,0,0));
        trainer.setForeground(Color.white);
        trainer.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(trainer);
        TrainerRegister tren = new TrainerRegister(trainer, frame);
        trainer.addActionListener(tren);


        ImageIcon backIcon = new ImageIcon("backButton.png");
        JButton cancel = new JButton("");
        cancel.setBounds(10,400,70,50);
        cancel.setBackground(new Color(0,0,0));
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancel.setIcon(backIcon);
        cancel.setFocusable(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(false);
        background.add(cancel);
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evj){
                if(evj.getSource() == cancel){
                     Container ContentPane = frame.getContentPane();
                     frame.getContentPane().removeAll();
                     frame.getContentPane().repaint();
                     frame.getContentPane().revalidate();

                     GymMain.mainGui();
                }
            }
        });


        background.setVisible(true);
        frame.setVisible(true);
    }
}