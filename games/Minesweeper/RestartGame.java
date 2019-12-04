//Author: Megan Rozal
package games.Minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class that restarts the game and resets the board 
 * @author Megan Rozal
 * @version 1.0
 */
public class RestartGame implements ActionListener
{
    /**
     * Initializes board's frame, button, and label variables for bombs left, restart, and time 
     */
	private JFrame frame;
	private JPanel panel;
	private JButton restart;
	private JLabel bombsLeft;
	private JLabel time;
	
	public RestartGame(JButton restart, JPanel panel, JFrame frame, JLabel bombsLeft, JLabel time)
	{
            /*
            Creates references to the panel, restart button, frame, bombsLeft tracker, and time counter
            */
		this.panel = panel;
		this.restart = restart;
		this.frame = frame;
		this.bombsLeft = bombsLeft;
		this.time = time;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
            /**
             * Clears the board, makes a new grid, resets amount of bombs to 0, and resets time to 0
             */
		Grid grille = new Grid(Settings.nbRow, Settings.nbCol, Settings.nbBombs, bombsLeft);
		grille.constructPanel(panel);
		Settings.flagCount = 0;
		bombsLeft.setText(""+(Settings.nbBombs - Settings.flagCount));
		time.setText("0");
		Settings.hasStarted = false;
		
		frame.setSize(Settings.frameSize, Settings.frameSize);
		restart.setText("Restart Game");
	}
	
}
