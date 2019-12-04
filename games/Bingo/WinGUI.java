package games.Bingo;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * WinGUI class that represents the GUI for the menu that opens when the player wins.
 * @author Derrick Chan
 * @version 1.0
 */
public class WinGUI extends JPanel
{
    /**
     * Creates a new frame for the GUI components to be added to.
     * Also creates a BingoGUI object to be used when the play button is clicked.
     */
    JFrame frame = new JFrame("Winner");
    private static BingoGUI bingo;
    
    /**
     * Function that adds the GUI components to the pane.
     * This function also includes the ActionListeners for all the buttons included into the GUI.
     * @param pane The pane or window that the components will be added to.
    */
    public void addComponentsToPane(Container pane)
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel winLabel = new JLabel("YOU WIN!!!!");
        winLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton btnPlay = new JButton("Play Again?");
        JButton btnReturn = new JButton("Main Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        btnPlay.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Load Bingo GUI
                bingo = new BingoGUI();
                bingo.createAndShowGUI();
                frame.dispose();
            }
        });
        
        btnReturn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });
        
        mainPanel.add(winLabel);
        mainPanel.add(buttonPanel);
        buttonPanel.add(btnPlay);
        buttonPanel.add(btnReturn);
        pane.add(mainPanel);
    }
    /**
     * Function to create and show the GUI.
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

// 32 lines
