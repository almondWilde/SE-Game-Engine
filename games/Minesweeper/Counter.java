//Author: Megan Rozal
package games.Minesweeper;

import java.util.TimerTask;
import javax.swing.JLabel;

/**
 * Class that contains time counter
 * @author Megan Rozal
 */
public class Counter extends TimerTask
{
    /**
     * Counter class that has the variavle time
     */
	private JLabel time;
	
	public Counter(JLabel time)
	{
            /**
             * Creates a reference to time object
             */
		this.time = time;
	}
	public void run()
	{
            /**
             * Runs when the user begins the game and counts by +1 second 
             */
		if(Settings.hasStarted)
			time.setText(""+(Integer.valueOf(time.getText())+1));
	}

}