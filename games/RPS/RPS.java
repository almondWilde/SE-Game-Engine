package games;

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

/**
	Represents a player playing Rock Paper Scissors as either
	a cpu or a human
	@author Armand Wilson
**/
class Player{
	/**
		a string representing the weapon as "Rock", "Paper", or "Scissors"
		@author Armand Wilson
	**/
	private String weapon;
	/**
		determine how the Player will choose their weapon
		@author Armand Wilson
	**/
	private boolean isUser, terminalPlay;
	/**
		Player constructor. Controls weapon declaration.
		@author Armand Wilson
		@param isUser signifyies weather a Player is a human user
		@param terminalPlay signifies weather the game will be ran from terminal
	**/
	Player(boolean isUser, boolean terminalPlay)
	{
		this.isUser = isUser;	//user or cpu
		this.weapon = "";			//initialized to an empty String
		this.terminalPlay = terminalPlay;	//will the user play from the terminal?

		Scanner scan = new Scanner(System.in);
		boolean valid = false;

		//not user
		//choose weapon by random
		if(!this.isUser)
		{
			System.out.println("cpu flag");
			Random rand = new Random();
			int randint = rand.nextInt(3);
			switch( randint ){
				case 0:
					this.weapon = "A";	//Rock
					break;
				case 1:
					this.weapon = "B";	//Paper
					break;
				case 2:
					this.weapon = "C";	//Scissors
					break;
			}

			System.out.println("cpu weapon" + this.weapon);
		}
		//is user
		//prompt user for weapon options, scan and save
		else{
			System.out.println("user flag");
			//is user
			String user_weapon = "";
			do{
				System.out.println("Choose your Weapon!\nA) Rock\nB) Paper\nC) Scissors\n\n");
				weapon = scan.nextLine();
				weapon.toUpperCase();

				valid = weapon.matches("[A-C,a-c]+");
				if(!valid){
					System.out.println("Invalid Weapon Choice! Choose another weapon..!\n\n");
				}
			}
			while(!valid);
			this.weapon = weapon;
		}
	}
	/**
		Constructor for Player class. Used for GUI application.
		@author Armand Wilson
		@param isUser signifies weather the player is a human user
	**/
	Player(boolean isUser){
		this.isUser = isUser;	//
		this.weapon = "";
	}
	/**
		Accesses weapon value for this Player
		@author Armand Wilson
		@return weapon value for this Player
	**/
	public String getWeapon() { return this.weapon; }
	/**
		Accesses isUser value for this Player
		@author Armand Wilson
		@return isUser value for this Player
	**/
	public boolean getIsUser() { return isUser;}
	/**
		Mutates weapon value for this Player
		@author Armand Wilson
		@param weapon weapon with string value: "Rock", "Paper", "Scissors"
	**/
	public void setWeapon(String weapon) {this.weapon = weapon;}
}
/**
	Represents a pop-up window to paly RPS in GUI or in terminal, or to return to Main Menu
	@author Armand Wilson
**/
class InitialScreen extends JFrame{
	/**
		Buttons to navigate to desired game platform
		@author Armand Wilson
	**/
	private JButton btnPlay, btnReturn, btnTerminalPlay;
	private JPanel optionsPanel;
	/**
		Constructor for InitialScreen class. Creates and shows the window,
		initializes Rock Paper Scissors Games
		@author Armand Wilson
	**/
	InitialScreen()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		optionsPanel = new JPanel();
		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new aButtonHandler());
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new aButtonHandler());
		btnTerminalPlay = new JButton("Terminal Play");
		btnTerminalPlay.addActionListener(new aButtonHandler());


		setSize(300, 100);
		setResizable(true);
		setLocation(40,0);
		setTitle("Play?");
		setBackground(Color.orange);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(btnPlay);
		add(btnReturn);
		add(btnTerminalPlay);
		optionsPanel.add(btnPlay);
		optionsPanel.add(btnReturn);
		optionsPanel.add(btnTerminalPlay);
		optionsPanel.setBackground(Color.blue);
		add(optionsPanel);
		setLocation(screenSize.width / 3+100, screenSize.height / 3);
	}
	/**
		Action Listener for InitialScreen buttons
		@author Armand Wilson
	**/
	public class aButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnPlay){		//Play button listener
				setVisible(false);
				try{
					RPSPlayFrame playRPS = new RPSPlayFrame();	//Play Rock Paper Scissors
				}
				catch(IOException ioe){}
			}
			else if(e.getSource() == btnReturn){	//Return button listener
				setVisible(false);
			}
			else if(e.getSource() == btnTerminalPlay){	//Terminal Play button listener
				RPSTerminalPlay playRPSTerminal = new RPSTerminalPlay();
			}
		}
	}
}
/**
	Represents Rock Paper Scissors terminal
	@author Armand Wilson
**/
class RPSTerminalPlay{
	/**
		controls continuous play
		@author Armand Wilson
	**/
	private boolean cont_bool;
	/**
		value verification flag
		@author Armand Wilson
	**/
	private String cont_response;
	/**
		Receives user will to contiue playing
		@author Armand Wilson
	**/
	private Scanner cont_scanner;
	/**
		Players playing the game
		@author Armand Wilson
	**/
	private Player user, cpu;

	/**
		Constructor for RPSTerminalPlay.
		@author Armand Wilson
	**/
	public RPSTerminalPlay(){
    cont_scanner = new Scanner(System.in);
    do{
			/**
				Players choose weapon in Player constructor
			**/
    	this.user = new Player(true,true);
    	this.cpu = new Player(false,true);
			/**
				Display RPS game results
			**/
    	System.out.println( decideWinner(user, cpu) );

    	do{
    		//pop up window
    		System.out.println( "Do you want to play again? [Y/N] ");
    		cont_response = cont_scanner.nextLine();
    		cont_response = cont_response.toUpperCase();

    		if(cont_response.equals("Y"))
    			cont_bool = true;
    		else if( cont_response.equals("N") )
    			cont_bool = false;

    	}while(!cont_response.equals("Y") && !cont_response.equals("N") );

    }while(cont_bool);
	}
	/**
		Runs RPS game logic with 2 Players
		@author Armand Wilson
		@return game results String value
	**/
	public String decideWinner(Player user, Player cpu)
	{
		/**
			Possible game result outputs
		**/
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

			/**
				Error Message
			**/
			return returnMessage[3];
	}
}
/**
	RPS GUI gameplay
	@author Armand Wilson
**/
class RPSPlayFrame extends JFrame{
	/**
		Players playing the game
		@author Armand Wilson
	**/
	private static Player user, cpu;
	/**
		Buttons to navigate the RPS gmae
		@author Armand Wilson
	**/
	private JButton btnShoot;
	private ButtonGroup userWeapons;
	private JRadioButton btnRock, btnPaper, btnScissors;
	/**
		Panels that make of the RPS game screen
		@author Armand Wilson
	**/
	private JPanel pWeaponsOptions, pRPSEast, pRPSNorth, pRPSWest;
	/**
		Used for making labels in panels =
		@author Armand Wilson
	**/
	private BufferedImage userWeaponImage, cpuWeaponImage;
	private JLabel userWeaponLabel, cpuWeaponLabel, vsLabel, victorLabel;
	private String weaponOfChoice;
	public JPanel pRPSCenter;
	/**
		Creates and shows the RPS game GUI and initializes all GUI objects
		@author Armand Wilson
		@throws IOException
	**/
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

		/**
			creates buttons
		**/
		btnShoot = new JButton("Shoot!");
		btnRock = new JRadioButton("Rock");
		btnPaper = new JRadioButton("Paper");
		btnScissors = new JRadioButton("Scissors");
		userWeapons = new ButtonGroup();

		/**
		groups the weapon options buttons together
		**/
		userWeapons.add(btnRock);
		userWeapons.add(btnPaper);
		userWeapons.add(btnScissors);
		pWeaponsOptions.setBorder(BorderFactory.createTitledBorder("Choose Your Weapon!"));
		pWeaponsOptions.setLayout(new GridLayout(1,4));
		pWeaponsOptions.add(btnRock);
		pWeaponsOptions.add(btnPaper);
		pWeaponsOptions.add(btnScissors);
		pWeaponsOptions.add(btnShoot);

		/**
			button listeners
		**/
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
	/**
		Implements game ligic on two players and outputs results to String
		@author Armand Wilson
		@return String value output for RPS GUI game logic
	**/
	public String decideWinner(Player user, Player cpu)
	{
		/**
			Game logic outputs statements
		**/
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
	/**
		Choose cpu Player weapon for GUI application
		@author Armand Wilson
		@throws IOException
		@return JLabel icon that represents cpu weapon
	**/
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
	/**
		Handlers buttons for RPS GUI application
		@author Armand Wilson
	**/
	public class aButtonHandler implements ActionListener{
		/**
			JLabels that change when buttons are pressed
			@author Armand Wilson
		**/
		private JLabel userWeaponLabel, cpuWeaponLabel, victorLabel;
		private Player user, cpu;
		/**
			Button handler constructor
			@author Armand Wilson
		**/
		aButtonHandler(JLabel userWeaponLabel, JLabel cpuWeaponLabel, Player user, Player cpu, JLabel victorLabel)
		{
			this.userWeaponLabel = userWeaponLabel;
			this.cpuWeaponLabel = cpuWeaponLabel;
			this.victorLabel = victorLabel;
			this.user = user;
			this.cpu = cpu;
		}
		/**
			perform actions when a button is pressed in RPS GUI
			@author Armand Wilson
			@param e represents onClick() action to RPS GUI buttons
		**/
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
					userWeaponLabel.setText("Paper");

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
/**
	Represents the initiation of a Rock Paper Scissors game
	@author Armand Wilson
**/
public class RPS{
	/**
		Constutor for RPS class
		@author Armand Wilson
		@param mainWindow the frame that this class was called in
		@param JPanel the panel this class can manipulate
		@throws IOException
	**/
	public RPS(JFrame mainWindow, JPanel pCenter) throws IOException{
		/**
			launch initial screen
		**/
		InitialScreen init = new InitialScreen();
		init.show();
	}
}
