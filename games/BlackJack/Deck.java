/**
 * Class: Deck
 * Creates a standard deck of playing cards
 * @author Ryan Flynn
 * Last Edit: 12/2/19
 * 12/1/19
 * 11/27/19
 * 11/20/19
*/
package games.BlackJack;
import java.awt.*;
import java.util.*;

public class Deck{
	private Card[] DeckArray = new Card[52];
	private int index = 0;
	/**
	 * Deck Constructor
	 */
	public Deck() {
		int num = 0;
		for(int i =0; i<4; i++){
			for(int j=0; j<13; j++){
			Card a = new Card(i,j);
			 DeckArray[num] = a;
			 num++;
			}
		}
	}
	/**
	 * shuffles the deck
	 */
	public void shuffle(){
		index = 0;
		int counter=0;
		while (counter<1000){
		Random rand = new Random();
		int x= rand.nextInt(52);
		int y= rand.nextInt(52);
		Card stored = DeckArray[x];
		DeckArray[x] = DeckArray[y];
		DeckArray[y] = stored;
		counter++;
	}
	}
	/**
	 * checks if there is another card in the deck
	 * @return
	 */
	public boolean hasNextCard(){
		return index<52;
	}
	/**
	 * returns the next card
	 * @return
	 */
	public Card nextCard(){
		if(index<52){
		index++;
		return DeckArray[index-1];
		
		}
		else{
		return null;
		}
	}
	/**
	 * debug to check deck creation and shuffle
	 * @param args
	 */
	public static void main(String[] args){
		Deck test = new Deck();
		System.out.println(test.toString());
				while(test.hasNextCard()){
			System.out.println(test.nextCard());
		}
		test.shuffle();
		System.out.println(test.toString());
		while(test.hasNextCard()){
			System.out.println(test.nextCard());
		}
	}
}
//38 lines