package blackjack;

/*
 * Author Taylor Shipley
 */
public class Player {
	String name;

	int totalCash;

	int cardTotal = 0;

	boolean bust;

	boolean blackjack;

	boolean stay;
	
	Deck deck;

	public Player(String name)

	{

	this.name = name;

	}

	public int hit()

	{

	int card = Deck.takeCard(deck.deck);
	cardTotal += card;
	return card;

	}

	public void quitGame()

	{

	System.out.println("Total winnings: $" + totalCash + "Thanks for Playing.");

	System.exit(0);
	}
}
