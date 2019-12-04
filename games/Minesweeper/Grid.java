//Author: Megan Rozal
package games.Minesweeper;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Grid class represents the GUI for the Minesweeper board
 * @author Megan Rozal
 */

public class Grid
{
    /**
     * Creates rows, columns, bombs, cells, and finished boolean 
     */
	private int nbRow;
	private int nbCol;
	private int nbBombs;
	private Cell[][] cells;
	private boolean finished;
	
	public Grid(int nbRow, int nbCol, int nbBombs, JLabel label)
	{
            /**
             * Creates a layout for each cell on the grid by row and column depending on the size of the board
             */
		this.nbRow = nbRow;
		this.nbCol = nbCol;
		this.nbBombs = nbBombs;
		
		cells = new Cell[nbRow][nbCol];
		
		for(int i=0; i < nbRow; i++)
			for(int j=0; j<nbCol; j++)
			{
				cells[i][j] = new Cell(this, i, j, label);
			}
		
		label.setText(""+(Settings.nbBombs-Settings.flagCount));
		
		placeBombs();
		findNearBombs();
	}
	
	private void placeBombs()
	{
            /**
             * Randomly places bombs on the board
             */
		Random rand = new Random();
		
		for(int i=0; i < nbBombs; i++)
		{
			int randRow, randCol;
			do
			{
                            randRow = rand.nextInt(nbRow);
                            randCol = rand.nextInt(nbCol);
			}
			while(cells[randRow][randCol].getBomb());
			
			cells[randRow][randCol].setBomb();
		}
	}
	
	private void findNearBombs()
	{
            /**
             * When the player clicks on a cell, it finds the nearest bombs surrounding it
             */
		for(int i=0; i < nbRow; i++)
			for(int j=0; j < nbCol; j++)
			{
				int totalBombs = 0;
				
				if(isIndexOk(i-1,j) && cells[i-1][j].getBomb()) // up
					totalBombs++;
				if(isIndexOk(i-1,j-1) && cells[i-1][j-1].getBomb()) // up left
					totalBombs++;
				if(isIndexOk(i,j-1) && cells[i][j-1].getBomb()) // left
					totalBombs++;
				if(isIndexOk(i+1,j-1) && cells[i+1][j-1].getBomb()) // down left
					totalBombs++;
				if(isIndexOk(i+1,j) && cells[i+1][j].getBomb()) // down
					totalBombs++;
				if(isIndexOk(i+1,j+1) && cells[i+1][j+1].getBomb()) // down right
					totalBombs++;
				if(isIndexOk(i,j+1) && cells[i][j+1].getBomb()) // right
					totalBombs++;
				if(isIndexOk(i-1,j+1) && cells[i-1][j+1].getBomb()) // up right
					totalBombs++;
				
				cells[i][j].setNbBomb(totalBombs);
			}
	}
	
	private boolean isIndexOk(int i, int j)
	{
            /**
             * Checks for the index and return the surrounding result numbers
             */
		boolean result = false;
		
		if(i >= 0 && i < nbRow && j >= 0 && j < nbCol)
			result = true;
		
		return result;
	}
	
	public void constructPanel(JPanel panel)
	{
            /**
             * Creates the panel for the board, including its color, the cells, and the MouseListener functionality 
             */
		panel.removeAll();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new GridLayout(nbRow, nbCol));
		for(int i=0; i < nbRow; i++)
		{
			for(int j=0; j < nbCol; j++)
			{
				panel.add(cells[i][j].getCase());
				cells[i][j].getCase().addMouseListener(new ButtonAction(cells[i][j], this));
			}
		}
		panel.revalidate();
	}
	
	public void checkAround(Cell aCase)
	{
            /**
             * Checks for surrounding cells around the cell that was clicked by user
             */
		int i = aCase.getRow();
		int j = aCase.getCol();
		
		if(isIndexOk(i-1,j) && !cells[i-1][j].getBomb()) // up
			cells[i-1][j].setVisible();
		if(isIndexOk(i-1,j-1) && !cells[i-1][j-1].getBomb()) // up left
			cells[i-1][j-1].setVisible();
		if(isIndexOk(i,j-1) && !cells[i][j-1].getBomb()) // left
			cells[i][j-1].setVisible();
		if(isIndexOk(i+1,j-1) && !cells[i+1][j-1].getBomb()) // down left
			cells[i+1][j-1].setVisible();
		if(isIndexOk(i+1,j) && !cells[i+1][j].getBomb()) // down
			cells[i+1][j].setVisible();
		if(isIndexOk(i+1,j+1) && !cells[i+1][j+1].getBomb()) // down right
			cells[i+1][j+1].setVisible();
		if(isIndexOk(i,j+1) && !cells[i][j+1].getBomb()) // right
			cells[i][j+1].setVisible();
		if(isIndexOk(i-1,j+1) && !cells[i-1][j+1].getBomb()) // up right
			cells[i-1][j+1].setVisible();
	}
	
	public void setFinished()
	{
            /**
             * If user has clicked on a bomb, this method displays all bombs
             */
		finished = true;
		Settings.hasStarted = false;
		viewBombs();
	}
	
	public boolean finished()
	{
            /**
             * Boolean returns true if the user is finished with the game
             */
		return finished;
	}
	
	public boolean check() 
	{
            /**
             * Checks if the player has won
             */
		for(int i=0; i < nbRow; i++)
			for(int j=0; j < nbCol; j++)
			{
				if(!cells[i][j].getBomb() && !cells[i][j].isVisible())
					return false;
			}
		return true;
	}
	
	public void congratulations()
	{
            /**
             * Displays all bombs and congratulations message
             */
		viewBombs();
		JOptionPane.showMessageDialog(null,"Congratulations! You've Won Minesweeper!");
	}
	
	public void viewBombs()
	{
            /**
             * Displays all bombs on board
             */
		for(int i=0; i < nbRow; i++)
			for(int j=0; j < nbCol; j++)
				if(cells[i][j].getBomb())
					cells[i][j].getCase().setText("X");
	}
}