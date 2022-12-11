public class Products {

    private final String productName;
    private final Category productCategory;
    private final int productCost;

    public Products(String productName, Category productCategory, int productCost) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productCost = productCost;
    }

    public String getProductName() {
        return this.productName;
    }

    public Category getProductCategory() {
        return this.productCategory;
    }

    public int getProductCost() {
        return this.productCost;
    }
}

