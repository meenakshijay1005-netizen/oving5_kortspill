package com.example.kortspill;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HandOfCards {
    private final List<PlayingCard> cards;

    public HandOfCards(List<PlayingCard> cards) {
        if (cards == null || cards.isEmpty()) {
            throw new IllegalArgumentException("Hånda kan ikke være tom");
        }
        this.cards = List.copyOf(cards);
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public int sumOfFaces() {
        return cards.stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
    }

    public List<PlayingCard> hearts() {
        return cards.stream()
        .filter(card -> card.getSuit() == 'H')
        .toList();
    }

    public String heartsAsString() {
        List<PlayingCard> hearts = hearts();
        if (hearts.isEmpty()) {
            return "No Hearts";
        }

        return hearts.stream()
        .map(PlayingCard::toString)
        .collect(Collectors.joining(" "));
    }

    public boolean containsQueenOfSpades() {
        return cards.stream()
        .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
    }

    public boolean isFlush() {
        Map<Character, Long> suitCount = cards.stream()
        .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));

        return suitCount.values().stream()
        .anyMatch(count -> count >= 5);
    }

    public String asString() {
        return cards.stream()
        .map(PlayingCard::toString)
        .collect(Collectors.joining(" "));
    }
}
