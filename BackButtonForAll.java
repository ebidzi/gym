package gym.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class BackButtonForAll implements ActionListener{
    JButton back;
    JFrame frame;

        BackButtonForAll(JButton back, JFrame frame){
            this.back = back;
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == back){
                Container ContentPane = frame.getContentPane();
                frame.getContentPane().removeAll();
                frame.getContentPane().repaint();
                frame.getContentPane().revalidate();

                GymMain.mainGui();
            }
        }
}