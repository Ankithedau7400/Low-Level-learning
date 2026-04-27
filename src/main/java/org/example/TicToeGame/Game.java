package org.example.TicToeGame;

import java.util.Optional;

public class Game {
    // Core game components
    private final Board board; // Manages the game board state
    private final ScoreTracker scoreTracker; // Keeps track of player scores
    private Player[] players; // Array of players in the game
    private int currentPlayerIndex; // Index of the current player's turn

    private MoveHistory moveHistory; // Tracks the history of moves for potential undo functionality

    public Game(Player playerX, Player playerY) {
        board = new Board();
        scoreTracker = new ScoreTracker();
        startNewGame(playerX, playerY);
    }
    // Resets the game state and initializes players for a new game
    public void startNewGame(Player playerX, Player playerY) {
        board.reset();
        players = new Player[]{playerX,playerY};
        currentPlayerIndex = 0;
        moveHistory.clearHistory();
    }
    // Processes a player's move, validates it, and updates game state
    public void makeMove(int colIndex, int rowIndex, Player player){
        if (getGameStatus().equals(GameCondition.ENDED)) {
            throw new IllegalStateException("game ended");
        }
        if (players[currentPlayerIndex] != player) {
            throw new IllegalArgumentException("not the current player");
        }
        if (board.getPlayerAt(colIndex, rowIndex) != null) {
            throw new IllegalArgumentException("board position is taken");
        }
        board.updateBoard(colIndex, rowIndex, player);
        final Move newMove = new Move(colIndex, rowIndex, player);
        moveHistory.recordMove(newMove);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        if (getGameStatus().equals(GameCondition.ENDED)) {
            scoreTracker.reportGameResult(players[0], players[1], board.getWinner());
        }

    }

    public void undoMove() {
        // Check if game has ended to prevent undoing after winner is reported
        if (getGameStatus().equals(GameCondition.ENDED)) {
            throw new IllegalStateException("game ended and winner already reported");
        }
        // Get the last move from history
        final Move lastMove = moveHistory.undoMove();

        if(currentPlayerIndex == 0){
            currentPlayerIndex = 1;
        }else{
            currentPlayerIndex = 1;
        }
        // Clear the board position of the undone move
        board.updateBoard(lastMove.getColIndex(), lastMove.getRowIndex(), null);
    }
    public ScoreTracker getScoreTracker() {
        return scoreTracker;
    }
    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }
    public GameCondition getGameStatus() {
        Optional<Player> winner = board.getWinner();
        if (winner.isPresent()) {
            return GameCondition.ENDED;
        }
        return board.isFull() ? GameCondition.ENDED : GameCondition.IN_PROGRESS;
    }

}
