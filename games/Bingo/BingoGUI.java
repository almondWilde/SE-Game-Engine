// Author: Derrick Chan
package games.Bingo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class BingoGUI extends JPanel
{
    JFrame frame = new JFrame("Bingo");
    private WinGUI win;
    private LoseGUI lose;
    
    public void addComponentsToPane(Container pane)
    {
        BingoGame bingo = new BingoGame();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JPanel gamePanel = new JPanel(new GridLayout(5,5));
        
        JButton btnReturn = new JButton("Main Menu");    
        JButton btnDraw = new JButton("Draw Number");
        JButton btnBingo = new JButton("BINGO!");
        
        JButton grid1 = new JButton(bingo.getVal(0));
        JButton grid2 = new JButton(bingo.getVal(1));
        JButton grid3 = new JButton(bingo.getVal(2));
        JButton grid4 = new JButton(bingo.getVal(3));
        JButton grid5 = new JButton(bingo.getVal(4));
        JButton grid6 = new JButton(bingo.getVal(5));
        JButton grid7 = new JButton(bingo.getVal(6));
        JButton grid8 = new JButton(bingo.getVal(7));
        JButton grid9 = new JButton(bingo.getVal(8));
        JButton grid10 = new JButton(bingo.getVal(9));
        JButton grid11 = new JButton(bingo.getVal(10));
        JButton grid12 = new JButton(bingo.getVal(11));
        JButton grid13 = new JButton("FREE");
        JButton grid14 = new JButton(bingo.getVal(13));
        JButton grid15 = new JButton(bingo.getVal(14));
        JButton grid16 = new JButton(bingo.getVal(15));
        JButton grid17 = new JButton(bingo.getVal(16));
        JButton grid18 = new JButton(bingo.getVal(17));
        JButton grid19 = new JButton(bingo.getVal(18));
        JButton grid20 = new JButton(bingo.getVal(19));
        JButton grid21 = new JButton(bingo.getVal(20));
        JButton grid22 = new JButton(bingo.getVal(21));
        JButton grid23 = new JButton(bingo.getVal(22));
        JButton grid24 = new JButton(bingo.getVal(23));
        JButton grid25 = new JButton(bingo.getVal(24));
        
        
        JLabel numberDrawn = new JLabel("Number Drawn");
        JLabel numDrawn = new JLabel("None");
        JLabel prevNumDrawn = new JLabel("Previous # Drawn");
        JLabel prevDrawn = new JLabel("None");
        
        btnReturn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        btnDraw.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                prevDrawn.setText(numDrawn.getText());
                String s = Integer.toString(bingo.drawNum());
                numDrawn.setText(s);
            }
        });
        btnBingo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(bingo.checkBingo())
                {
                    System.out.println("You win");
                    win = new WinGUI();
                    win.createAndShowGUI();
                    frame.dispose();
                }
                else
                {
                    System.out.println("You lose");
                    lose = new LoseGUI();
                    lose.createAndShowGUI();
                    frame.dispose();
                }
            }
        });
        grid1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid1.getBackground() != Color.RED)
                {
                    bingo.fillSquare(0);
                    grid1.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(0);
                    grid1.setBackground(null);
                }
            }
        });
        grid2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid2.getBackground() != Color.RED)
                {
                    bingo.fillSquare(1);
                    grid2.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(1);
                    grid2.setBackground(null);
                }
            }
        });
        grid3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid3.getBackground() != Color.RED)
                {
                    bingo.fillSquare(2);
                    grid3.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(2);
                    grid3.setBackground(null);
                }
            }
        });
        grid4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid4.getBackground() != Color.RED)
                {
                    bingo.fillSquare(3);
                    grid4.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(3);
                    grid4.setBackground(null);
                }
            }
        });
        grid5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid5.getBackground() != Color.RED)
                {
                    bingo.fillSquare(4);
                    grid5.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(4);
                    grid5.setBackground(null);
                }
            }
        });
        grid6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid6.getBackground() != Color.RED)
                {
                    bingo.fillSquare(5);
                    grid6.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(5);
                    grid6.setBackground(null);
                }
            }
        });
        grid7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid7.getBackground() != Color.RED)
                {
                    bingo.fillSquare(6);
                    grid7.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(6);
                    grid7.setBackground(null);
                }
            }
        });
        grid8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid8.getBackground() != Color.RED)
                {
                    bingo.fillSquare(7);
                    grid8.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(7);
                    grid8.setBackground(null);
                }
            }
        });
        grid9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid9.getBackground() != Color.RED)
                {
                    bingo.fillSquare(8);
                    grid9.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(8);
                    grid9.setBackground(null);
                }
            }
        });
        grid10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid10.getBackground() != Color.RED)
                {
                    bingo.fillSquare(9);
                    grid10.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(9);
                    grid10.setBackground(null);
                }
            }
        });
        grid11.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid11.getBackground() != Color.RED)
                {
                    bingo.fillSquare(10);
                    grid11.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(10);
                    grid11.setBackground(null);
                }
            }
        });
        grid12.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid12.getBackground() != Color.RED)
                {
                    bingo.fillSquare(11);
                    grid12.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(11);
                    grid12.setBackground(null);
                }
            }
        });
        grid13.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid13.getBackground() != Color.RED)
                {
                    bingo.fillSquare(12);
                    grid13.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(12);
                    grid13.setBackground(null);
                }
            }
        });
        grid14.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid14.getBackground() != Color.RED)
                {
                    bingo.fillSquare(13);
                    grid14.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(13);
                    grid14.setBackground(null);
                }
            }
        });
        grid15.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid15.getBackground() != Color.RED)
                {
                    bingo.fillSquare(14);
                    grid15.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(14);
                    grid15.setBackground(null);
                }
            }
        });
        grid16.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid16.getBackground() != Color.RED)
                {
                    bingo.fillSquare(15);
                    grid16.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(15);
                    grid16.setBackground(null);
                }
            }
        });
        grid17.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid17.getBackground() != Color.RED)
                {
                    bingo.fillSquare(16);
                    grid17.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(16);
                    grid17.setBackground(null);
                }
            }
        });
        grid18.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid18.getBackground() != Color.RED)
                {
                    bingo.fillSquare(17);
                    grid18.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(17);
                    grid18.setBackground(null);
                }
            }
        });
        grid19.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid19.getBackground() != Color.RED)
                {
                    bingo.fillSquare(18);
                    grid19.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(18);
                    grid19.setBackground(null);
                }
            }
        });
        grid20.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid20.getBackground() != Color.RED)
                {
                    bingo.fillSquare(19);
                    grid20.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(19);
                    grid20.setBackground(null);
                }
            }
        });
        grid21.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid21.getBackground() != Color.RED)
                {
                    bingo.fillSquare(20);
                    grid21.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(20);
                    grid21.setBackground(null);
                }
            }
        });
        grid22.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid22.getBackground() != Color.RED)
                {
                    bingo.fillSquare(21);
                    grid22.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(21);
                    grid22.setBackground(null);
                }
            }
        });
        grid23.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid23.getBackground() != Color.RED)
                {
                    bingo.fillSquare(22);
                    grid23.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(22);
                    grid23.setBackground(null);
                }
            }
        });
        grid24.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid24.getBackground() != Color.RED)
                {
                    bingo.fillSquare(23);
                    grid24.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(23);
                    grid24.setBackground(null);
                }
            }
        });
        grid25.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(grid25.getBackground() != Color.RED)
                {
                    bingo.fillSquare(24);
                    grid25.setBackground(Color.RED); 
                }
                else
                {
                    bingo.unfillSquare(24);
                    grid25.setBackground(null);
                }
            }
        });
        
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(btnDraw);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(numberDrawn);
        leftPanel.add(numDrawn);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(prevNumDrawn);
        leftPanel.add(prevDrawn);
        
        gamePanel.add(grid1);
        gamePanel.add(grid2);
        gamePanel.add(grid3);
        gamePanel.add(grid4);
        gamePanel.add(grid5);
        gamePanel.add(grid6);
        gamePanel.add(grid7);
        gamePanel.add(grid8);
        gamePanel.add(grid9);
        gamePanel.add(grid10);
        gamePanel.add(grid11);
        gamePanel.add(grid12);
        gamePanel.add(grid13);
        gamePanel.add(grid14);
        gamePanel.add(grid15);
        gamePanel.add(grid16);
        gamePanel.add(grid17);
        gamePanel.add(grid18);
        gamePanel.add(grid19);
        gamePanel.add(grid20);
        gamePanel.add(grid21);
        gamePanel.add(grid22);
        gamePanel.add(grid23);
        gamePanel.add(grid24);
        gamePanel.add(grid25);
                
        mainPanel.add(leftPanel, BorderLayout.LINE_START);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        pane.add(btnReturn, BorderLayout.PAGE_START);
        pane.add(btnBingo, BorderLayout.LINE_END);
        pane.add(mainPanel);
    } 
    
    public void createAndShowGUI() 
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setSize(900, 700);
        frame.setVisible(true);
    }
}
// 306 lines
