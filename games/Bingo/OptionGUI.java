package games.Bingo;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * OptionGUI class that represents the GUI for the options menu.
 * @author Derrick Chan
 * @version 1.0
 */
public class OptionGUI extends JPanel
{
    /**
     * Creates a new frame for the GUI components to be added to.
     * Also creates a BingoGUI object to be used when the play button is clicked.
     */
    JFrame frame = new JFrame("Option");
    private static BingoGUI bingo;
    
    /**
     * Function that adds the GUI components to the pane.
     * This function also includes the ActionListeners for all the buttons included into the GUI.
     * @param pane The pane or window that the components will be added to.
    */
    public void addComponentsToPane(Container pane)
    {
        JPanel mainPanel = new JPanel(new FlowLayout());
        JButton btnPlay = new JButton("Play");
        JButton btnReturn = new JButton("Main Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // When Play button is clicked
        btnPlay.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Load Bingo GUI
                bingo = new BingoGUI();
                bingo.createAndShowGUI();
                // Closes Option
                frame.dispose();
            }
        });
        // When Main Menu button is clicked
        btnReturn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });
        mainPanel.add(btnPlay);
        mainPanel.add(btnReturn);
        pane.add(mainPanel);
    }
    
    /**
     * Function to create and show the GUI
    */
    public void createAndShowGUI() 
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
// 25 lines
