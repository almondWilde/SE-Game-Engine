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
	public boolean getIsUser() { return isUser;}
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
		setLocation(screenSize.width / 3+100, screenSize.height / 3);
	}

	public class aButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnPlay){		// Bingo Button!
				setVisible(false);
				try{
					RPSPlayFrame playRPS = new RPSPlayFrame();
				}
				catch(IOException ioe){}
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
	private JPanel pWeaponsOptions, pRPSEast, pRPSNorth, pRPSWest;
	private BufferedImage userWeaponImage, cpuWeaponImage;
	private JLabel userWeaponLabel, cpuWeaponLabel, vsLabel, victorLabel;
	private String weaponOfChoice;
	public JPanel pRPSCenter;

	public RPSPlayFrame() throws IOException{
		setBackground(Color.white);
		victorLabel = new JLabel("Rock, Paper, Scisors!");
		userWeaponLabel = new JLabel();
		user = new Player(true);
		cpu = new Player(false);
		weaponOfChoice = "";
		pRPSCenter= new JPanel();
		pRPSNorth= new JPanel();
		pWeaponsOptions = new JPanel();
		pRPSWest = new JPanel();
		pRPSEast = new JPanel();
		pRPSCenter.setLayout(new FlowLayout(FlowLayout.CENTER));

		vsLabel = new JLabel("VS");
		vsLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		cpuWeaponLabel = new JLabel();

		btnShoot = new JButton("Shoot!");
		btnRock = new JRadioButton("Rock");
		btnPaper = new JRadioButton("Paper");
		btnScissors = new JRadioButton("Scissors");
		userWeapons = new ButtonGroup();

		userWeapons.add(btnRock);
		userWeapons.add(btnPaper);
		userWeapons.add(btnScissors);
		pWeaponsOptions.setBorder(BorderFactory.createTitledBorder("Choose Your Weapon!"));
		pWeaponsOptions.setLayout(new GridLayout(1,4));
		pWeaponsOptions.add(btnRock);
		pWeaponsOptions.add(btnPaper);
		pWeaponsOptions.add(btnScissors);
		pWeaponsOptions.add(btnShoot);

		btnRock.addActionListener(new aButtonHandler(userWeaponLabel, cpuWeaponLabel, user, cpu, victorLabel));
		btnPaper.addActionListener(new aButtonHandler(userWeaponLabel, cpuWeaponLabel, user, cpu, victorLabel));
		btnShoot.addActionListener(new aButtonHandler(userWeaponLabel, cpuWeaponLabel, user, cpu, victorLabel));
		btnScissors.addActionListener(new aButtonHandler(userWeaponLabel, cpuWeaponLabel, user, cpu, victorLabel));

		pRPSCenter.add(userWeaponLabel);
		pRPSCenter.add(vsLabel);
		pRPSCenter.add(cpuWeaponLabel);

		pRPSNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
		pRPSNorth.add(victorLabel);

		pRPSWest.add(new JLabel("Player1"));
		pRPSEast.add(new JLabel("CPU"));

		add(pRPSEast, "East");
		add(pRPSWest, "West");
		add(pRPSNorth, "North");
		add(pWeaponsOptions, "South");
		add(pRPSCenter, "Center");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 4, screenSize.height / 4);
		setSize((screenSize.height / 2)+100, screenSize.width / 2);
		setResizable(true);
		setTitle("Rock, Paper, Scissors!");

		setVisible(true);

	}
	public String decideWinner(Player user, Player cpu)
	{
		String[] returnMessage = {"DRAW", "USER WINS", "CPU WINS", "ERROR TRY AGAIN"};
		String uw = user.getWeapon(), cw = cpu.getWeapon();

			if( uw.equals( cw ) )
				return returnMessage[0];
			else if( cw.equals("Rock") ){		//cpu has a rock
				System.out.print(uw);
				if(uw.equals("Paper"))		//user has paper; user wins
					return returnMessage[1];
				else if(uw.equals("Scissors"))		//user has scissors; user loses
					return returnMessage[2];
			}
			else if( cw.equals("Paper") ){		//cpu has paper
				System.out.print(uw);
				if(uw.equals("Rock"))		//user has rock; user loses
					return returnMessage[2];
				else if(uw.equals("Scissors"))		//user has scissors; user wins
					return returnMessage[1];
			}
			else if( cw.equals("Scissors") ){		//cpu has scissors
				System.out.print(uw);
				if(uw.equals("Rock"))		//user has rock; user wins
					return returnMessage[1];
				else if(uw.equals("Paper"))		//user has paper; user loses
					return returnMessage[2];
			}
			System.out.println(cw);

			return returnMessage[3];
	}
	public JLabel cpuChooseWeapon(Player cpu, JLabel cpuWeaponLabel) throws IOException{
		if(!cpu.getIsUser()){
				Random rand = new Random();
				int randint = rand.nextInt(3);
				switch( randint ){
					case 0:
						cpu.setWeapon("Rock");	//Rock
						System.out.println("cpu selected rock");
						cpuWeaponImage = ImageIO.read(new File("rock.jpeg"));
						cpuWeaponLabel.setIcon( new ImageIcon(cpuWeaponImage));
						cpuWeaponLabel.setText("Rock");
						break;
					case 1:
						cpu.setWeapon("Paper");	//Paper
						System.out.println("cpu selected paper");
						cpuWeaponImage = ImageIO.read(new File("paper.jpeg"));
						cpuWeaponLabel.setIcon( new ImageIcon(cpuWeaponImage));
						cpuWeaponLabel.setText("Paper");
						break;
					case 2:
						cpu.setWeapon("Scissors");	//Scissors
						System.out.println("cpu selected scissors");
						cpuWeaponImage = ImageIO.read(new File("scissors.jpeg"));
						cpuWeaponLabel.setIcon( new ImageIcon(cpuWeaponImage));
						cpuWeaponLabel.setText("Scissors");
						break;
				}
		}
		return cpuWeaponLabel;
	}
	public class aButtonHandler implements ActionListener{
		private JLabel userWeaponLabel, cpuWeaponLabel, victorLabel;
		private Player user, cpu;

		aButtonHandler(JLabel userWeaponLabel, JLabel cpuWeaponLabel, Player user, Player cpu, JLabel victorLabel)
		{
			this.userWeaponLabel = userWeaponLabel;
			this.cpuWeaponLabel = cpuWeaponLabel;
			this.victorLabel = victorLabel;
			this.user = user;
			this.cpu = cpu;
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnShoot)
			{
				if(btnRock.isSelected())
				{
					user.setWeapon("Rock");
					userWeaponLabel.setText("Rock");
					System.out.println("user selected rock");

					try{
						userWeaponImage = ImageIO.read(new File("rock.jpeg"));
						userWeaponLabel.setIcon( new ImageIcon(userWeaponImage));

					}
					catch(IOException ioe)
					{
						System.out.println("rock image failed to load");
					}
				}
				else if(btnPaper.isSelected())
				{
					user.setWeapon("Paper");
					System.out.println("user selected paper");
					userWeaponLabel.setText("nPaper");

					try{
						userWeaponImage = ImageIO.read(new File("paper.jpeg"));
						userWeaponLabel.setIcon( new ImageIcon(userWeaponImage));
					}
					catch(IOException ioe)
					{
						System.out.println("paper image failed to load");
					}
				}
				else if(btnScissors.isSelected())
				{
					user.setWeapon("Scissors");
					System.out.println("user selected scissors");
					userWeaponLabel.setText("Scissors");

					try{
						userWeaponImage = ImageIO.read(new File("scissors.jpeg"));
						userWeaponLabel.setIcon( new ImageIcon(userWeaponImage));

					}
					catch(IOException ioe)
					{
						System.out.println("scissors image failed to load");
					}
				}
				try{
					cpuWeaponLabel = cpuChooseWeapon(cpu, cpuWeaponLabel);
					cpu.setWeapon(cpuWeaponLabel.getText());
				}
				catch(IOException ioe){System.out.println(ioe);}

				victorLabel.setText("Winner is: ");
				victorLabel.setText( victorLabel.getText() + decideWinner(user, cpu));

			}
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
