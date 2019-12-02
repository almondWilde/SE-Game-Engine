// Author: Derrick Chan
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class OptionGUI extends JPanel
{
    JFrame frame = new JFrame("Option");
    private static BingoGUI bingo;
    
    public void addComponentsToPane(Container pane)
    {
        JPanel mainPanel = new JPanel(new FlowLayout());
        JButton btnPlay = new JButton("Play");
        JButton btnReturn = new JButton("Main Menu");
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
                // Return to Epsilon Game Launcher
                System.out.println("return");
            }
        });
        mainPanel.add(btnPlay);
        mainPanel.add(btnReturn);
        pane.add(mainPanel);
    }
    
    public void createAndShowGUI() 
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

// 24 lines