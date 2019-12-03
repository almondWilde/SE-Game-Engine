/*
 Class: Hand
 Creates a hand object
 @author Ryan Flynn
 Last Edit: 12/2/19
 12/1/19
 11/27/19
 11/20/19
*/
package games.BlackJack;
import java.awt.*;
import java.util.*;

public class Hand{
	public int count = 0;
	private Card[] Hand;
	
	public Hand() {
		Hand = new Card[10];
	}
	public void add(Card card){
		Hand[count++] = card;
	}
	public Card getTopCard(){
		return Hand[0];
	}
	public Card getBottomCard() {
		return Hand[1];
	}
	//returns the value of a hand
	public int valueOf(){
		int sum=0;
		int rank=0;
		int count2= count;
		int aces = 0;
		for(int i=0; i< count2; i++){
			rank = Hand[i].valueOf();
			sum += rank;
			//counter to count the number of aces in a hand
			if( rank == 11){
				aces++;
			}
		}
		//changes the value of an ace from 11 to 1 if the value of the ace would cause the value of the hand to exceed 21
		while (aces > 0 && sum >21){
			sum -= 10;
			aces--;
		}		
		return sum;
	}
	//check if the value of 2 cards is the same and returns true allowing splitting
	public boolean splittable() {
		if (Hand[0].valueOf() == Hand[1].valueOf()) {
			}
		return true;
	}
	//check if the value of a hand is 21
	public boolean hasBlackJack(){
		int total = Hand[0].valueOf() + Hand[1].valueOf();
		return total ==21;
	}
	//check if the hand value is over 21
	public boolean Bust(){
		return valueOf() > 21;
	}
	//returns the hand and value as a string 
	public String toString(){
		String string ="";
		int count3 = count;
		for(int i=0; i< count3; i++){
			string += Hand[i].toString();
			string += "\n";
		}
		if(Bust()){
			string += "\n\n";
			string += "You Busted Out";
		}
		if(hasBlackJack()){
			string += "\n\n";
			string += "You Have a Blackjack!";
		}
		return string;
	}
	public static void main(String[] args){
		Deck deck = new Deck();
		deck.shuffle();
		Hand test = new Hand();
		test.add(deck.nextCard());
		test.add(deck.nextCard());
		test.add(deck.nextCard());
		System.out.println(test.toString());
		System.out.println(test.valueOf());
	}
}
//55 lines