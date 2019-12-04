//Author: Megan Rozal
package games.Minesweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** 
 * Implements user's button presses
 * @author Megan Rozal
 */
public class ButtonAction implements MouseListener
{
    /**
     * Implements MouseListener to track mouse events
     */
	private Cell aCell;
	private Grid grid;
	
	public ButtonAction(Cell aCase, Grid grid)
	{
            /**
             * Tracks if the player clicked on a cell or grid
             */
		this.aCell = aCase;
		this.grid = grid;
	}

	public void mouseClicked(MouseEvent e)
	{	
            /**
             * Invoked when a mouse button has been clicked on a cell
             * Checks if there are other cells to be clicked and if not, it calls the congratulations message 
             */
		if(!grid.finished())
		{
			Settings.hasStarted = true;
			
			if(!aCell.isVisible())
    		{
				if(e.getModifiers() == 16) 
	    		{
	    			aCell.setVisible();
	    		}
	    	    else 
	    	    {
	    	    	aCell.toggleFlag();
	    	    }
				
				if(grid.check())
				{
					grid.setFinished();
					grid.congratulations();
				}
    		}
		}
    }

	public void mouseEntered(MouseEvent e) {
            /**
             * Invoked when a mouse enters a cell
             */
	}

	public void mouseExited(MouseEvent e) {
            /**
             * Invoked when a mouse exits a cell
             */
	}

	public void mousePressed(MouseEvent e) {
            /**
             * Invoked when a mouse button has been pressed on a cell
             */
	}

	public void mouseReleased(MouseEvent e) {
            /**
             * Invoked when a mouse button has been released on a cell
             */
	}
}