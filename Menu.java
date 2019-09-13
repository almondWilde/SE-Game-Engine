import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Integer;

public class Menu{
	
	public static void displayMenu()
	{
		int game_to_launch = -1;

		while (game_to_launch == -1)
		{
			//list games
			Object[] game_titles = {"TicTacToe", "Black Jack", "Snake", "Hangman", "Rock, Paper, Scissors", "Poker", "Minesweeper", "Bingo"};
			game_to_launch = JOptionPane.showOptionDialog(null, "What would you like to play?", "SE-Game-Launcher", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, game_titles, game_titles[0]);

			if(game_to_launch == -1)
			{
				JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE); 
			}
			else
			{
				switch(game_to_launch){
					case 0:
						//launch_ttt();
						break;
					case 1:
						//launch_bj();
						break;
					case 2:
						//launch_s();
						break;
					case 3:
						//launch_h();
						break;
					case 4:
						//launch_rps();
						break;
					case 5:
						//launch_p();
						break;
					case 6:
						//launch_m();
						break;
					case 7:
						//launch_b();
						break;
				}
			}
	}		
		



		/*	
			-list games as file directories
		*/
		//user picks game
		//launch selected game
	}

	public static void main( String[] args)
	{
		displayMenu();
		/*System.out.println( args[0]);

		Scanner input = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		System.out.println("Hello, " + name);
	
		JOptionPane.showMessageDialog(null, name + " sucks eggs");

		String var = JOptionPane.showInputDialog("whats your mother's age? ");

		int num1 = Integer.parseInt(var);
		System.out.println(num1);
*/
		System.exit(0);
	}

}