package org.example.BlackJackGame;

public class DealerPlayer implements Player {
    private final String name = "Dealer";
    private final Hand hand;
    private int bet = 0;
    private final int balance = 0;

    public DealerPlayer() {
        this.hand = new Hand();
    }

    // Bet-handling methods for Dealer (bet, loseBet, returnBet) are empty since dealer doesn't bet.
    @Override
    public void bet(int bet) {
        // Dealer does not place bets
    }

    @Override
    public void loseBet() {
        // Dealer does not lose bets
    }

    @Override
    public void returnBet() {
        // Dealer does not return bets
    }

    // Dealer does not get a payout
    @Override
    public void payout() {
        // Dealer does not receive payout
    }

    @Override
    public boolean isBust() {
        return hand.isBust();
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBet() {
        return bet;
    }
}
