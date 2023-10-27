import javax.naming.directory.InvalidAttributesException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================Welcome to TIC-TAC-TOE============================");
        System.out.println("\n\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of grid ");
        int sizeOfGrid = scanner.nextInt();
        if(sizeOfGrid <= 2){
            System.out.println("Size of the grid has to be greater than or equal to 3! Restart the game...");
            return;
        }
        Grid grid = new Grid(sizeOfGrid);
        System.out.println("Enter player 1 name ");
        String playerName = scanner.next();
        Player player1 = new Player(playerName, new Symbol(SymbolType.X));
        System.out.println("Enter player 2 name ");
        playerName = scanner.next();
        Player player2 = new Player(playerName, new Symbol(SymbolType.O));

        Game game = new Game(grid, List.of(player1, player2), player1, GameStatus.NOT_STARTED);
        System.out.println("Starting game... Let's play");
        game.start();
        while(game.getGameStatus() == GameStatus.ACTIVE){
            try{
                game.getGrid().printGrid();
                System.out.println("Player " + game.getCurrentPlayer().getName() + " please make a move...");
                String move = scanner.next();
                int x = Integer.parseInt(Arrays.stream(move.split(",")).skip(0).findFirst().get());
                int y = Integer.parseInt(Arrays.stream(move.split(",")).skip(1).findFirst().get());
                Position position = new Position(x, y);
                game.playMove(position);
                if(game.getGameStatus()!=GameStatus.ACTIVE){
                    break;
                }
                game.switchCurrentPlayer();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.print("\n\n");
        game.getGrid().printGrid();
        System.out.println("\n\n\n" + game.getGameStatus());
        if(game.getGameStatus() == GameStatus.X_WINS || game.getGameStatus() == GameStatus.O_WINS){
            System.out.println("Congratulations! " + game.getCurrentPlayer().getName());
        }
    }
}