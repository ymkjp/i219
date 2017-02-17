public enum Item {
    MILK(40), JUICE(80), COFFEE(120);
    private final int cost;
    Item(int c) { cost = c; }
    public int getCost() { return cost; }
}