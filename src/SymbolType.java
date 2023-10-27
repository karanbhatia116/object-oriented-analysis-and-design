public enum SymbolType {
    X(1),
    O(-1);

    public final int value;

    SymbolType(int value) {
        this.value = value;
    }
}
