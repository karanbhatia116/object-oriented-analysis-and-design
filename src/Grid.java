import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final int size;
    private final ArrayList<Cell> cells = new ArrayList<>();

    public Grid(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells.add(new Cell(new Position(i, j)));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void printGrid() {
        for (int i = 0; i < size*size; i+=size) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.cells.get(i + j).getSymbolOnCell().isEmpty() ? "|___|" : "|_" + this.cells.get(i + j).getSymbolOnCell().get().type.name() + "_|");
            }
            System.out.println();
        }
    }
}
