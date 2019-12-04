package games.Bingo;
import javax.swing.*;
/** Main Driver for Bingo Game.
 * @author Derrick Chan
 * @version 1.0
 */

public class Bingo
{
    /**
     * Creates an OptionGUI object that represents the options menu.
     */
    private static OptionGUI option;

    /**
    * Runs the options menu GUI.
    */
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
