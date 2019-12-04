//Author: Megan Rozal
package games.Minesweeper;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Class that represents the cell functionalities on the GUI board
 * @author Megan Rozal
 * @version 1.0
 */

public class Cell
{
    /**
     * Cell class that represents the cells on the Minesweeper board
     */
	private boolean bomb=false;
	private boolean flagged=false;
	private boolean visible=false;
	private int bombNumberAround=0;
	private JButton aCase;
	private JLabel bombsLeft;
	private int row;
	private int col;
	private Grid grid;
	
	public Cell(Grid grid, int row, int col, JLabel bombsLeft)
	{
            /**
             * Creates color for all cells on the board
             */
		aCase = new JButton("");
		aCase.setBackground(Color.GRAY);
		this.row = row;
		this.col = col;
		this.grid = grid;
		this.bombsLeft = bombsLeft;
	}
	
	public void setBomb()
	{
            /**
             * Method returns true if cell is a bomb
             */
		bomb=true;
	}
	
	public boolean getBomb()
	{
         /**
          * Boolean that returns bomb if the cell contains a bomb
          */   
		return bomb;
	}
	
	public void setVisible()
	{
            /**
             * If bomb is clicked on, this method displays Game Over Message.
             * If the game is continuing, cells containing assigned colored numbers are displayed
             */
		if(!visible)
		{
			if(bomb)
			{
				aCase.setText("X");
				Settings.flagCount++;
				bombsLeft.setText(""+(Settings.nbBombs - Settings.flagCount));
				grid.setFinished();
				JOptionPane.showMessageDialog(null,"Boom! Game Over!");
			}
			else
			{
				if(flagged)
				{
					Settings.flagCount--;
					bombsLeft.setText(""+(Settings.nbBombs - Settings.flagCount));
				}
				
				Color caseColor;
				switch(bombNumberAround)
				{
				case 8 :
					caseColor = Color.WHITE;
					break;
				case 7 :
					caseColor = Color.CYAN;
					break;
				case 6 :
					caseColor = Color.MAGENTA;
					break;
				case 5 :
					caseColor = Color.ORANGE;
					break;
				case 4 :
					caseColor = Color.PINK;
					break;
				case 3 :
					caseColor = Color.RED;
					break;
				case 2 :
					caseColor = Color.BLUE;
					break;
				case 1 :
					caseColor = Color.DARK_GRAY;
					break;
				case 0 :
				default :
					disableCase();
					caseColor = Color.DARK_GRAY;
				}
				if(bombNumberAround != 0)
				{
					aCase.setText(bombNumberAround+"");
					aCase.setForeground(caseColor);
				}
			}
			visible = true;
			
			if(!this.getBomb() && this.getNbBomb() == 0)
				grid.checkAround(this);
		}
	}
	
	public void disableCase()
	{
            /**
             * Disable case is a clear/non-numbered cell on the board
             */
		aCase.setText("");
		aCase.setEnabled(false);
	}
	
	public boolean isVisible()
	{
            /**
             * Boolean that returns visible cells if the game has not ended
             */
		return visible;
	}
	
	public void toggleFlag()
	{
            /**
             * Counts number of bombs on board
             */
		if(!flagged)
		{
			flagged = true;
			aCase.setText("F");
			Settings.flagCount++;
			bombsLeft.setText(""+(Settings.nbBombs - Settings.flagCount));
		}
		else
		{
			flagged = false;
			aCase.setText("");
			Settings.flagCount--;
			bombsLeft.setText(""+(Settings.nbBombs - Settings.flagCount));
		}
	}
	
	public boolean getFlaged()
	{
            /**
             * Returns flagged cells
             */
		return flagged;
	}
	
	public void setNbBomb(int nb)
	{
            /**
             * Sets numbers of bombs around the cell the player clicked
             */
		bombNumberAround = nb;
	}
	
	public int getNbBomb()
	{
            /**
             * Gets number of bombs around the cell the player clicked
             */
		return bombNumberAround;
	}
	
	public JButton getCase()
	{
            /**
             * Gets case from cell depending on which cell was clicked
             */
		return aCase;
	}
	
	public int getRow()
	{
            /**
             * Returns the rows
             */
		return row;
	}
	
	public int getCol()
	{
            /**
             * Returns the columns
             */
		return col;
	}
}