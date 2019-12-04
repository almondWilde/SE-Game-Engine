/**
 * Class: Card
 * Creates card objects
 * @author Ryan Flynn
 * Last Edit: 12/2/19
 * 12/1/19
 * 11/27/19
 * 11/20/19
*/
package games.BlackJack;
import java.awt.*;
import java.util.*;

public class Card {
        private int suit;
	private int rank;
	private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        private static final String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	/**
	 * Card Constructor. Creates a card with a given suit and rank parameter
	 * @param suit
	 * @param rank
	 */
	public Card(int suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	/**
	 * returns the value of the Card
	 * @return
	 */
	public int valueOf(){

		if (this.rank ==0){
		return 11;
		}
		if (this.rank < 10){
		return rank + 1;
		}
		if(this.rank >=10){
		return 10;
		}
		else{
		return 0;
		}
	}
	/**
	 * returns the value of the card as a string "[Rank] of [Suit]"
	 * @return ranks
	 * @return suits
	 */
	public String toString(){

	        return ranks[this.rank] + " of " + suits[this.suit];
	}
	/**debug to see cards are being created correctly
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		Card cardTest1 = new Card(0,0);
		System.out.println("Card 1 value " + cardTest1.valueOf() + " and is " + cardTest1.toString());
		Card cardTest2 = new Card(1,4);
		System.out.println("Card 2 value " + cardTest2.valueOf() + " and is " + cardTest2.toString());
		Card cardTest3 = new Card(2,7);
		System.out.println("Card 3 value " + cardTest3.valueOf() + " and is " + cardTest3.toString());
	}
}
//27 lines