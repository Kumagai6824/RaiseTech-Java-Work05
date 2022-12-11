public enum Category {
    VEGETABLE("Vegetable"), MEAT("Meat & Fish"), SPICE("Spice");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
