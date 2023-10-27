import exceptions.InvalidMoveException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Game {
    private final Grid grid;
    private final List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private int[] horizontalSum;
    private int[] verticalSum;
    private int diagonalSum;
    private int revDiagonalSum;
    private int moveCounter;


    public Game(Grid grid, List<Player> players, Player currentPlayer, GameStatus gameStatus) {
        this.grid = grid;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.gameStatus = gameStatus;
        this.horizontalSum = new int[this.grid.getSize()];
        this.verticalSum = new int[this.grid.getSize()];
        this.diagonalSum = 0;
        this.revDiagonalSum = 0;
        this.moveCounter = 0;
    }

    private void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }
    private int getMoveCounter(){
        return this.moveCounter;
    }

    public Grid getGrid() {
        return grid;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void switchCurrentPlayer(){
        Player otherPlayer = players
                .stream()
                .filter(it -> !Objects.equals(it.getName(), this.getCurrentPlayer().getName()))
                .findFirst()
                .get();
        this.setCurrentPlayer(otherPlayer);
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void start(){
        this.setGameStatus(GameStatus.ACTIVE);
    }

    public void playMove(Position position) throws InvalidMoveException, IllegalStateException {
        if(getGameStatus() != GameStatus.ACTIVE){
            throw new IllegalStateException("Game is not active right now! Start a new game. Illegal move...");
        }
        Optional<Cell> cellToPlayMove = grid.getCells().stream().filter(cell -> cell.getPosition().equals(position)).findFirst();
        if(cellToPlayMove.isEmpty()){
            throw new InvalidMoveException("Unable to find the cell where you are trying to make a move on!");
        }
        if(!cellToPlayMove.get().isCellEmpty()){
            throw new InvalidMoveException("The cell is not empty where you are trying to make a move on! Please try some other cell...");
        }
        if(this.getMoveCounter() == this.getGrid().getSize() * this.getGrid().getSize()){
            this.setGameStatus(GameStatus.DRAW);
            return;
        }
        if(Math.abs(horizontalSum[position.getX()]) == grid.getSize()
                || Math.abs(verticalSum[position.getY()]) == grid.getSize()
                || Math.abs(diagonalSum) == grid.getSize()
                || Math.abs(revDiagonalSum) == grid.getSize()){
            if(this.getCurrentPlayer().getSymbol().type == SymbolType.X){
                this.setGameStatus(GameStatus.X_WINS);
            }
            else this.setGameStatus(GameStatus.O_WINS);
            return;
        }
        cellToPlayMove.get().placeSymbol(this.getCurrentPlayer().getSymbol());
        horizontalSum[position.getX()]+= this.getCurrentPlayer().getSymbol().type.value;
        verticalSum[position.getY()]+= this.getCurrentPlayer().getSymbol().type.value;
        this.setMoveCounter(this.getMoveCounter() + 1);
        if(position.getX() == position.getY()){
            diagonalSum += this.getCurrentPlayer().getSymbol().type.value;
        }
        if(position.getX() == grid.getSize() - 1 - position.getY()){
            revDiagonalSum += this.getCurrentPlayer().getSymbol().type.value;
        }
        if(Math.abs(horizontalSum[position.getX()]) == grid.getSize()
                || Math.abs(verticalSum[position.getY()]) == grid.getSize()
                || Math.abs(diagonalSum) == grid.getSize()
                || Math.abs(revDiagonalSum) == grid.getSize()){
            if(this.getCurrentPlayer().getSymbol().type == SymbolType.X){
                this.setGameStatus(GameStatus.X_WINS);
            }
            else this.setGameStatus(GameStatus.O_WINS);
        }
        if(this.getMoveCounter() == this.getGrid().getSize() * this.getGrid().getSize()){
            this.setGameStatus(GameStatus.DRAW);
        }
    }

}
