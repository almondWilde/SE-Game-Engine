// Author: Derrick Chan
package games.Bingo;

// BingoGrid object class
public class BingoGrid 
{
    BingoGrid(int v)
    {
        value = v;
        isCalled = false;
        isFilled = false;
    }
    private int value;
    private boolean isCalled;
    private boolean isFilled;
    
    // Getters and setters for object
    int getValue()
    {
        return value;
    }
    
    void setFilled(boolean f)
    {
        isFilled = f;
    }
    boolean checkFilled()
    {
        return isFilled;
    }
    
    void setCalled(boolean f)
    {
        isCalled = f;
    }
    boolean checkCalled()
    {
        return isCalled;
    }
}

// 18 lines
