// Author: Derrick Chan
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

public class LoseGUI extends JPanel
{
    JFrame frame = new JFrame("Loser");
    private static BingoGUI bingo;
    
    public void addComponentsToPane(Container pane)
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel loseLabel = new JLabel("YOU LOSE!!!!");
        loseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
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
        
        mainPanel.add(loseLabel);
        mainPanel.add(buttonPanel);
        buttonPanel.add(btnPlay);
        buttonPanel.add(btnReturn);
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

// 32 lines
