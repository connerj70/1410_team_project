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
	public int dealerOffset = 0;
	public int playerOffset = 0;


	
	CardTable(Collection<Card> dealerCards, Collection<Card> playerCards, Deck deck) {
		this.dealerCards = dealerCards;
		this.playerCards = playerCards;
		this.deck = deck;
	}
	
	/*
	 * Paint the cards onto the card table
	 * 
	 * @param g the graphics
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dealerOffset = 0;
		playerOffset = 0;
		dealerCards.forEach(c-> {
			ImageIcon card = new ImageIcon(CardTable.class.getResource("/blackjack/" + c.value() + "c.jpeg"));
			Image image = card.getImage(); // transform it 
			Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			card = new ImageIcon(newimg);  // transform it back
			card.paintIcon(null, g, 250 + dealerOffset, 200);
			dealerOffset += 130;
		});
		
		playerCards.forEach(c -> {
			ImageIcon card = new ImageIcon(CardTable.class.getResource("/blackjack/" + c.value() + "c.jpeg"));
			Image image = card.getImage(); // transform it 
			Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			card = new ImageIcon(newimg);  // transform it back
			card.paintIcon(null, g, 250 + playerOffset, 400);
			playerOffset += 130;
		});
		
		// Draw the deck
		ImageIcon card = new ImageIcon(CardTable.class.getResource("/blackjack/back.jpeg"));
		Image image = card.getImage(); // transform it 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		card = new ImageIcon(newimg);  // transform it back
		card.paintIcon(null, g, 100, 300);
	}
	
	/*
	 * Add a card to the dealers cards.
	 * 
	 * @param card the card that will be added to the dealers hand.
	 */
	public void addToDealerCards(Card card) {
		this.dealerCards.add(card);
		repaint();
	}
	
	/*
	 * Add a card to the players hand.
	 * 
	 * @param card the card that will be added to the players hand.
	 */
	public void addToPlayerCards(Card card) {
		this.playerCards.add(card);
		repaint();
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
	
	public int getDealerScore() {
		return calculateScore(dealerCards);
	}
	
	public int getPlayerScore() {
		return calculateScore(playerCards);
	}
	
	public boolean anyDealerCardsFaceDown() {
		for (Card c: dealerCards) {
			if(c.getFaceUp() == false) {
				return true;
			}
		}
		return false;
	}
	
	private int calculateScore(Collection<Card> cards) {
		int sum = 0;
		for(Card c: cards) {
			sum += c.value();
		}
		return sum;
	}
}
