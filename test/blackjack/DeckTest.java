package blackjack;

 

import static org.junit.jupiter.api.Assertions.*;

 

import org.junit.jupiter.api.Test;

 

class DeckTest {

 

    @Test
    void testTakeCard() {
        Deck deck = new Deck();
        //Deck.shuffleCards(deck.deck);
        assertEquals(1, Deck.takeCard(deck.deck));
    }

 

}