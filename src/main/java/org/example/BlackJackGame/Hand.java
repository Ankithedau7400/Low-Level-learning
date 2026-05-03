package org.example.BlackJackGame;


import java.util.*;

public class Hand {

    final List<Card> handCards = new ArrayList<>();
    final SortedSet<Integer> possibleValues = new TreeSet<>();

    public Hand() {}

    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Cannot add null card to hand");
        }
        handCards.add(card);
        if (possibleValues.isEmpty()) {
            // Initialize with the card's values
            for (int value : card.getRankValues()) {
                possibleValues.add(value);
            }
        }else{
            SortedSet<Integer> newPossibleValue = new TreeSet<>();
            for(int value: possibleValues){
                for(int cardValue: card.getRankValues()){
                    newPossibleValue.add(value+cardValue);
                }
            }
            possibleValues.clear();
            possibleValues.addAll(newPossibleValue);
        }

    }



    public List<Card> getCards() {
        return Collections.unmodifiableList(handCards);
    }

    public SortedSet<Integer> getPossibleValues() {
        return Collections.unmodifiableSortedSet(possibleValues);
    }

    public void clear() {
        handCards.clear();
        possibleValues.clear();
    }

    public boolean isBust() {
        // check if all possible value of the player's hand is busted
        if (possibleValues.isEmpty()) {
            return false;
        } else {
            return possibleValues.first() > 21;
        }
    }


}

