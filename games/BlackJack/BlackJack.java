/*
 Project: BlackJack
 This program creates a functional Blackjack game for the Epsilon Game Launcher
 @author Ryan Flynn
 Last Edit: 12/2/19
 12/1/19
 11/27/19
 11/20/19
*/

package games.BlackJack;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

public class BlackJack {
	public Hand player;
	public Hand playerSplit;
	public Hand dealer;
	public Deck deck;
	public int bet = 0;
	public int cash = 1000;
	public BlackJackGUI GUI;
	public BlackJack(JFrame mainWindow,JPanel pCenter) throws IOException {
	GUI = new BlackJackGUI();
	GUI.setAbout(new About());
	GUI.setHelp(new Help());
	GUI.setPlay(new Play());
	GUI.setBet(new Bet());
	GUI.setHit(new Hit());
	GUI.setDoubleDown(new DoubleDown());
	GUI.setSplit(new Split());
	GUI.setStand(new Stand());
	GUI.setExit(new Exit());
	GUI.activateBet();	
	}
	//creates functional buttons
	//displays a box containing information on the game
	class About implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Blackjack Version 1.0" + "\nCreated by: Ryan Flynn" + "\nPart of the Epsilon Game Launcher");
		}
	}
	//displays a box to explain the game to the user
	class Help implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "The object of BlackJack is to create a hand that is as close to 21 without going over." + "\nDealer must stand on 17." + "\nBlackJack pays 3:2." + "\nInitial betting money is $1000." + "\nThe minimum bet for this table is $10." + "\nThe maximum bet for this table is $100." + "\nThe program will exit when you have gone bust or select to exit.");
		}
	}
	class Bet implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			bet = Integer.parseInt(JOptionPane.showInputDialog("You have $" + cash + " Enter Your Bet: "));
			while (bet < 10 || bet > cash || bet > 100) {
			if (bet < 10) {
				JOptionPane.showMessageDialog(null, "The minimum bet for this table is $10");
				bet = Integer.parseInt(JOptionPane.showInputDialog("You have $" + cash + " Enter Your Bet: "));	
				}
			if (bet > cash) {
				JOptionPane.showMessageDialog(null, "You cannot bet more money than you have!");
				bet = Integer.parseInt(JOptionPane.showInputDialog("You have $" + cash + " Enter Your Bet: "));	
				}
			if (bet > 100) {
				JOptionPane.showMessageDialog(null, "The maximum bet for this table is $100");
				bet = Integer.parseInt(JOptionPane.showInputDialog("You have $" + cash + " Enter Your Bet: "));	
				}
			}
			GUI.activatePlay();
		}
	}
	//deals a hand after a bet has been entered
	class Play implements ActionListener {
	 public void actionPerformed (ActionEvent e) {
	 deck = new Deck();
	 deck.shuffle();
	 player = new Hand();
	 dealer = new Hand();
	 player.add(deck.nextCard());
	 dealer.add(deck.nextCard());
	 player.add(deck.nextCard());
	 dealer.add(deck.nextCard());
	 GUI.displayPlayer(player);
	 GUI.displayDealerCard(dealer.getTopCard());
	if(!player.hasBlackJack() && !dealer.hasBlackJack() && !player.Bust()) {
	GUI.activateHitDoubleStand();
	}
	 if(player.hasBlackJack() || dealer.hasBlackJack() || player.Bust()) {
		 finishGame();
	 }
	 }
	}
	//allows user to take another card
	class Hit implements ActionListener { 
	 public void actionPerformed (ActionEvent e) {

		 if(!player.Bust() && player.valueOf() !=21){
			 player.add(deck.nextCard());
			 GUI.displayPlayer(player);
		 }
		 if(player.Bust() || player.valueOf()==21){
		 finishGame();}
	 }
	}
	//user takes another card doubles their bet and stands
	class DoubleDown implements ActionListener { 
		 public void actionPerformed (ActionEvent e) {
			 bet = bet + bet;
			 if(!player.Bust() && player.valueOf() !=21){
				 player.add(deck.nextCard());
				 GUI.displayPlayer(player);
				 finishGame();
			 }
			 if(player.Bust() || player.valueOf()==21){
			 finishGame();
			 }
		 }
	}
	//splits the current hand into two hands
	class Split implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (player.splittable() == true) {
				GUI.activateSplit();
			}
			playerSplit = new Hand();
			playerSplit.add(player.getBottomCard());
			GUI.displayPlayer(player);
			GUI.displayPlayer(playerSplit);
			GUI.displayDealerCard(dealer.getTopCard());
		}
	}
	class Stand implements ActionListener {
	public void actionPerformed (ActionEvent e) {	
		finishGame();
		}
	}
	//returns to the Epsilon Game Launcher
	class Exit implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JOptionPane.showMessageDialog(null, "You left with $" + cash);
			GUI.dispose();
		}
	}
	//logic for determining the outcome of a hand
	private void finishGame() {
		if(player.hasBlackJack()) {
		GUI.displayDealer(dealer);
		GUI.displayPlayer(player);
		GUI.displayOutcome("You got BlackJack! +$"+ bet * 3);
		cash = bet + bet + cash;
		}
		else if (dealer.hasBlackJack() && player.hasBlackJack()) {
		GUI.displayDealer(dealer);
		GUI.displayPlayer(player);
		GUI.displayOutcome("The hand was a push +$"+ bet);
		cash = cash;
		}
		else if(dealer.hasBlackJack()) {
		GUI.displayDealer(dealer);
		GUI.displayPlayer(player);
		GUI.displayOutcome("The Dealer had a BlackJack -$" + bet);
		cash = cash - bet;
		}
		else if (player.Bust()) {
		GUI.displayDealer(dealer);
		GUI.displayPlayer(player);
		GUI.displayOutcome("You busted -$" + bet);
		cash = cash - bet;
		}
		else {
			while(dealer.valueOf()<17 && !dealer.Bust()) {
			 dealer.add(deck.nextCard());
			}
		   if(dealer.Bust())
			   {GUI.displayDealer(dealer);
		           GUI.displayPlayer(player);
			   GUI.displayOutcome("Dealer busted +$" + bet);
			   cash = bet + cash;
			   }
                  else if (dealer.hasBlackJack()) {
			   GUI.displayDealer(dealer);
		           GUI.displayPlayer(player);
		           GUI.displayOutcome("The Dealer had a BlackJack -$" + bet);
		           cash = cash - bet;
			   } 
		   else if (dealer.valueOf() == player.valueOf())
			   {GUI.displayDealer(dealer);
			   GUI.displayPlayer(player);
			   GUI.displayOutcome("The hand was a push +$" + bet);
			   cash = cash;
			   }
		   else if (dealer.valueOf() > player.valueOf()) {
			   GUI.displayDealer(dealer);
	                   GUI.displayPlayer(player);
		   	   GUI.displayOutcome("You lost -$" + bet);
		   	   cash = cash - bet;
		   	   }
		   else if (player.valueOf() > dealer.valueOf()) {
			   GUI.displayDealer(dealer);
		           GUI.displayPlayer(player);
		           GUI.displayOutcome("You won +$" + bet * 2);
		           cash = bet + cash;
		           }			 
		}
		//exits the game if the user runs out of money
		if (cash == 0) {
			JOptionPane.showMessageDialog(null, "You have busted out. Better luck next time");
			GUI.dispose();
		}
		GUI.activateBet();
	}

//142 lines
}