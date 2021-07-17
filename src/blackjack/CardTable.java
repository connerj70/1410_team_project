package blackjack;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * Represents the card table where the poker game will be played
 * 
 * @Author Conner Jensen, Silas Knox, Taylor Shipley.
 */
public class CardTable extends JPanel {
	private Collection<Card> dealerCards = new ArrayList<Card>();
	private Collection<Card> playerCards = new ArrayList<Card>();
	private int dealerScore = 0;
	private int playerScore = 0;
	private Deck deck;
	
	CardTable(Collection<Card> dealerCards, Collection<Card> playerCards, Deck deck) {
		this.dealerCards = dealerCards;
		this.playerCards = playerCards;
		this.deck = deck;
	}
	
	/*
	 * Paint the components onto the screen including the roof, windows, door, and background.
	 * 
	 * @param g the graphics
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dealerCards.forEach(c-> {
			ImageIcon card = new ImageIcon(CardTable.class.getResource("/blackjack/2c.jpeg"));
			Image image = card.getImage(); // transform it 
			Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			card = new ImageIcon(newimg);  // transform it back
			card.paintIcon(null, g, 210, 100);
		});
		
		playerCards.forEach(c -> {
			ImageIcon card = new ImageIcon(CardTable.class.getResource("/blackjack/2c.jpeg"));
			Image image = card.getImage(); // transform it 
			Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			card = new ImageIcon(newimg);  // transform it back
			card.paintIcon(null, g, 100, 100);
		});
		
	}
	
	/*
	 * Add a card to the dealers cards.
	 * 
	 * @param card the card that will be added to the dealers hand.
	 */
	public void addToDealerCards(Card card) {
		
	}
	
	/*
	 * Add a card to the players hand.
	 * 
	 * @param card the card that will be added to the players hand.
	 */
	public void addToPlayerCards(Card card) {
		
	}
	
	/*
	 * Get the dealers cards
	 * 
	 * @return the dealers cards.
	 */
	public Collection<Card> getDealerCards() {
		return new ArrayList<Card>();
	}
	
	/*
	 * Get the players cards.
	 * 
	 * @return the players cards.
	 */
	public Collection<Card> getPlayerCards() {
		return new ArrayList<Card>();
	}
	
	private int calculateScore(Collection<Card> cards) {
		return 0;
	}
}
