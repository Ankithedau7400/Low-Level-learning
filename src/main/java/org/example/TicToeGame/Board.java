package org.example.TicToeGame;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Board {
    // 3x3 grid to store player moves
    private final Player[][] grid = new Player[3][3];

    public void updateBoard(int colIndex, int rowIndex, Player player) {
        if (grid[colIndex][rowIndex] == null) {
            grid[colIndex][rowIndex] = player;
        }
    }
    // Checks if all positions on the board are filled
    public boolean isFull() {
        return Arrays.stream(grid).flatMap(Arrays::stream).noneMatch(Objects::isNull);
    }

    // Resets the board by clearing all positions
    public void reset() {
        for (Player[] players : grid) {
            Arrays.fill(players, null);
        }
    }
    // Returns the player at the specified position, or null if empty
    public Player getPlayerAt(int colIndex, int rowIndex) {
        return grid[colIndex][rowIndex];
    }

    // Checks for a winner by examining rows, columns, and diagonals
    public Optional<Player> getWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != null && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return Optional.of(grid[i][0]);
            }
            if (grid[0][i] != null && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return Optional.of(grid[0][i]);
            }
        }
        // Check diagonals
        if (grid[0][0] != null && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return Optional.of(grid[0][0]);
        }
        if (grid[0][2] != null && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return Optional.of(grid[0][2]);
        }
        return Optional.empty();
    }

}
