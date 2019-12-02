package games;

//import EpsilonGameLauncher.*;

//RPS dependencies
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

//GUI dependecies
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

//GUI
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

//Images
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Player{
	private String weapon; /* A: Rock B: Paper C: Scissors */
	private boolean isUser;

	Player(boolean isUser){
		this.isUser = isUser;
		this.weapon = "";
		//
		// Scanner scan = new Scanner(System.in);
		// boolean valid = false;
		//
		//
		// //not user
		// if(!this.isUser)
		// {
		// 	System.out.println("cpu flag");
		// 	Random rand = new Random();
		// 	int randint = rand.nextInt(3);
		// 	switch( randint ){
		// 		case 0:
		// 			this.weapon = "A";	//Rock
		// 			break;
		// 		case 1:
		// 			this.weapon = "B";	//Paper
		// 			break;
		// 		case 2:
		// 			this.weapon = "C";	//Scissors
		// 			break;
		// 	}
		//
		// 	System.out.println("cpu weapon" + this.weapon);
		// }
		// else{
		// 	System.out.println("user flag");
		// 	//is user
		// 	String user_weapon = "";
		// 	do{
		// 		System.out.println("Choose your Weapon!\nA) Rock\nB) Paper\nC) Scissors\n\n");
		// 		weapon = scan.nextLine();
		// 		weapon.toUpperCase();
		//
		// 		valid = weapon.matches("[A-C,a-c]+");
		// 		if(!valid){
		// 			System.out.println("Invalid Weapon Choice! Choose another weapon..!\n\n");
		// 		}
		// 	}
		// 	while(!valid);
		// 	this.weapon = weapon;
		// }
	}
	public String getWeapon() { return this.weapon; }
	public void setWeapon(String weapon) {this.weapon = weapon;}
}


class InitialScreen extends JFrame{
	private JButton btnPlay, btnReturn;
	private JPanel optionsPanel;

	InitialScreen()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		optionsPanel = new JPanel();
		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new aButtonHandler());
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new aButtonHandler());

		setSize(300, 100);
		setResizable(true);
		setLocation(40,0);
		setTitle("Play?");
		setBackground(Color.orange);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(btnPlay);
		add(btnReturn);
		optionsPanel.add(btnPlay);
		optionsPanel.add(btnReturn);
		optionsPanel.setBackground(Color.blue);
		add(optionsPanel);
		setLocation(screenSize.width / 5, screenSize.height / 5);
	}

	public class aButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnPlay){		// Bingo Button!
				setVisible(false);
				RPSPlayFrame playRPS = new RPSPlayFrame();
			}
			else if(e.getSource() == btnReturn){
				setVisible(false);
			}
		}
	}
}

class RPSPlayFrame extends JFrame{
	private static Player user, cpu;
	private JButton btnShoot;
	private ButtonGroup userWeapons;
	private JRadioButton btnRock, btnPaper, btnScissors;
	private JPanel pWeaponsOptions, pRPSEast, pRPSCenter;
	private BufferedImage userWeaponImage;
	private JLabel userWeaponLabel;
	private Hashtable<String, JLabel> weaponImages;
	private String weaponOfChoice;
	public JPanel pRPSWest;

	public RPSPlayFrame(){
		setBackground(Color.white);
		weaponImages = new Hashtable<String, JLabel>();
		user = new Player(true);
		cpu = new Player(false);
		weaponOfChoice = "";
		pRPSWest = new JPanel();
		pRPSWest.setLayout(new FlowLayout());

		// try{
		// 	userWeaponImage = ImageIO.read(new File("rock.jpeg"));
		// 	userWeaponLabel = new JLabel( new ImageIcon(userWeaponImage));
		// 	weaponImages.put("Rock", userWeaponLabel);
		//
		// 	userWeaponImage = ImageIO.read(new File("paper.png"));
		// 	userWeaponLabel = new JLabel( new ImageIcon(userWeaponImage));
		// 	weaponImages.put("Paper", userWeaponLabel);
		//
		// 	userWeaponImage = ImageIO.read(new File("scissors.png"));
		// 	userWeaponLabel = new JLabel( new ImageIcon(userWeaponImage));
		// 	weaponImages.put("Scissors", userWeaponLabel);
		// }
		// catch(Exception ioe){System.out.println("failed to load images");}

		userWeaponLabel = new JLabel();
		btnShoot = new JButton("Shoot!");
		btnRock = new JRadioButton("Rock");
		btnPaper = new JRadioButton("Paper");
		btnScissors = new JRadioButton("Scissors");
		userWeapons = new ButtonGroup();

		userWeapons.add(btnRock);
		userWeapons.add(btnPaper);
		userWeapons.add(btnScissors);

		pWeaponsOptions = new JPanel();
		pWeaponsOptions.setBorder(BorderFactory.createTitledBorder("Choose Your Weapon!"));
//		pWeaponsOptions.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		pWeaponsOptions.setLayout(new GridLayout(1,4));
		pWeaponsOptions.add(btnRock);
		pWeaponsOptions.add(btnPaper);
		pWeaponsOptions.add(btnScissors);
		pWeaponsOptions.add(btnShoot);

		btnRock.addActionListener(new aButtonHandler(userWeaponLabel, user));
		btnPaper.addActionListener(new aButtonHandler(userWeaponLabel, user));
		btnShoot.addActionListener(new aButtonHandler(userWeaponLabel, user));
		btnScissors.addActionListener(new aButtonHandler(userWeaponLabel, user));

		pRPSWest.add(userWeaponLabel);
		add(pWeaponsOptions, "South");
		add(pRPSWest, "West");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 4, screenSize.height / 4);
		setSize(screenSize.width / 2, screenSize.height / 2);
		setResizable(true);
		setTitle("Rock, Paper, Scissors!");

		setVisible(true);

	}

	public class aButtonHandler implements ActionListener{
		private JLabel transferLabel;
		private Player user;

		aButtonHandler(JLabel transferLabel, Player user)
		{
			this.transferLabel = transferLabel;
			this.user = user;
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnShoot)
			{
				if(btnRock.isSelected())
				{
					user.setWeapon("Rock");
					System.out.println("rock");
					try{
						userWeaponImage = ImageIO.read(new File("rock.jpeg"));
						transferLabel.setIcon( new ImageIcon(userWeaponImage));
					}
					catch(IOException ioe)
					{
						System.out.println("rock image failed to load");
					}
				}
				else if(btnPaper.isSelected())
				{
					user.setWeapon("Paper");
					try{
						userWeaponImage = ImageIO.read(new File("paper.png"));
						transferLabel.setIcon( new ImageIcon(userWeaponImage));
					}
					catch(IOException ioe)
					{
						System.out.println("paper image failed to load");
					}
				}
				else if(btnScissors.isSelected())
				{
					user.setWeapon("Scissors");
					try{
						userWeaponImage = ImageIO.read(new File("scissors.png"));
						transferLabel.setIcon( new ImageIcon(userWeaponImage));
					}
					catch(IOException ioe)
					{
						System.out.println("scissors image failed to load");
					}
				}
			}
			//pRPSWest.add(weaponImages.get(weaponOfChoice));
		}
	}
}

public class RPS{
	private boolean cont_bool;
	private String cont_response;
	private Scanner cont_scanner;

	private JPanel pInit;
	private JButton btnPlay, btnMainMenu;

	public RPS(JFrame mainWindow, JPanel pCenter) throws IOException{
		//Rock, Paper, Scissors game start
		//init screen
		// pInit = new JPanel();
		// pInit.add()
		// add(pInit,"West");
		InitialScreen init = new InitialScreen();
		init.show();


		//terminal game play
		// cont_scanner = new Scanner(System.in);
		// do{
		// 	//set up radio buttons group
		// 	//create a mutator for Player.Weapon
		// 	//as user clicks a weapon on screen, initailize the value of weapon
		// 	this.user = new Player(true);
		// 	this.cpu = new Player(false);
		//
		// 	System.out.println( this.battle(user, cpu) );
		//
		// 	do{
		// 		//pop up window
		// 		System.out.println( "Do you want to play again? [Y/N] ");
		// 		cont_response = cont_scanner.nextLine();
		// 		cont_response = cont_response.toUpperCase();
		//
		// 		if(cont_response.equals("Y"))
		// 			cont_bool = true;
		// 		else if( cont_response.equals("N") )
		// 			cont_bool = false;
		//
		// 	}while(!cont_response.equals("Y") && !cont_response.equals("N") );
		//
		// }while(cont_bool);
	}



	// public JPanel testPanelChange(JPanel test) throws IOException
	// {
	// 	test = new JPanel();
	// 	//background screen, set panel background
	// 	BufferedImage image = ImageIO.read(new File("RPS_initScreen.jpg"));
	// 	JLabel label = new JLabel( new ImageIcon(image));
	//
	// 	ButtonGroup weapons = new ButtonGroup();
	// 	JRadioButton rock_radiobtn = new JRadioButton("Rock");
	// 	JRadioButton paper_radiobtn = new JRadioButton("paper");
	// 	JRadioButton scissors_radiobtn = new JRadioButton("scissors");
	// 	weapons.add(rock_radiobtn);
	// 	weapons.add(paper_radiobtn);
	// 	weapons.add(scissors_radiobtn);
	//
	// 	ButtonGroup enemyWeapons = new ButtonGroup();
	// 	JRadioButton rock_radiobtn2 = new JRadioButton("Rock");
	// 	JRadioButton paper_radiobtn2 = new JRadioButton("paper");
	// 	JRadioButton scissors_radiobtn2 = new JRadioButton("scissors");
	// 	enemyWeapons.add(rock_radiobtn);
	// 	enemyWeapons.add(paper_radiobtn);
	// 	enemyWeapons.add(scissors_radiobtn);
	//
	//
	// 	test.add(rock_radiobtn);
	// 	test.add(paper_radiobtn);
	// 	test.add(scissors_radiobtn);
	// 	test.add(rock_radiobtn2);
	// 	test.add(paper_radiobtn2);
	// 	test.add(scissors_radiobtn2);
	//
	// 	return test;
	// }

	/*
		A - Rock
		B - Paper
		C - Scissors
	*/
	public static String battle(Player user, Player cpu){
		String[] returnMessage = {"DRAW", "USER WINS", "CPU WINS", "ERROR ERROR TRY AGAIN"};
		String uw = user.getWeapon().toUpperCase(), cw = cpu.getWeapon().toUpperCase();

			if( uw.equals( cw ) )
				return returnMessage[0];
			else if( cw.equals("Rock") ){		//cpu has a rock
				if(uw.equals("Paper"))		//user has paper; user wins
					return returnMessage[1];
				else if(uw.equals("Scissors"))		//user has scissors; user loses
					return returnMessage[2];
			}
			else if( cw.equals("Paper") ){		//cpu has paper
				if(uw.equals("Rock"))		//user has rock; user loses
					return returnMessage[2];
				else if(uw.equals("Scissors"))		//user has scissors; user wins
					return returnMessage[1];
			}
			else if( cw.equals("Scissors") ){		//cpu has scissors
				if(uw.equals("Rock"))		//user has rock; user wins
					return returnMessage[1];
				else if(uw.equals("Paper"))		//user has paper; user loses
					return returnMessage[2];
			}
			return returnMessage[3];
	}

	// public static void main(String[] args)throws NullPointerException{
	// 	// RPS newRPS = new RPS();
	// 	// newRPS.start();
	// }
}
