package org.example.BlackJackGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    int nextCardIndex =0;
    List<Card> cards;
    public Deck() {
        initializeDeck();
    }
    private void initializeDeck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        nextCardIndex = 0; // Reset to start drawing from the first card
    }

    // Shuffles the deck using current time as seed
    public void shuffle() {
        Collections.shuffle(cards, new Random(System.currentTimeMillis()));
    }

    public Card draw() {
        if (isEmpty() || nextCardIndex >= cards.size()) {
            throw new IllegalStateException("No more cards in deck");
        }
        Card drawCard = cards.get(nextCardIndex);
        nextCardIndex++;
        return drawCard;
    }


    public void reset() {
        nextCardIndex = 0;
    }
    public int getRemainingCardCount() {
        return cards.size() - nextCardIndex;
    }

    public boolean isEmpty() {
        return getRemainingCardCount() == 0;
    }
}
