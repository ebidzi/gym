package gym.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Member;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LoginLogic implements ActionListener{
	JButton loginBtn;
	JFrame frame;
	JTextField name;
	JPasswordField password;
	JLabel prompLabel;


	LoginLogic(JButton loginBtn, JFrame frame, JTextField name, JPasswordField password, JLabel prompLabel){
		this.loginBtn = loginBtn;
		this.frame = frame;
		this.name = name;
		this.password = password;
		this.prompLabel = prompLabel;
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == loginBtn){
			loginLogic();		
	}
}
	private void loginLogic(){
					String hardcodedUsername = "admin";
					String hardcodedPassword = "admin";
			
					String enteredUsername = name.getText();
					String enteredPassword = new String(password.getPassword());
			
					if (hardcodedUsername.equals(enteredUsername) && hardcodedPassword.equals(enteredPassword)) {
						OwnerLogin owner = new OwnerLogin(frame);
						owner.ownersPanel();
					} else {	
						File directory = new File("members");
						directory.mkdirs();
			
						String memberFilename = enteredUsername + enteredPassword + " MEMBER.txt";
						Path filePath = Paths.get(directory.getPath(), memberFilename);
					if(Files.exists(filePath)){
                         try (BufferedReader read = Files.newBufferedReader(filePath)) {
								MemberLogin member = new MemberLogin(frame, name);
								member.memberPanel();
						} catch (NoSuchFileException em) {
								prompLabel.setText("User not found");
						} catch (IOException ex) {
								prompLabel.setText("Error reading user file");
								ex.printStackTrace();
							
						}
					}
						File directory2 = new File("trainers");
						directory2.mkdirs();

						String trainerFilename = enteredUsername + enteredPassword + " TRAINER.txt";
						Path filePath2 = Paths.get(directory2.getPath(), trainerFilename);
					if(Files.exists(filePath2)){
						try(BufferedReader read2 = Files.newBufferedReader(filePath2)){
							TrainerLogin trainer = new TrainerLogin(frame, name);
							trainer.trainerPanel();
						} catch (NoSuchFileException em) {
								prompLabel.setText("User not found");
						} catch (IOException ex) {
								prompLabel.setText("Error reading user file");
								ex.printStackTrace();
							
						}
					}
						String cashierUsername = "cashier";
						String cashierPassword = "cashier";
					if(enteredUsername.equals(cashierUsername) && enteredPassword.equals(cashierPassword)){
						CashierLogin cashier = new CashierLogin(frame);
						cashier.cashierPanel();
					}
					prompLabel.setText("Incorrect username or password");
					}
	}

}

			  
			
		


	



