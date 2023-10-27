import java.util.Optional;

public class Cell {
    private final Position position;
    private Optional<Symbol> symbolOnCell;

    public Cell(Position position) {
        this.position = position;
        this.symbolOnCell = Optional.empty();
    }

    public Position getPosition() {
        return position;
    }

    public Optional<Symbol> getSymbolOnCell() {
        return symbolOnCell;
    }

    public Boolean isCellEmpty(){
        return symbolOnCell.isEmpty();
    }

    public void placeSymbol(Symbol symbol){
        this.symbolOnCell = Optional.of(symbol);
    }
}
