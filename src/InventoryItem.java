public class InventoryItem {
    private int count;
    private final ProductType product;

    InventoryItem(String name, int minPrice, int maxPrice) {
        this.count = 0;
        this.product = new ProductType(name, minPrice, maxPrice);
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
