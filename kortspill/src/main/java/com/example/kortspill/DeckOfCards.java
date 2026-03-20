package com.example.kortspill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private final char[] suits = {'S', 'H', 'D', 'C'};
    private final List<PlayingCard> deck;
    private final Random random;

    public DeckOfCards() {
        this.deck = new ArrayList<>();
        this.random = new Random();
        createDeck();
    }

    private void createDeck() {
        for (char suit : suits) {
            for (int face = 1; face <= 13; face++) {
                deck.add(new PlayingCard(suit, face));
            }
        }
    }

    public List<PlayingCard> getDeck() {
        return new ArrayList<>(deck);
    }

    public HandOfCards dealHand(int n) {
        if (n < 1 || n > deck.size()) {
            throw new IllegalArgumentException("n must be between 1 and " + deck.size());
        }

        List<PlayingCard> tempDeck = new ArrayList<>(deck);
        List<PlayingCard> handCards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(tempDeck.size());
            handCards.add(tempDeck.remove(randomIndex));
        }

        return new HandOfCards(handCards);
    }
}
