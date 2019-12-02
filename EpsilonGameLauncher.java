/**
	Project: Epsilon Game Launcher
	This program creates a window for the Epsilon Game Launcher,
	 the main menu, center gaming area, and top menu bar
	@author Armand Wilson
	Last Edit: 11/28/19
	11/27/19
	11/26/19
	10/24/19
**/
/*
Dear Future Armand,
	You can change a Jpanel from another class by assigning it to the output of
	 a JPanel function from the game class.

	There is also a problem with changing the panel from the ActionListener class.
	Perhaps you could make classes for each game in the EpsilonGameLauncher class,
	and call them at the appropriate button presses.

	You should really read those GUI ppt slides, theres some concepts here that
	you just aren't getting. The Java GUI philosophy doesn't jive like what you've
	done before. You may even find more efficient ways of completing this
	walpurginacht.

	Sincerely,
	Armand of 11/28/19

*/
//access to games folder classes
import games.*;
import games.Bingo.Bingo;

//GUI
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

//Images
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class EpsilonGameLauncher extends JFrame
{
	private JMenuBar menuBar;
	private JMenu NewGame_menu, Quit_menu, Help_menu;
	private JButton btnTicTacToe,btnBingo,btnThreeCardPoker,btnBlackJack,btnRockPaperScissors,btnMinsweeper;
	private JPanel pMainMenu, pNorth;
	private Bingo bingoGame;

	public JPanel pCenter;
	public JFrame mainWindow;
	public EpsilonGameLauncher() throws IOException
	{
		//creates the window
		mainWindow = new JFrame();
		menuBar = new JMenuBar();
		NewGame_menu = new JMenu("New Game");
		Quit_menu = new JMenu("Help");
		Help_menu = new JMenu("Quit");

		menuBar.add(NewGame_menu);
		menuBar.add(Quit_menu);
		menuBar.add(Help_menu);

		pMainMenu = new JPanel();
		pCenter = new JPanel();
		pNorth = new JPanel();

		//button intialization for each game
		btnTicTacToe = new JButton("TicTacToe");
		btnTicTacToe.setToolTipText("Play TicTacTie");
		btnBingo = new JButton("Bingo");
		btnBingo.setToolTipText("Play Bingo");
		btnThreeCardPoker = new JButton("ThreeCardPoker");
		btnThreeCardPoker.setToolTipText("Play ThreeCardPoker");
		btnBlackJack = new JButton("BlackJack");
		btnBlackJack.setToolTipText("Play BlackJack");
		btnRockPaperScissors = new JButton("RockPaperScissors");
		btnRockPaperScissors.setToolTipText("Play Rock, Paper, Scissors");
		btnMinsweeper = new JButton("Minsweeper");
		btnMinsweeper.setToolTipText("Play Minsweeper");

		btnBingo.addActionListener(new aButtonHandler());
		btnTicTacToe.addActionListener(new aButtonHandler());
		btnBlackJack.addActionListener(new aButtonHandler());
		btnMinsweeper.addActionListener(new aButtonHandler());
		btnRockPaperScissors.addActionListener(new aButtonHandler());
		btnThreeCardPoker.addActionListener(new aButtonHandler());

		//buttons are added to the main menu
		pMainMenu.add(btnTicTacToe);
		pMainMenu.add(btnBingo);
		pMainMenu.add(btnThreeCardPoker);
		pMainMenu.add(btnBlackJack);
		pMainMenu.add(btnRockPaperScissors);
		pMainMenu.add(btnMinsweeper);

		//set mainMenu appearance
		pMainMenu.setBorder(BorderFactory.createTitledBorder("Games"));
		pMainMenu.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		pMainMenu.setLayout(new GridLayout(1,6));
		pMainMenu.setBackground(Color.white);

		//image background for Center panel
		BufferedImage image = ImageIO.read(new File("backgroundtest.jpg"));
		JLabel label = new JLabel( new ImageIcon(image));
		pCenter.add(label);
		pCenter.setBackground(Color.black);
		pCenter.setLayout(new GridLayout(1,1));

		//menuBar is placed at the top of the screen
		pNorth.setBackground(Color.white);
		pNorth.add(menuBar);

		//add the panels onto the window
		mainWindow.add(pMainMenu,"South");
		mainWindow.add(pCenter,"Center");
		mainWindow.add(pNorth,"North");

		//window settings
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainWindow.setSize((screenSize.height / 2) + 100, (screenSize.height / 2) + 100);
		mainWindow.setResizable(true);
		mainWindow.setLocation(screenSize.width / 4, screenSize.height / 4);
		mainWindow.setTitle("Epsilon Game Launcher");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//display menu
		mainWindow.show();
	}

	public class aButtonHandler implements ActionListener{
		// private EpsilonGameLauncher.aButtonHandler parentClass = this;
		// super.getClass();

		//public void getSuper() { System.out.println( this.parentClass); }
		public void actionPerformed(ActionEvent e) {
			// in here is where the code goes in response to the click
			if(e.getSource() == btnBingo) {		// Bingo Button!
				System.out.println("BINGO");
				bingoGame = new Bingo();
				bingoGame.startBingo();
			}
			else if(e.getSource() == btnTicTacToe) {		// TicTacToe Button!
				System.out.println("TicTacToe");

			}
			else if(e.getSource() == btnMinsweeper) {		// Minesweeper Button!
				System.out.println("Minesweeper");
			}
			else if(e.getSource() == btnBlackJack) {		// Black Jack Button!
				System.out.println("BlackJack");
			}
			else if(e.getSource() == btnRockPaperScissors) {		// RPS Button!
				System.out.println("RPS");
				try{
					mainWindow.setVisible(false);
					RPS newRPS = new RPS(mainWindow, pCenter);
				}
				catch(Exception IOException){
					//failed to play a game
					System.out.println("RPS Failed to open");
				}
			}
			else if(e.getSource() == btnThreeCardPoker) {		// Three Card Poker Button!
				System.out.println("Three-Card Poker");
			}

			}
		}

	public static void main(String[] args) throws IOException
	{
		EpsilonGameLauncher launcher = new EpsilonGameLauncher();
		/*
			ToDo:
				pCenter panel with a function outside of LibGui class
					this will enable a single function call for each game upon button click
					each game function would be able to update the jpanel with the appropriate GUI
						init() functions may have to take in a JPanel object as argument
				Adapt LibGui class Slick2D
		*/
	}
}
