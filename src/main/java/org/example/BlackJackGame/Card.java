package org.example.BlackJackGame;

public class Card {
    public final Rank rank;
    public final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int[] getRankValues() {
        return rank.getRankValues();
    }
}
