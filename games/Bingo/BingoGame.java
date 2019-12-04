package games.Bingo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * BingoGame class that holds the game's logic.
 * grid is a list of the values which will be added to the GUI.
 * board is an array of BingoGrid objects.
 * @author Derrick
 * @version 1.0
 */

public class BingoGame
{
    List<Integer> deck = new LinkedList<>();
    List<String> grid = new LinkedList<>();
    BingoGrid board[] = new BingoGrid[25];
    /**
     * Constructor for the BingoGame object.
     * Creates a deck of cards 1-75 and shuffles them.
     * Creates a board with 25 cards from the deck.
     * board[13] is setCalled because it is the "FREE" middle grid.
     */
    public BingoGame()
    {
        for(int i = 1; i <= 75; i++)
        {
            deck.add(i);
            String s = Integer.toString(i);
            grid.add(s);
        }
        Random rand = new Random(System.currentTimeMillis());
        Collections.shuffle(grid, rand);
        int k = 0;
        for(int i = 0; i < 25; i++)
        {
            int gridVal = Integer.parseInt(grid.get(k));
            board[k] = new BingoGrid(gridVal);
            k++;
        }
        board[13].setCalled(true);
    }
    
    /**
     * Gets the value of the board array at the index that is specified.
     * @param index The index of the array.
     * @return 
     */
    public String getVal(int index)
    {
        String s = Integer.toString(board[index].getValue());
        return s;
    }
    
    /**
     * Draws a random number from the deck and then removes the number from the deck array.
     * @return The integer that was drawn from the deck.
     */
    public int drawNum()
    {
        // Chooses a random element from deck, removes it from the deck, and returns it.
        int rand = new Random().nextInt(deck.size());
        int numDrawn = deck.get(rand);
        deck.remove(rand);
        for(int i = 0; i < 25; i++)
        {
            if(board[i].getValue() == numDrawn)
            {
                board[i].setCalled(true);
                System.out.println(board[i].getValue());
            }
        }
        return numDrawn;
    }
    
    /**
     * Calls the setFilled function from BingoGrid onto the index of the board array specified
     * This function will make the BingoGrid's Boolean value isFilled to true.
     * @param index 
     */
    public void fillSquare(int index)
    {
        board[index].setFilled(true);
    }
    
    /**
    * Calls the setFilled function from BingoGrid onto the index of the board array specified
    * This function will make the BingoGrid's Boolean value isFilled to false.
    * @param index 
    */
    public void unfillSquare(int index)
    {
        board[index].setFilled(false);
    }
    
    // Horizontal
    // 0-4
    // 5-9
    // 10-14
    // 15-19
    // 20-24
    // Vertical
    // 0, 5, 10, 15, 20
    // 1, 6, 11, 16, 21
    // 2, 7, 12, 17, 22
    // 3, 8, 13, 18, 23
    // 4, 9, 14, 19, 24
    // Diagonal
    // 0, 6, 12, 18, 24
    // 4, 8, 12, 16, 20
    /**
     * This method is used to check the Bingo win condition. If 5 grids in a row have isFilled == true and isCalled == true, then the result is true, else it is false.
     * The 5 grids in a row can be found horizontal, vertical, or diagonal.
     * @return This returns either true, a bingo was found, or false, a bingo was not found.
     */
    public boolean checkBingo()
    {
        // Horizontal
        int count = 0;
        for(int i = 0; i < 5; i++)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 5; i < 10; i++)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 10; i < 15; i++)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 15; i < 20; i++)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 20; i < 25; i++)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        // Vertical
        count = 0;
        for(int i = 0; i < 21; i += 5)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 1; i < 22; i += 5)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 2; i < 23; i += 5)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 3; i < 24; i += 5)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 4; i < 25; i += 5)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        // Diagonal
        count = 0;
        for(int i = 0; i < 25; i += 6)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        count = 0;
        for(int i = 4; i < 21; i += 4)
        {   
            if(board[i].checkFilled() && board[i].checkCalled())
            {
                count++;
            }
            if(count == 5)
            {
                return true;
            }
        }
        return false;
    }
}

// 106 lines
