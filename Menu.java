import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Integer;

public class Menu{
	
	public static void displayMenu()
	{
		//list games
		System.out.printf("Choose a game: \n1. Tic Tac Toe\n2.rock paper scissors");
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