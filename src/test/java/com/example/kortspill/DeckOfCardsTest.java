package com.example.kortspill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    @Test
    void deckContains52Cards() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(52, deck.getDeck().size());
    }

    @Test
    void dealHandReturnsCorrectNumberOfCards() {
        DeckOfCards deck = new DeckOfCards();
        HandOfCards hand = deck.dealHand(5);
        assertEquals(5, hand.getCards().size());
    }

    @Test
    void dealHandThrowsExceptionWhenNIsTooLarge() {
        DeckOfCards deck = new DeckOfCards();
        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
    }
}
