package games.Bingo;

/**
 * BingoGrid Object Class that holds the integer value of the BingoGrid and 2 Boolean values to determine if the grid is called and if it is filled.
 * @author Derrick Chan
 * @version 1.0
 */
public class BingoGrid 
{
    /**
     * The constructor for the BingoGrid object. Each grid object will be initialized with isCalled and isFalled with false, and the value of it will be input by BingoGame.java.
     * @param v The integer value of the Grid.
     */
    public BingoGrid(int v)
    {
        value = v;
        isCalled = false;
        isFilled = false;
    }
    private int value;
    private boolean isCalled;
    private boolean isFilled;
    
    /**
     * Gets the value of the BingoGrid. (Setter is not required because the values are initialized by BingoGame.java).
     * @return A int that represents the value of the BingoGrid.
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Sets the BingoGrid's isFilled Boolean.
     * @param f A Boolean value containing true or false.
     */
    public void setFilled(boolean f)
    {
        isFilled = f;
    }
    
    /**
     * Gets the BingoGrid's Boolean value isFilled.
     * @return A Boolean representing if the Bingo Grid has filled or not. 
     */
    public boolean checkFilled()
    {
        return isFilled;
    }
    
    /**
    * Sets the BingoGrid's isCalled Boolean.
    * @param f A Boolean value containing true or false.
    */
    public void setCalled(boolean f)
    {
        isCalled = f;
    }
    
    /**
     * Gets the BingoGrid's Boolean value isCalled.
     * @return A Boolean representing if the Bingo Grid has been called or not.
     */
    public boolean checkCalled()
    {
        return isCalled;
    }
}

// 18 lines
