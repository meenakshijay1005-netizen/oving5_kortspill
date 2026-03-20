package com.example.kortspill;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

    @Test
    void sumOfFacesShouldReturnCorrectSum() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 1),
                new PlayingCard('S', 5),
                new PlayingCard('D', 10),
                new PlayingCard('C', 3),
                new PlayingCard('H', 12)
        ));

        assertEquals(31, hand.sumOfFaces());
    }

    @Test
    void heartsAsStringShouldReturnOnlyHearts() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 12),
                new PlayingCard('S', 5),
                new PlayingCard('H', 1),
                new PlayingCard('C', 3),
                new PlayingCard('D', 9)
        ));

        assertEquals("H12 H1", hand.heartsAsString());
    }

    @Test
    void heartsAsStringShouldReturnNoHeartsWhenNoneExist() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('S', 12),
                new PlayingCard('S', 5),
                new PlayingCard('D', 1),
                new PlayingCard('C', 3),
                new PlayingCard('D', 9)
        ));

        assertEquals("No Hearts", hand.heartsAsString());
    }

    @Test
    void containsQueenOfSpadesShouldReturnTrueWhenPresent() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('S', 12),
                new PlayingCard('H', 5),
                new PlayingCard('D', 7),
                new PlayingCard('C', 9),
                new PlayingCard('H', 3)
        ));

        assertTrue(hand.containsQueenOfSpades());
    }

    @Test
    void containsQueenOfSpadesShouldReturnFalseWhenNotPresent() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('S', 11),
                new PlayingCard('H', 5),
                new PlayingCard('D', 7),
                new PlayingCard('C', 9),
                new PlayingCard('H', 3)
        ));

        assertFalse(hand.containsQueenOfSpades());
    }

    @Test
    void isFlushShouldReturnTrueForFiveCardsSameSuit() {
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
    void isFlushShouldReturnFalseWhenNoFlushExists() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 1),
                new PlayingCard('S', 2),
                new PlayingCard('D', 3),
                new PlayingCard('C', 4),
                new PlayingCard('H', 5)
        ));

        assertFalse(hand.isFlush());
    }

    @Test
    void constructorShouldThrowExceptionIfNull() {
        assertThrows(IllegalArgumentException.class, () -> new HandOfCards(null));
    }
}