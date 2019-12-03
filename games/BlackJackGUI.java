/*
 Class: BlackJackGUI
 Creates the Blackjack GUI
 @author Ryan Flynn
 Last Edit: 12/2/19
 12/1/19
 11/27/19
 11/20/19
*/
package games;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlackJackGUI extends javax.swing.JFrame {

  private Container contentPane;
  private JPanel topButtonPanel = new JPanel();
  private JPanel buttonPanel = new JPanel();
  private JButton aboutButton = new JButton("About");
  private JButton helpButton = new JButton("Help");
  private JButton playButton = new JButton("Play");
  private JButton hitButton = new JButton("Hit");
  private JButton doubleDownButton = new JButton("Double Down");
  private JButton splitButton = new JButton("Split");
  private JButton standButton = new JButton("Stand");
  private JButton betButton = new JButton("Bet");
  private JButton exitButton = new JButton("Exit");
  private JPanel outputPanel = new JPanel();
  private JTextArea playerArea = new JTextArea();
  private JTextArea dealerArea = new JTextArea();

//Creates GUI
  public BlackJackGUI()
  {
	Color newTableColor = new Color(51,102,0);
	Font gameFont = new Font("Serif", Font.BOLD, 32);
    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    outputPanel.setLayout(new BorderLayout());
    setSize(new Dimension(800, 600));
    setTitle("BlackJack");
    setResizable(true);
    setTitle("Blackjack");
    contentPane.add(topButtonPanel, BorderLayout.NORTH);
    topButtonPanel.add(helpButton, null);
    helpButton.setBackground(Color.red);
    helpButton.setForeground(Color.white);
    helpButton.setFont(gameFont);
    topButtonPanel.add(aboutButton, null);
    aboutButton.setBackground(Color.red);
    aboutButton.setForeground(Color.white);
    aboutButton.setFont(gameFont);
    topButtonPanel.add(exitButton, null);
    exitButton.setBackground(Color.red);
    exitButton.setForeground(Color.white);
    exitButton.setFont(gameFont);
    topButtonPanel.setBackground(newTableColor);
    contentPane.add(buttonPanel,  BorderLayout.SOUTH);
    buttonPanel.add(betButton, null);
    betButton.setBackground(Color.red);
    betButton.setForeground(Color.white);
    betButton.setFont(gameFont);
    buttonPanel.add(playButton, null);
    playButton.setBackground(Color.red);
    playButton.setForeground(Color.white);
    playButton.setFont(gameFont);
    buttonPanel.add(hitButton, null);
    hitButton.setBackground(Color.red);
    hitButton.setForeground(Color.white);
    hitButton.setFont(gameFont);
    buttonPanel.add(doubleDownButton, null);
    doubleDownButton.setBackground(Color.red);
    doubleDownButton.setForeground(Color.white);
    doubleDownButton.setFont(gameFont);
    buttonPanel.add(splitButton, null);
    splitButton.setBackground(Color.red);
    splitButton.setForeground(Color.white);
    splitButton.setFont(gameFont);
    buttonPanel.add(standButton, null);
    standButton.setBackground(Color.red);
    standButton.setForeground(Color.white);
    standButton.setFont(gameFont);
    buttonPanel.setBackground(newTableColor);
    contentPane.add(outputPanel, BorderLayout.CENTER);
    outputPanel.setLayout(new FlowLayout());
    outputPanel.add(playerArea, null);
    outputPanel.add(dealerArea, null);
    playerArea.setBackground(newTableColor);
    playerArea.setForeground(Color.white);
    playerArea.setFont(gameFont);
    dealerArea.setBackground(newTableColor);
    dealerArea.setForeground(Color.white);
    dealerArea.setFont(gameFont);
    outputPanel.setBackground(newTableColor);
    hitButton.setEnabled(false);
    doubleDownButton.setEnabled(false);
    splitButton.setEnabled(false);
    standButton.setEnabled(false);
    exitButton.setEnabled(true);
    playerArea.setText("  ");
    dealerArea.setText("  ");
    int width = getWidth();
    int height = getHeight();
    playerArea.setPreferredSize(new Dimension(width/2-20,height));
    dealerArea.setPreferredSize(new Dimension(width/2-20,height));
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
  }
  //sets button action listeners
  public void setAbout(ActionListener listener) {
	  aboutButton.addActionListener(listener);
  }
  public void setHelp(ActionListener listener) {
	  helpButton.addActionListener(listener);
  }
  
  public void setBet(ActionListener listener) {
	  betButton.addActionListener(listener);
  }
  public void setPlay(ActionListener listener) {
    playButton.addActionListener(listener);
  }

  public void setHit(ActionListener listener) {
    hitButton.addActionListener(listener);
  }

  public void setDoubleDown(ActionListener listener) {
	doubleDownButton.addActionListener(listener);  
  }
  
  public void setSplit(ActionListener listener) {
	splitButton.addActionListener(listener);  
  }
  public void setStand(ActionListener listener) {
    standButton.addActionListener(listener);
  }
  
  public void setExit(ActionListener listener) {
	  exitButton.addActionListener(listener);
  }

  public void displayPlayer(Hand hand) {
    playerArea.setText("Player:\n"+hand.valueOf()+"\n"+hand);
  }

  public void displayDealer(Hand hand) {
    dealerArea.setText("Dealer:\n"+hand.valueOf()+"\n"+hand);
  }

  public void displayDealerCard(Card card) {
    dealerArea.setText("Dealer Shows:\n"+card);
  }

  public void displayOutcome(String outcome) {
    playerArea.setText(playerArea.getText()+"\n\n"+outcome);
  }
  //functions to activate and deactivate certain buttons contextually
  public void activateHelp() {
	  helpButton.setEnabled(true);
  }
  
  public void activateAbout() {
	  aboutButton.setEnabled(true);
  }
  
  public void activateSplit() {
	playButton.setEnabled(false);
	betButton.setEnabled(false);
	hitButton.setEnabled(true);
	doubleDownButton.setEnabled(true);
	splitButton.setEnabled(true);
	standButton.setEnabled(true);
	exitButton.setEnabled(true);
  }
  
  public void activateHitDoubleStand() {
    playButton.setEnabled(false);
    betButton.setEnabled(false);
    hitButton.setEnabled(true);
    doubleDownButton.setEnabled(true);
    standButton.setEnabled(true);
    exitButton.setEnabled(true);
  }

  public void activatePlay() {
    playButton.setEnabled(true);
    betButton.setEnabled(false);
    hitButton.setEnabled(false);
    doubleDownButton.setEnabled(false);
    standButton.setEnabled(false);
    exitButton.setEnabled(true);
  }
  
  public void activateBet() {
	playButton.setEnabled(false);
	betButton.setEnabled(true);
	hitButton.setEnabled(false);
    doubleDownButton.setEnabled(false);
	standButton.setEnabled(false);
	exitButton.setEnabled(true); 
  }

  static public void main(String[] args) {
    new BlackJackGUI();
  }

}
//151 lines