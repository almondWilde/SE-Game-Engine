// Author: Derrick Chan
package games.Bingo;
import javax.swing.*;

public class Bingo
{
    private static OptionGUI option;

    public void startBingo(){

      SwingUtilities.invokeLater(new Runnable()
      {
          public void run()
          {

              option = new OptionGUI();
              option.createAndShowGUI();
          }
      });
    }
}

// 7 lines of code
// 527 total lines
