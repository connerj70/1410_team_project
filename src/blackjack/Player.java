package blackjack;

import java.util.List;

/*
 * Author Taylor Shipley
 */
public class Player 
{
	String name;
	int cardTotal = 0;
	boolean bust = false;
	boolean blackjack = false;
	boolean stay = false;
	public List<Integer> pCards;
	Deck deck = new Deck();

	public Player(String name)
	{

		this.name = name;

	}

	public void hit() 
	{
		int returnedCard = Deck.takeCard(deck.deck);
		if(returnedCard == 12) 
		{
			if (cardTotal < 11)
			{
				returnedCard = 11;
			}
			else
			{
				returnedCard = 1;
			}
		}
		pCards.add(returnedCard);
		cardTotal += returnedCard;
		checkCardTotal();
	}
	
	public void Stay()
	{
		stay = true;
	}

	private void checkCardTotal() 
	{
		if (cardTotal == 21)
		{
			blackjack = true;
			stay = true;
		}
		else if (cardTotal > 21)
		{
			bust = true;
		}
	}

	public void quitGame()
	{
		System.out.println("Thanks for Playing.");
		System.exit(0);
	}
}