package blackjack;

import java.util.*;

/*
 * Author Silas Knox
 */
public class Dealer {
	public List<Integer> dCards;
	Deck deck = new Deck();

	/**
	 * Constructor with no parameters
	 */
	public Dealer() {
	}
	/**
	 * This method will keep adding cards to the Dealers hand as long as the sum of all the Dealers cards are less than 16
	 * @param dCards
	 * @param deck
	 */
	public static void dealersTurn(List<Integer> dCards, Deck deck) {
		int sum = 0;
		for (int i = 0; i < dCards.size(); i++) {
			sum = sum + dCards.get(i);
		}
		while (sum < 16) {
			dCards.add(Deck.takeCard(deck.deck));
			sum = sum + dCards.indexOf(dCards.size() - 1);
		}

	}

	public static void takeCard(List<Integer> dCards, Deck deck, int cardTotal) {
		int returnedCard = Deck.takeCard(deck.deck);
		if(returnedCard == 11) {
			if (cardTotal < 11)

			{

			returnedCard = 11;

			}

			else

			{

			 returnedCard = 1;
			}
		}
		dCards.add(returnedCard);
	}

}
