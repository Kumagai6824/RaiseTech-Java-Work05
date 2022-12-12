public class Product {

    private final String name;
    private final Category category;
    private final int cost;

    public Product(String name, Category category, int cost) {
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public Category getCategory() {
        return this.category;
    }

    public int getCost() {
        return this.cost;
    }
}

