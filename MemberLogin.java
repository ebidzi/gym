package gym.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class MemberLogin{
   
    JFrame frame;
	String name;
	JTextField nameText;

    MemberLogin(JFrame frame, JTextField nameText){
        this.frame = frame;
		this.nameText = nameText;
    }

  
  
   
	public void memberPanel(){

		                    name = nameText.getText();
							Container ContentPane = frame.getContentPane();
							frame.getContentPane().removeAll();
							frame.getContentPane().repaint();
							frame.getContentPane().revalidate();

							ImageIcon img = new ImageIcon("gymMember.jpg");
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

							JLabel hello = new JLabel("Hello " + name +"! please choose a workout plan");
							hello.setBounds(5,50,350,50);
							Font helloFont = new Font("Segoe UI", Font.ITALIC, 14); 
							hello.setFont(helloFont);
							hello.setForeground(Color.white);
							background.add(hello);

							JButton ppl = new JButton("PUSH | PULL | LEGS");
							ppl.setBounds(90, 130, 300, 35);
							ppl.setBackground(new Color(0,0,0));
							ppl.setForeground(Color.white);
							ppl.setFocusable(false);
							ppl.setFont(new Font("Segoe UI", Font.BOLD, 14));
							background.add(ppl);
							ppl.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent er){
									if(er.getSource() == ppl){
										pushPullLegs();
									}
								}
							});

							JButton as = new JButton("ARNOLD SPLIT");
							as.setBounds(90, 230, 300, 35);
							as.setBackground(new Color(0,0,0));
							as.setForeground(Color.white);
							as.setFocusable(false);
							as.setFont(new Font("Segoe UI", Font.BOLD, 14));
							background.add(as);
							as.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent evj){
									if(evj.getSource() == as){
										arnoldSplit();
									}
								}
							});

							JButton bro = new JButton("BRO SPLIT");
							bro.setBounds(90, 330, 300, 35);
							bro.setBackground(new Color(0,0,0));
							bro.setForeground(Color.white);
							bro.setFocusable(false);
							bro.setFont(new Font("Segoe UI", Font.BOLD, 14));
							background.add(bro);
							bro.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent c){
									if(c.getSource() == bro){
										broSplit();
									}
								}
							});
						
							

							background.setVisible(true);
							frame.setVisible(true);
	}


	public void pushPullLegs(){
		Container ContentPane = frame.getContentPane();
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();

		ImageIcon img = new ImageIcon("gymMember.jpg");
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

		ImageIcon backIcon = new ImageIcon("backButton.png");
		JButton back1 = new JButton(backIcon);
        back1.setBounds(5, 5, 50, 50);
        back1.setBackground(new Color(158, 200, 185));
		back1.setFocusable(false);
		back1.setBorderPainted(false);
		back1.setOpaque(false);
        back1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(back1);
		back1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev){
				if(ev.getSource() == back1){
						Container ContentPane = frame.getContentPane();
						frame.getContentPane().removeAll();
						frame.getContentPane().repaint();
						frame.getContentPane().revalidate();
						memberPanel();
				}
			}
		});

	

		JLabel pplLabel = new JLabel("PUSH | PULL | LEGS");
        pplLabel.setBounds(50,50,200,50);
        Font devFont2 = new Font("Copperplate Gothic Bold", Font.BOLD, 16); 
        pplLabel.setFont(devFont2);
        pplLabel.setForeground(Color.black);
        background.add(pplLabel);

		JLabel day1 = new JLabel("DAY 1");
		day1.setBounds(20, 80, 200, 50);
		Font dayOne = new Font("Segoe UI", Font.BOLD,16);
		day1.setFont(dayOne);
		day1.setForeground(Color.white);
		background.add(day1);

		JLabel chest = new JLabel("CHEST,  SHOULDERS,  TRICEPS");
		chest.setBounds(70, 110, 200, 50);
		Font chestFont = new Font("Segoe UI", Font.ITALIC,14);
		chest.setFont(chestFont);
		chest.setForeground(Color.white);
		background.add(chest);

		JLabel day2 = new JLabel("DAY 2");
		day2.setBounds(20, 160, 200, 50);
		Font dayTwo = new Font("Segoe UI", Font.BOLD,16);
		day2.setFont(dayTwo);
		day2.setForeground(Color.white);
		background.add(day2);

		JLabel back = new JLabel("BACK,  BICEPS,  REAR DELTS");
		back.setBounds(70, 190, 200, 50);
		Font backFont = new Font("Segoe UI", Font.ITALIC,14);
		back.setFont(backFont);
		back.setForeground(Color.white);
		background.add(back);

		JLabel day3 = new JLabel("DAY 3");
		day3.setBounds(20, 240, 200, 50);
		Font dayThree = new Font("Segoe UI", Font.BOLD,16);
		day3.setFont(dayThree);
		day3.setForeground(Color.white);
		background.add(day3);

		JLabel legs = new JLabel("LEGS:  QUADS,  HAMSTRINGS,  GLUTES,  CALVES");
		legs.setBounds(70, 270, 350, 50);
		Font legsFont = new Font("Segoe UI", Font.ITALIC,14);
		legs.setFont(legsFont);
		legs.setForeground(Color.white);
		background.add(legs);

		JLabel day4 = new JLabel("DAY 4");
		day4.setBounds(20, 320, 200, 50);
		Font dayFour = new Font("Segoe UI", Font.BOLD,16);
		day4.setFont(dayFour);
		day4.setForeground(Color.white);
		background.add(day4);

		JLabel rest = new JLabel("REST");
		rest.setBounds(70, 350, 350, 50);
		Font restFont = new Font("Segoe UI", Font.ITALIC,14);
		rest.setFont(restFont);
		rest.setForeground(Color.white);
		background.add(rest);

		JLabel repeat = new JLabel("REPEAT");
		repeat.setBounds(190, 400, 200, 50);
		Font rep = new Font("Segoe UI", Font.BOLD,18);
		repeat.setFont(rep);
		repeat.setForeground(Color.white);
		background.add(repeat);

		background.setVisible(true);
		frame.setVisible(true);

	}

	public void arnoldSplit(){
		Container ContentPane = frame.getContentPane();
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();

		ImageIcon img = new ImageIcon("gymMember.jpg");
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

		ImageIcon backIcon = new ImageIcon("backButton.png");
		JButton back1 = new JButton(backIcon);
        back1.setBounds(5, 5, 50, 50);
        back1.setBackground(new Color(158, 200, 185));
		back1.setFocusable(false);
		back1.setBorderPainted(false);
		back1.setOpaque(false);
        back1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(back1);
		back1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev){
				if(ev.getSource() == back1){
						Container ContentPane = frame.getContentPane();
						frame.getContentPane().removeAll();
						frame.getContentPane().repaint();
						frame.getContentPane().revalidate();
						memberPanel();
				}
			}
		});

		JLabel asLabel = new JLabel("ARNOLD SPLIT");
        asLabel.setBounds(50,50,200,50);
        Font devFont2 = new Font("Copperplate Gothic Bold", Font.BOLD, 16); 
        asLabel.setFont(devFont2);
        asLabel.setForeground(Color.black);
        background.add(asLabel);

		JLabel asday1 = new JLabel("DAY 1");
		asday1.setBounds(20, 80, 200, 50);
		Font asdayOne = new Font("Segoe UI", Font.BOLD,16);
		asday1.setFont(asdayOne);
		asday1.setForeground(Color.white);
		background.add(asday1);

		JLabel chestBack = new JLabel("CHEST,  BACK");
		chestBack.setBounds(70, 110, 200, 50);
		Font chestBackFont = new Font("Segoe UI", Font.ITALIC,14);
		chestBack.setFont(chestBackFont);
		chestBack.setForeground(Color.white);
		background.add(chestBack);

		JLabel asday2 = new JLabel("DAY 2");
		asday2.setBounds(20, 160, 200, 50);
		Font asdayTwo = new Font("Segoe UI", Font.BOLD,16);
		asday2.setFont(asdayTwo);
		asday2.setForeground(Color.white);
		background.add(asday2);

		JLabel arms = new JLabel("ARMS:  SHOULDERS,  TRICEPS,  BICEPS");
		arms.setBounds(70, 190, 300, 50);
		Font armsFont = new Font("Segoe UI", Font.ITALIC,14);
		arms.setFont(armsFont);
		arms.setForeground(Color.white);
		background.add(arms);

		JLabel asday3 = new JLabel("DAY 3");
		asday3.setBounds(20, 240, 200, 50);
		Font asdayThree = new Font("Segoe UI", Font.BOLD,16);
		asday3.setFont(asdayThree);
		asday3.setForeground(Color.white);
		background.add(asday3);

		JLabel aslegs = new JLabel("LEGS:  QUADS,  HAMSTRINGS,  GLUTES,  CALVES");
		aslegs.setBounds(70, 270, 350, 50);
		Font aslegsFont = new Font("Segoe UI", Font.ITALIC,14);
		aslegs.setFont(aslegsFont);
		aslegs.setForeground(Color.white);
		background.add(aslegs);

		JLabel asday4 = new JLabel("DAY 4");
		asday4.setBounds(20, 320, 200, 50);
		Font asdayFour = new Font("Segoe UI", Font.BOLD,16);
		asday4.setFont(asdayFour);
		asday4.setForeground(Color.white);
		background.add(asday4);

		JLabel asrest = new JLabel("REST");
		asrest.setBounds(70, 350, 350, 50);
		Font asrestFont = new Font("Segoe UI", Font.ITALIC,14);
		asrest.setFont(asrestFont);
		asrest.setForeground(Color.white);
		background.add(asrest);

		JLabel asrepeat = new JLabel("REPEAT");
		asrepeat.setBounds(190, 400, 200, 50);
		Font asrep = new Font("Segoe UI", Font.BOLD,18);
		asrepeat.setFont(asrep);
		asrepeat.setForeground(Color.white);
		background.add(asrepeat);

		background.setVisible(true);
		frame.setVisible(true);
	}

	public void broSplit(){
		Container ContentPane = frame.getContentPane();
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();

		ImageIcon img = new ImageIcon("gymMember.jpg");
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

		ImageIcon backIcon = new ImageIcon("backButton.png");
		JButton back1 = new JButton(backIcon);
        back1.setBounds(5, 5, 50, 50);
        back1.setBackground(new Color(158, 200, 185));
		back1.setFocusable(false);
		back1.setBorderPainted(false);
		back1.setOpaque(false);
        back1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        background.add(back1);
		back1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev){
				if(ev.getSource() == back1){
						Container ContentPane = frame.getContentPane();
						frame.getContentPane().removeAll();
						frame.getContentPane().repaint();
						frame.getContentPane().revalidate();
						memberPanel();
				}
			}
		});

		JLabel broLabel = new JLabel("BRO SPLIT");
        broLabel.setBounds(50,30,200,50);
        Font devFont2 = new Font("Copperplate Gothic Bold", Font.BOLD, 16); 
        broLabel.setFont(devFont2);
        broLabel.setForeground(Color.black);
        background.add(broLabel);

		JLabel broday1 = new JLabel("DAY 1");
		broday1.setBounds(20, 50, 200, 50);
		Font brodayOne = new Font("Segoe UI", Font.BOLD,16);
		broday1.setFont(brodayOne);
		broday1.setForeground(Color.white);
		background.add(broday1);

		JLabel broChest = new JLabel("CHEST");
		broChest.setBounds(70, 70, 200, 50);
		Font broChestFont = new Font("Segoe UI", Font.ITALIC,14);
		broChest.setFont(broChestFont);
		broChest.setForeground(Color.white);
		background.add(broChest);

		JLabel broday2 = new JLabel("DAY 2");
		broday2.setBounds(20, 100, 200, 50);
		Font brodayTwo = new Font("Segoe UI", Font.BOLD,16);
		broday2.setFont(brodayTwo);
		broday2.setForeground(Color.white);
		background.add(broday2);

		JLabel broTriceps = new JLabel("TRICEPS");
		broTriceps.setBounds(70, 120, 300, 50);
		Font broTricepsFont = new Font("Segoe UI", Font.ITALIC,14);
		broTriceps.setFont(broTricepsFont);
		broTriceps.setForeground(Color.white);
		background.add(broTriceps);

		JLabel broday3 = new JLabel("DAY 3");
		broday3.setBounds(20, 150, 200, 50);
		Font brodayThree = new Font("Segoe UI", Font.BOLD,16);
		broday3.setFont(brodayThree);
		broday3.setForeground(Color.white);
		background.add(broday3);

		JLabel broShoulders = new JLabel("SHOULDERS");
		broShoulders.setBounds(70, 170, 350, 50);
		Font broShouldersFont = new Font("Segoe UI", Font.ITALIC,14);
		broShoulders.setFont(broShouldersFont);
		broShoulders.setForeground(Color.white);
		background.add(broShoulders);

		JLabel broday4 = new JLabel("DAY 4");
		broday4.setBounds(20, 200, 200, 50);
		Font brodayFour = new Font("Segoe UI", Font.BOLD,16);
		broday4.setFont(brodayFour);
		broday4.setForeground(Color.white);
		background.add(broday4);

		JLabel broBack = new JLabel("BACK");
		broBack.setBounds(70, 220, 350, 50);
		Font broBackFont = new Font("Segoe UI", Font.ITALIC,14);
		broBack.setFont(broBackFont);
		broBack.setForeground(Color.white);
		background.add(broBack);

		JLabel broday5 = new JLabel("DAY 5");
		broday5.setBounds(20, 250, 200, 50);
		Font brodayFive = new Font("Segoe UI", Font.BOLD,16);
		broday5.setFont(brodayFive);
		broday5.setForeground(Color.white);
		background.add(broday5);

		JLabel broBiceps = new JLabel("BICEPS");
		broBiceps.setBounds(70, 270, 350, 50);
		Font broBicepsFont = new Font("Segoe UI", Font.ITALIC,14);
		broBiceps.setFont(broBicepsFont);
		broBiceps.setForeground(Color.white);
		background.add(broBiceps);

		JLabel broday6 = new JLabel("DAY 6");
		broday6.setBounds(20, 300, 200, 50);
		Font brodaySix = new Font("Segoe UI", Font.BOLD,16);
		broday6.setFont(brodaySix);
		broday6.setForeground(Color.white);
		background.add(broday6);

		JLabel broLegs = new JLabel("LEGS");
		broLegs.setBounds(70, 320, 350, 50);
		Font broLegsFont = new Font("Segoe UI", Font.ITALIC,14);
		broLegs.setFont(broLegsFont);
		broLegs.setForeground(Color.white);
		background.add(broLegs);

		JLabel broday7 = new JLabel("DAY 7");
		broday7.setBounds(20, 350, 200, 50);
		Font brodaySeven = new Font("Segoe UI", Font.BOLD,16);
		broday7.setFont(brodaySeven);
		broday7.setForeground(Color.white);
		background.add(broday7);

		JLabel broRest = new JLabel("REST");
		broRest.setBounds(70, 370, 350, 50);
		Font broRestFont = new Font("Segoe UI", Font.ITALIC,14);
		broRest.setFont(broRestFont);
		broRest.setForeground(Color.white);
		background.add(broRest);

		JLabel brorepeat = new JLabel("REPEAT");
		brorepeat.setBounds(190, 400, 200, 50);
		Font brorep = new Font("Segoe UI", Font.BOLD,18);
		brorepeat.setFont(brorep);
		brorepeat.setForeground(Color.white);
		background.add(brorepeat);

		background.setVisible(true);
		frame.setVisible(true);
	}

	

}