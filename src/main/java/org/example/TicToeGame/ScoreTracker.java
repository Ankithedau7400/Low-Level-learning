package org.example.TicToeGame;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreTracker {

    // Stores player ratings in a map where key is player and value is their score
    private HashMap<Player, Integer> playerRatings = new HashMap<>();


    // This logic is customizable and, in reality, will use a complex ranking algorithm. For the
    // interview, we use a simple victory count system where the winner gets one point, the loser
    // loses a point, and no changes occur for a draw.
    public void reportGameResult(Player player1, Player player2, Optional<Player> winningPlayer){
        if(winningPlayer.isPresent()){
            Player winner = winningPlayer.get();
            Player loser = player1 == winner?player1:player2;
            playerRatings.putIfAbsent(winner, 0);
            playerRatings.put(winner, playerRatings.get(winner) + 1);
            playerRatings.putIfAbsent(loser, 0);
            playerRatings.put(loser, playerRatings.get(loser) - 1);
        }
    }

    // Returns a map of players sorted by their ratings in descending order
    public Map<Player, Integer> getTopPlayers() {

        return playerRatings.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toMap(player -> player, player -> playerRatings.get(player)));
    }

    // Returns the rank of a player based on their rating
    public int getRank(Player player) {
        List<Player> sortedPlayers =
                playerRatings.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
        return sortedPlayers.indexOf(player) + 1;
    }
}
