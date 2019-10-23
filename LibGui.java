import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class LibGui extends JFrame
{
	private JMenuBar menuBar;
	private JMenu m1,m2,m3;
	private JMenuItem TicTacToe,Bingo,BlackJack,ThreeCardPoker,Minsweeper,RoPaSc,Help;
	private JButton btnTicTacToe,btnBingo,btnThreeCardPoker,btnBlackJack,btnRoPaSc,btnMinsweeper;
	private JPanel pMain,pSouth,pNorth,pCenter;
	private JTextArea tac;
	private JLabel lbllogo;

	// private String[] list = {"BlackJack", "TicTacToe", "Bingo", "ThreeCardPoker", "Minsweeper", "RoPaSc"};
	// private JScrollPane listScroller = new JScrollPane(list);

	public LibGui() throws IOException
	{
	  //menu bar and menu item initialization
	  menuBar = new JMenuBar();
	  m1 = new JMenu("New Game");
	  m2 = new JMenu("Quit");
	  m3 = new JMenu("Help");

	  TicTacToe = new JMenuItem("TicTacToe");
	  Bingo = new JMenuItem("Bingo");
	  BlackJack = new JMenuItem("BlackJack");
	  ThreeCardPoker = new JMenuItem("ThreeCardPoker");
	  RoPaSc = new JMenuItem("RoPaSc");
	  Minsweeper = new JMenuItem("Minsweeper");
	  Help = new JMenuItem("Help");

	  //text area initialization
      tac = new JTextArea(2,3);
	  tac.setText("For: Birgang Institute of Technology Birganj,Parsa");
	  tac.setForeground(Color.red);
	  tac.setEditable(false);

	  //button intialization
	  btnTicTacToe = new JButton("TicTacToe");
	  btnTicTacToe.setToolTipText("Play TicTacTie");


	  btnBingo = new JButton("Bingo");
	  btnBingo.setToolTipText("Play Bingo");


	  btnThreeCardPoker = new JButton("ThreeCardPoker");
	  btnThreeCardPoker.setToolTipText("Play ThreeCardPoker");


	  btnBlackJack = new JButton("BlackJack");
	  btnBlackJack.setToolTipText("Play BlackJack");


	  btnRoPaSc = new JButton("RoPaSc");
	  btnRoPaSc.setToolTipText("Play Rock, Paper, Scissors");


	  btnMinsweeper = new JButton("Minsweeper");
	  btnMinsweeper.setToolTipText("Play Minsweeper");


	  //initialization panel

	  	pMain = new JPanel();
	  	pNorth = new JPanel();
        pSouth = new JPanel();
        pCenter = new JPanel();

       lbllogo = new JLabel(new ImageIcon("~/Pictures/Oa6s2wF.jpg"),JLabel.CENTER);

	   //add menuitem to New Game menu
	   m1.add(TicTacToe);
	   m1.add(Bingo);
	   m1.add(BlackJack);
	   m1.add(ThreeCardPoker);
	   m1.add(RoPaSc);
	   m1.add(Minsweeper);

	   //m3.add(Help);

	   menuBar.add(m1);
	   menuBar.add(m2);
	   menuBar.add(m3);


	   pMain.add(btnTicTacToe);
	   pMain.add(btnBingo);
	   pMain.add(btnThreeCardPoker);
	   pMain.add(btnBlackJack);
	   pMain.add(btnRoPaSc);
	   pMain.add(btnMinsweeper);

	   pMain.setLayout(new BoxLayout(pMain,BoxLayout.X_AXIS));
	   pMain.setBorder(BorderFactory.createTitledBorder("Games"));
	   pMain.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	   pMain.setLayout(new GridLayout(1,6));
	   pMain.setBackground(Color.white);

	   BufferedImage image = ImageIO.read(new File("y7aLfNg.jpg"));
	   JLabel label = new JLabel( new ImageIcon(image));

	   pCenter.setBackground(Color.black);
	   pCenter.setLayout(new GridLayout(1,1));
	   pCenter.add(label);

	   pNorth.setBackground(Color.white);

	   pNorth.add(menuBar);
	   pNorth.add(menuBar);

	   pSouth.add(tac);

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
	    LibGui lg = new LibGui();
	    /*
	    	ToDo:
	    		pCenter panel with a function outside of LibGui class
	    			this will enable a single function call for each game upon button click
	    			each game function would be able to update the jpanel with the appropriate GUI
	    				init() functions may have to take in a JPanel object as argument
	    		
		*/
	   }
}


