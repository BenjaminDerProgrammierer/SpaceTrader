public class InventoryItem {
    private int count;
    private final ProductType product;

    InventoryItem(ProductType product) {
        this.count = 0;
        this.product = product;
    }

    InventoryItem(String name, int minPrice, int maxPrice) {
        this(new ProductType(name, minPrice, maxPrice));
    }

    public ProductType getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void add(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        count += amount;
    }
}
