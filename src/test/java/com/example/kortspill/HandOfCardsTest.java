package com.example.kortspill;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class HandOfCardsTest {
    @Test
    void sumOfFacesReturnsCorrectSum() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 1),
                new PlayingCard('S', 12),
                new PlayingCard('D', 5)
        ));

        assertEquals(18, hand.sumOfFaces());
    }

    @Test
    void containsQueenOfSpadesReturnsTrueWhenPresent() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('S', 12),
                new PlayingCard('H', 3),
                new PlayingCard('D', 8)
        ));

        assertTrue(hand.containsQueenOfSpades());
    }

    @Test
    void containsQueenOfSpadesReturnsFalseWhenNotPresent() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('S', 11),
                new PlayingCard('H', 3),
                new PlayingCard('D', 8)
        ));

        assertFalse(hand.containsQueenOfSpades());
    }

    @Test
    void isFlushReturnsTrueForFiveCardsOfSameSuit() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 1),
                new PlayingCard('H', 2),
                new PlayingCard('H', 3),
                new PlayingCard('H', 4),
                new PlayingCard('H', 5)
        ));

        assertTrue(hand.isFlush());
    }

    @Test
    void isFlushReturnsFalseWhenNotFlush() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 1),
                new PlayingCard('S', 2),
                new PlayingCard('H', 3),
                new PlayingCard('D', 4),
                new PlayingCard('C', 5)
        ));

        assertFalse(hand.isFlush());
    }
}
