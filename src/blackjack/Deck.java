package blackjack;

import java.util.Collection;
import java.util.*;

/*
 * @Author Silas Knox
 */
public class Deck {
	public List<Integer> deck = Arrays.asList(12,2,3,4,5,6,7,8,9,10);
	/**
	 * Constructor with no fields 
	 */
	public Deck() {
		
	}
	/**
	 * Constructs and instantiates the field
	 * @param deck
	 */
	public Deck(List<Integer> deck) {
		this.deck = deck;
	}

	public static List<Integer> shuffleCards(List<Integer> cards) {
		Collections.shuffle(cards);
		return cards;
	}

	public static int takeCard(List<Integer> cards) {
		int x = cards.get(0);
		Collections.rotate(cards, -1);
		return x;
	}
}
