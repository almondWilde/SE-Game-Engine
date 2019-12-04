package games.Hangman;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;


/**
 * Class contains private GUI members as well as private members needed for game logic
 * @author axelzaroli
 * @version 1.0
 * Last Edit: 12/1/19
 */
public class TicTacToe extends JFrame {
    // botlogic (turn, assignment, and picking spots), returning to launcher
    //implement hangman or a similar game 
       
    private JFrame Menu_Frame;                    //welcome screen frame
    private JFrame Setting_Frame;                 //next frame asking if player wants to play against bot or two player   
    private JFrame Board_Frame;                   //game board frame
    private JFrame Again_Frame;                   //play again frame
    
    private JButton [] Position_Button;           //different positioned buttons of the tic tac toe board
    private JButton Play_Button;                  //initial play button
    private JButton Again_Button;                 //play again button
    private JButton Quit_Button;                //return to launcher button
    private JButton Setting_Button;               //return to TTT setting menu button, needed in 1/2 player screen and Again_Frame
    private JButton Single_Button;                //single player button
    private JButton Two_Button;                   //two player button 
   
    private String Player1 = "X";                 //represents player1
    private String Player2 = "O";
    private String Player;                        //player that is used if going against bot
    private String Bot;
    private int Turn_Number = 0;   
    private boolean Player1_Turn = false;         //represents whether or not player1 has taken turn, default is false 
    private boolean Bot_Mode = false;             //determines whether or not bot needed
    
    /**
     * Constructor initializes GUI members and creates the Game Board and adds Buttons
     */
    public TicTacToe (){
        //create a frame implementing a main menu -> single player (bot), more than one player, return to game launcher, quit, etc. 
        this.Play_Button = new JButton ("Play Tic Tac Toe!"); 
        this.Again_Button = new JButton ("Play Again");
        this.Quit_Button = new JButton ("Quit Tic Tac Toe"); 
        this.Setting_Button = new JButton ("Return to Setting Menu");         
        this.Single_Button = new JButton ("Single Player\nvs\nBot"); 
        this.Two_Button = new JButton ("Two Players"); 
        
        GridLayout board = new GridLayout (3, 3);
        this.Board_Frame = new JFrame ();
        this.Board_Frame.setLayout (board);
        this.Board_Frame.setSize (450, 450);
     //   this.Board_Frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      
        this.Position_Button = new JButton [9];
        for (int i = 0; i < 9; i++) {
            this.Position_Button [i] = new JButton (); 
            this.Position_Button [i].addActionListener (new ButtonHandler () );
            this.Board_Frame.add (this.Position_Button [i] );     
        }
                    
        MenuScreen (); 
    }
    
    /**
     * Creates the GUI representing the TicTacToe Main Menu
     */
    public void MenuScreen () {      
        GridLayout B = new GridLayout (1, 2); 
        this.Menu_Frame = new JFrame ();
        this.Menu_Frame.setLayout (B); 
        this.Menu_Frame.setTitle ("Tic Tac Toe Main Menu!"); 
        this.Menu_Frame.setSize (400,200); 
        //this.Menu_Frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
        this.Menu_Frame.add (this.Play_Button); 
        this.Menu_Frame.add (this.Quit_Button); 
        this.Menu_Frame.setVisible (true);
        
        /**
         * ActionListener for "Play Tic Tac Toe" button
         */
        this.Play_Button.addActionListener (
                new ActionListener () {
                    public void actionPerformed (ActionEvent e) {
                            if (e.getSource () == Play_Button) {
                                Menu_Frame.setVisible(false);
                                Menu_Frame.dispose (); 
                                SettingScreen ();
                            }
                    }
                }
        );
         
        /**
         * ActionListener for "Quit Tic Tac Toe" button
         */
        this.Quit_Button.addActionListener (
                new ActionListener () {
                    public void actionPerformed (ActionEvent e){
                            if (e.getSource () == Quit_Button) {
                                Menu_Frame.setVisible (false);
                                Menu_Frame.dispose (); 
                                Setting_Frame.setVisible (false);
                                Setting_Frame.dispose (); 
                                Again_Frame.setVisible (false);
                                Again_Frame.dispose (); 

                            }
                    }
                }
        );
    }
    
    /**
     * Creates the GUI representing the Setting screen 
     */
    public void SettingScreen () {  
        GridLayout B = new GridLayout (1, 3); 
        this.Setting_Frame = new JFrame ();
        this.Setting_Frame.setLayout (B); 
        this.Setting_Frame.setTitle ("Settings Menu"); 
        this.Setting_Frame.setSize (600,200); 
       // this.Setting_Frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.Setting_Frame.add (this.Single_Button); 
        this.Setting_Frame.add (this.Two_Button); 
        this.Setting_Frame.add (this.Quit_Button);
        this.Setting_Frame.setVisible (true);
        
        /**
         * ActionListener for the "Two Players" button 
         */
        this.Two_Button.addActionListener (
                new ActionListener () {
                    public void actionPerformed (ActionEvent e) {
                        Bot_Mode = false; 
                        Setting_Frame.dispose ();
                        Board_Frame.setTitle ("Player 1 turn!");
                        ClearBoard ();
                    }
                }
        );

        /**
         * ActionListener for the "Single Player vs Bot button 
         */
        this.Single_Button.addActionListener (
                new ActionListener () {
                    public void actionPerformed (ActionEvent e) {
                        Bot_Mode = true;
                        Setting_Frame.dispose ();
                        CoinFlip ();
                        ClearBoard ();
                    }
                }
        );
    }
    
    /**
     * Simulates a coin flip and will assign whether the user or computer has the first move 
     */
    public void CoinFlip () {

        Random rand = new Random ();
        int coin = rand.nextInt (2);
        if (coin == 0) {
             JOptionPane.showMessageDialog (null, "You have been randomly selected as Player1 and assigned X \nThe Bot is Player2 and assigned O"); 
             Player = "X";
             Bot = "O";
             JOptionPane.showMessageDialog (null, "You have the first move"); 
         }
         else {
             JOptionPane.showMessageDialog (null, "The bot has been randomly selected as Player1 and assigned X \nYou are Player2 and assigned O");
             Player = "O";
             Bot = "X"; 
             JOptionPane.showMessageDialog (null, "Click on the gameboard to begin game and Bot will make it's move"); 

         }
        //ClearBoard ();
    }
    
    /**
     * Creates the GUI for the PlayAgain menu
     * @param w -> determines the winner of the game (Player (1/2) or Bot), is passed from ButtonHandler class method 
     */
    public void PlayAgain (String w)  {
        GridLayout B = new GridLayout (1, 3);        
        this.Again_Frame = new JFrame (); 
        this.Again_Frame.setLayout (B);
        this.Again_Frame.setSize (600, 200); 
        this.Again_Frame.setTitle (w + " Play Again?!"); 
        this.Again_Frame.add (this.Again_Button); 
        this.Again_Frame.add (this.Setting_Button);
        this.Again_Frame.add (this.Quit_Button); 
        this.Again_Frame.setVisible (true); 
       // this.Again_Frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        /**
         * ActionListener for the "Play Again?" button 
         */
        this.Again_Button.addActionListener (
                new ActionListener () {
                            public void actionPerformed (ActionEvent e) {
                                if (e.getSource () == Again_Button ) {
                                    Again_Frame.dispose ();   
                                    ClearBoard ();                                  
                                }
                            }
                        }
        );   
        
        /**
         * ActionListener for "Return to Setting Menu" button 
         */
        this.Setting_Button.addActionListener (
                new ActionListener () {
                            public void actionPerformed (ActionEvent e) {
                                if (e.getSource () == Setting_Button ) {
                                    Again_Frame.dispose ();
                                    Board_Frame.setVisible (false);
                                    Setting_Frame.add (Quit_Button);       
                                    Setting_Frame.setVisible (true); 
                                }
                            }
                        }
        );
    }
    
    /**
     * Logic to clear game board and restart a game
     */
    public void ClearBoard (){
        this.Turn_Number = 0; 
        this.Player1_Turn = false; 
        this.Board_Frame.setVisible (true); 
        this.Board_Frame.setTitle ("Player 1 Turn!");
        
        for (int i = 0; i < 9; i++) {
            this.Position_Button [i].setText (" "); 
        }     
    }
    
    /**
     * Private class to handle the buttons on the game board and implement game logic
     */
    private class ButtonHandler implements ActionListener  {   
        public void actionPerformed (ActionEvent e) {   
            
            if (Bot_Mode == false) {
                for (int i = 0; i < 9; i++) {
                    
                if (e.getSource () == Position_Button [i]) {
                    String current = Position_Button [i].getText (); 
                    String empty = " "; 

                    if (Player1_Turn == false && current.equals (empty) ) {
                        Position_Button [i].setText (Player1); 
                        Player1_Turn = true; 
                        Turn_Number ++; 
                        Board_Frame.setTitle ("Player 2 turn!");
                        
                        if (Turn_Number >= 5 && CheckWin (Player1) == true) {
                            JOptionPane.showMessageDialog (null, "Player 1 Wins!");
                            Board_Frame.setVisible (false);
                            PlayAgain ("Player 1 wins!");
                            break;
                        }
                    } 
                    else if (Player1_Turn == true && current.equals (empty) ) {
                        Position_Button [i].setText(Player2);
                        Player1_Turn = false; 
                        Turn_Number ++;          
                        Board_Frame.setTitle ("Player 1 turn!"); 
                        
                        if (Turn_Number >= 5 && CheckWin (Player2) == true) {
                            JOptionPane.showMessageDialog (null, "Player 2 Wins!");
                            Board_Frame.setVisible (false);
                            PlayAgain ("Player 2 wins!");
                            break;
                        }
                    }
                    else if (!current.equals (empty) ) {
                        JOptionPane.showMessageDialog (null, "Incorrect input; Position already taken.");
                    } 
                }
                } //end for loop
            }            
            else if (Bot_Mode == true) {                            
                
                for (int i = 0; i < 9; i++) {
                   
                    if (Bot.equals ("X") && Player1_Turn == false) {                                              
                        String buffer;
                        int c;
                        do {
                            Random rand = new Random ();
                            c = rand.nextInt (9);
                            buffer = Position_Button[c].getText ();
                        }while (!buffer.equals(" "));
                       
                        i = c; 
                        Position_Button[c].setText (Bot);  
                        e.setSource(Position_Button[i]);                        
                        if (e.getSource () == Position_Button[i]) {
                             Player1_Turn = true;
                             Turn_Number++;
                             Board_Frame.setTitle ("Player 2 turn!");
                        
                            if (Turn_Number >= 5 && CheckWin (Bot) == true) {
                               JOptionPane.showMessageDialog (null, "Bot Wins!");
                               Board_Frame.setVisible (false);
                               PlayAgain ("Bot wins!");
                               break;
                             }
                        }                         
                    }
                    else if (e.getSource () == Position_Button [i] && 
                            Player.equals ("O") && Player1_Turn == true) {
                        String current = Position_Button [i].getText (); 
                        String empty = " "; 
                        
                        if (current.equals (empty) ) {
                            Position_Button [i].setText (Player);
                            Player1_Turn = false;
                            Turn_Number ++; 
                            Board_Frame.setTitle ("Player 1 turn!");
                        
                            if (Turn_Number >= 5 && CheckWin (Player) == true) {
                               JOptionPane.showMessageDialog (null, "You Won!");
                               Board_Frame.setVisible (false);
                               PlayAgain ("Winner!");
                               break;
                            }                                                   
                        }
                        else if (!current.equals (empty))
                          JOptionPane.showMessageDialog (null, "Incorrect input; Position already taken.");
                    }
                    
                    else if (e.getSource () == Position_Button [i] && Player.equals ("X")) {
                        String current = Position_Button [i].getText ();
                        String empty = " ";
                        
                        if (current.equals (empty) ) {
                            Position_Button [i].setText (Player);
                            Turn_Number ++;
                            Board_Frame.setTitle ("Player 2 turn!");
                                                        
                            if (Turn_Number >= 5 && CheckWin (Player) == true) {
                               JOptionPane.showMessageDialog (null, "You Won!");
                               Board_Frame.setVisible (false);
                               PlayAgain ("Winner!");
                               break;
                            }
                            if (Turn_Number < 9) {
                                String buffer;                       
                                int c;                       
                                do {
                                    Random rand = new Random ();                          
                                    c = rand.nextInt (9);
                                    buffer = Position_Button[c].getText ();
                                }while (!buffer.equals(" "));
                       
                                 Position_Button[c].setText (Bot);                        
                                 Turn_Number++;
                                 Board_Frame.setTitle ("Player 1 turn!");
                        
                                 if (Turn_Number >= 5 && CheckWin (Bot) == true) {
                                     JOptionPane.showMessageDialog (null, "Bot Wins!");
                                     Board_Frame.setVisible (false);
                                     PlayAgain ("Bot wins!");
                                     break;
                                 }
                        }                                 
                        }
                        else if (!current.equals (empty))
                                 JOptionPane.showMessageDialog (null, "Incorrect input; Position already taken.");
                    }
                }
            }
            if (Turn_Number >= 9 && CheckWin (Player1) == false &&
                    CheckWin (Player2) == false && 
                    CheckWin (Bot) == false && CheckWin (Player) == false)  {                   
                JOptionPane.showMessageDialog (null, "Draw!"); 
                Board_Frame.setVisible (false);
                PlayAgain ("Draw!"); 
                }
        }
    }

    /**
     * Will call the other three check functions (vertical, horizontal, diagonal) 
     * @param Player -> Player string, either bot or player (1/2) containing either "X" or "O"
     * @return -> return true if one of the three other check functions return true, false otherwise
     */
    public boolean CheckWin (String Player)  {
      if (CheckVertical (Player) == true) 
          return true; 
      else if (CheckHorizontal (Player) == true)
          return true;
      else if (CheckDiagonal (Player) == true)
          return true;
      else
          return false; 
    }
    
    /**
     * Will check the hard coded vertical win possibilites for tic tac toe
     * @param Player -> Player string, either bot or player (1/2) containing either "X" or "O"
     * @return return true if one of the three vertical win possibilities true, false otherwise
     */
    private boolean CheckVertical (String Player) {
        
        if     (Position_Button [0].getText ().equals (Player) &&
                Position_Button [3].getText ().equals (Player) &&
                Position_Button [6].getText ().equals (Player)) 
                    return true; 
        else if (Position_Button [1].getText ().equals (Player) &&
                 Position_Button [4].getText ().equals (Player) &&
                 Position_Button [7].getText ().equals (Player)) 
                    return true; 
        else if (Position_Button [2].getText ().equals (Player) &&
                 Position_Button [5].getText ().equals (Player) &&
                 Position_Button [8].getText ().equals (Player)) 
                    return true; 
       else
            return false;
    }
    
    /**
     * Will check the hard coded horizontal win possibilites for tic tac toe
     * @param Player -> Player string, either bot or player (1/2) containing either "X" or "O"
     * @return return true if one of the three horizontal win possibilities true, false otherwise
     */
    private boolean CheckHorizontal (String Player) {
        if     (Position_Button [0].getText ().equals (Player) &&
                Position_Button [1].getText ().equals (Player) &&
                Position_Button [2].getText ().equals (Player)) 
                    return true; 
        else if (Position_Button [3].getText ().equals (Player) &&
                 Position_Button [4].getText ().equals (Player) &&
                 Position_Button [5].getText ().equals (Player)) 
                    return true; 
        else if (Position_Button [6].getText ().equals (Player) &&
                 Position_Button [7].getText ().equals (Player) &&
                 Position_Button [8].getText ().equals (Player)) 
                    return true; 
       else
            return false;
    }
    
    /**
     * Will check the hard coded diagonal win possibilites for tic tac toe
     * @param Player -> Player string, either bot or player (1/2) containing either "X" or "O"
     * @return return true if one of the two diagonal win possibilities true, false otherwise
     */
    private boolean CheckDiagonal (String Player) {
        if     (Position_Button [0].getText ().equals (Player) &&
                Position_Button [4].getText ().equals (Player) &&
                Position_Button [8].getText ().equals (Player)) 
                    return true; 
        
        else if (Position_Button [2].getText ().equals (Player) &&
                 Position_Button [4].getText ().equals (Player) &&
                 Position_Button [6].getText ().equals (Player)) 
                    return true; 
       else
            return false;
    }
 
    /**
     * void main function used for testing tic tac toe GUI and game logic
     * @param args -> not used
     */
    public static void main(String[] args) {
        TicTacToe test;
        test = new TicTacToe (); 
    }
}

