package games.Hangman;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;


/**
 * The variables of the game are initiated in the constructor PlayGame () is called from constructor
 * @author axelzaroli
 * @version 1.0 
 */
public class Hangman {
    
    private String [] pool;   //a simple wordpool
    private String corpse = ("---\n   |\n   |\n   ");    //represents hangman
    boolean playing = true; //purpose is to hide gamelauncher momentarily while game runs on terminal, changed to false when player done
    private JFrame mainWindow;
    public Hangman (JFrame m) {
        //mainWindow = new JFrame ();
        mainWindow = m;
        
        mainWindow.setVisible (false);
        
        JOptionPane.showMessageDialog (null, "The Hangman game is ran from terminal and launch menu will be hidden.");
        JOptionPane.showMessageDialog(null, "One Hint: No word has letter q and if q is entered then game will return to launcher"); 

        this.pool = new String [15];
        this.pool [0] = "Hardware";
        this.pool [1] = "Worldwide";
        this.pool [2] = "Javascript";
        this.pool [3] = "Coding";
        this.pool [4] = "Megabyte";
        this.pool [5] = "Terabyte";
        this.pool [6] = "Looping";
        this.pool [7] = "Boolean";
        this.pool [8] = "Automata";
        this.pool [9] = "Infinite";
        this.pool [10] = "Variable";
        this.pool [11] = "String";
        this.pool [12] = "Program";
        this.pool [13] = "Software";
        this.pool [14] = "Engineer";
        
        PlayGame ();
    }
    
    /**
     * PlayGame has the logic to the Hangman game
     */
    public void PlayGame () {
                
        //clearConsole ();
        corpse = ("---\n   |\n   |\n   ");
        StringBuilder temp = new StringBuilder (" ");
        
        Random rand = new Random ();
        int w = rand.nextInt (15);
        int length = pool [w].length ();
        
        System.out.println ("Word Length:");
        for (int i = 0; i < length; i++) {
            System.out.print ("-");
            temp.append('-');
        }
        
        String compare;
        char input = ' ';
        int part = 0;
        boolean foundletter;
        
        int tl = length;
        
        do {
            Scanner scan = new Scanner (System.in);
            System.out.println ("\nEnter a letter to guess the hangman word: ");
            String c = scan.next ();
            input = c.charAt (0);
            foundletter = false;
            
            if (tl == length) {     //bug fix temp added a "-" for some reason
                temp.deleteCharAt(length);
                tl --;
            }
            
            for (int i = 0; i < length; i++) {
                char b = pool[w].charAt (i);
                if (b == input) {
                    temp.setCharAt (i, b);
                    foundletter = true;
                }
            }
            if (foundletter == false) {
                System.out.println ("\nLetter entered not found, part added to hangman");
                part += 1;
                addPart (part);
            }
            else
                System.out.println ("\nLetter entered found in word");
            
            System.out.println (temp);
            System.out.println ("\nCurrent Hangman:\n" + corpse);
            
            compare = temp.toString ();
            if (compare.equals (pool[w]))
                break;
            
        }while (!corpse.equals ("---\n   |\n   |\n   O\n+--I--+\n   I\n  / \\ \n_/   \\_") 
                && input != 'q' && input != 'Q');
        
        if (input == 'q' || input == 'Q')
            ReturnToLauncher ();
        
        if (corpse.equals ("---\n   |\n   |\n   O\n+--I--+\n   I\n  / \\ \n_/   \\_")) {
            System.out.println ("\nYou died :(\nPlay Again? Enter 'y' for yes, or 'q' to return to launcher: ");
            PlayAgain ();
        }
        
        if (compare.equals (pool[w])) {
            System.out.println ("You found the word!\nPlay Again? Enter 'y' for yes, or 'q' to return to launcher: ");
            PlayAgain ();
        }
    }
    /**
     * Will add a text to string representing current hangman
     * @param i -> specifies a part number
     */
    public void addPart (int i) {
        if (i == 1)             //i = 1; head
            corpse += "O";
        if (i == 2)             //i = 2; left arm
            corpse += "\n+--";
        if (i == 3)             //i = 3; upper torso
            corpse += "I";
        if (i == 4)             //i = 4; right arm
            corpse += "--+";
        if (i == 5)             //i = 5; lower torso
            corpse += "\n   I";
        if (i == 6)             //i = 6; upper legs
            corpse += "\n  / \\ ";
        if (i == 7)             //i = 7; lower legs
            corpse += "\n_/   \\_";
    }
    
    
    /** 
     * Scanner that will determine if user plays again or not 
     */
    public void PlayAgain () {
        char c;
        do {
            Scanner scan = new Scanner (System.in);
            String s = scan.next ();
            c = s.charAt (0);
            if (c == 'y' || c == 'Y')
                PlayGame ();
            else if (c != 'q' && c != 'Q' 
                    && c != 'y' && c != 'Y')
                System.out.println ("Enter a valid choice: ");
        }while (c != 'q' && c != 'Q');
    }
    
    /**
     * will call ClearConsole and make the GameLauncher mainWindow visible again
     */
    public void ReturnToLauncher () {
        clearConsole ();
        mainWindow.setVisible (true);
      //  return;
    }
    /**
     * code I found that is intended to clear the console of output 
     */
    public static void clearConsole() {
        System.out.print ("\033[H\033[2J");
        System.out.flush ();
    }
}
