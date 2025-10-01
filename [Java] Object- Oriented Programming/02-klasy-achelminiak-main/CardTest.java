package test;

import main.Card;
import org.junit.Test;
import static org.junit.Assert.*;
public class CardTest {
    @Test
    public void testCardMethods() {

        Card card1 = new Card(Card.Color.HEARTS, Card.Value.TEN);
        Card card2 = new Card(Card.Color.DIAMONDS, Card.Value.FIVE);
        Card card3 = new Card(Card.Color.CLUBS, Card.Value.JACK);

        // Sprawdzamy czy karty zachowują się zgodnie z oczekiwaniami
        assertTrue(card1.beats(card2));
        assertFalse(card2.beats(card3));
        assertTrue(card3.beats(card1));
    }
}

