import java.util.Scanner;
import java.io.*;
import java.util.Random;

class Player{
	private String weapon; /* A: Rock B: Paper C: Scissors */
	private boolean isUser;

	Player(boolean isUser){
		this.isUser = isUser;
		this.weapon = "";

		Scanner scan = new Scanner(System.in);
		boolean valid = false;

		//not user
		if(!this.isUser)
		{
			Random rand = new Random();
			int randint = rand.nextInt(2);

			switch( randint ){
				case 0:
					this.weapon = "A";
					break;
				case 1:
					this.weapon = "B";
					break;
				case 2:
					this.weapon = "C";
					break;
			}
		}

		//is user
		String user_weapon = "";
		do{
			System.out.println("Choose your Weapon!\nA) Rock\nB) Paper\nC) Scissors\n\n");
			weapon = scan.nextLine();
			weapon.toUpperCase();

			valid = weapon.matches("[A-C,a-c]+");
			if(!valid){
				System.out.println("Invalid Weapon Choice! Choose another weapon..!\n\n");
			}
		}
		while(!valid);
		this.weapon = weapon;
	}
	public String getWeapon() { return this.weapon; };
	public boolean returnIsUser() { return this.isUser; }
}

public class RPS{
	private static Player user, cpu;

	public RPS(){
		this.user = new Player(true);
		this.cpu = new Player(false);
	}

	/*
		A - Rock
		B - Paper
		C - Scissors
	*/
	public static String battle(Player user, Player cpu){
	String[] returnMessage = {"DRAW", "USER WINS", "CPU WINS", "ERROR ERROR TRY AGAIN"};
	
	String uw = user.getWeapon().toUpperCase(), cw = cpu.getWeapon().toUpperCase();

		if( uw.equals( cw ) )
			return returnMessage[0];
		else if( cw.equals("A") ){		//cpu has a rock
			if(uw.equals("B"))		//user has paper; user wins
				return returnMessage[1];
			else if(uw.equals("C"))		//user has scissors; user loses
				return returnMessage[2];
		}	
		else if( cw.equals("B") ){		//cpu has paper
			if(uw.equals("A"))		//user has rock; user wins
				return returnMessage[1];
			else if(uw.equals("C"))		//user has scissors; user loses
				return returnMessage[2];
		}
		else if( cw.equals("C") ){		//cpu has scissors
			if(uw.equals("A"))		//user has rock; user wins
				return returnMessage[1];
			else if(uw.equals("B"))		//user has paper; user loses
				return returnMessage[2];
		}
		return returnMessage[3];
	}

	public static void main(String[] args)throws NullPointerException{
		RPS new_game = new RPS();
		boolean cont_bool = false;
		String cont_response;
		Scanner cont_scanner = new Scanner(System.in);

		do{
			user = new Player(true);
			cpu = new Player(false);
			System.out.println( new_game.battle(user, cpu) );
		
			do{
				System.out.println( "Do you want to play again? [Y/N] ");
				cont_response = cont_scanner.nextLine();
				cont_response = cont_response.toUpperCase();
			}while(!cont_response.equals("Y") && !cont_response.equals("N") );

			if(cont_response.equals("Y") || cont_response.equals("y"))
				cont_bool = true;
			else if( cont_response.equals("N") || cont_response.equals("n") )
				cont_bool = false;
		}while(cont_bool);


	}
}