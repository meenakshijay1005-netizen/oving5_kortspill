package com.example.kortspill;

import java.util.Objects;

public class PlayingCard {
    private final char suit;   
    private final int face;   

    public PlayingCard(char suit, int face) {
        if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
            throw new IllegalArgumentException("Ugyldig kortfarge: " + suit);
        }
        if (face < 1 || face > 13) {
            throw new IllegalArgumentException("Kortverdi må være mellom 1 og 13");
        }
        this.suit = suit;
        this.face = face;
    }

    public char getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }

    @Override
    public String toString() {
        return "" + suit + face;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayingCard that)) return false;
        return suit == that.suit && face == that.face;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face);
    }
}