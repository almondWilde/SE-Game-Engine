import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class EpsilonGameLauncher extends JFrame
{
	private JMenuBar menuBar;
	private JMenu NewGame_menu, Quit_menu, Help_menu;
	private JButton btnTicTacToe,btnBingo,btnThreeCardPoker,btnBlackJack,btnRockPaperScissors,btnMinsweeper;
	private JPanel pMain, pSouth, pNorth, pCenter;

	public EpsilonGameLauncher() throws IOException
	{
		menuBar = new JMenuBar();
		NewGame_menu = new JMenu("New Game");
		Quit_menu = new JMenu("Help");
		Help_menu = new JMenu("Quit");

		//menuBar.add(NewGame_menu);
		menuBar.add(Quit_menu);
		menuBar.add(Help_menu);

		pMain = new JPanel();
		pCenter = new JPanel();
		pNorth = new JPanel();
		pSouth = new JPanel();

		//button intialization
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

		pMain.add(btnTicTacToe);
		pMain.add(btnBingo);
		pMain.add(btnThreeCardPoker);
		pMain.add(btnBlackJack);
		pMain.add(btnRockPaperScissors);
		pMain.add(btnMinsweeper);		

		pMain.setLayout(new BoxLayout(pMain,BoxLayout.X_AXIS));
		pMain.setBorder(BorderFactory.createTitledBorder("Games"));
		pMain.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		pMain.setLayout(new GridLayout(1,6));
		pMain.setBackground(Color.white);

		BufferedImage image = ImageIO.read(new File("backgroundtest.jpg"));
		JLabel label = new JLabel( new ImageIcon(image));
		pCenter.add(label);
		pCenter.setBackground(Color.black);
		pCenter.setLayout(new GridLayout(1,1));

		pNorth.setBackground(Color.white);
		pNorth.add(menuBar);

		this.add(pMain,"South");
		this.add(pCenter,"Center");
		this.add(pNorth,"North");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width / 2, screenSize.height / 2);
		this.setResizable(true);
		this.setLocation(40,0);
		this.setTitle("Epsilon Game Launcher");
		this.show();
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