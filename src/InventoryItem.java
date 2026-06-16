public class InventoryItem {
    private int count;
    private final ProductType product;

    InventoryItem(ProductType product) {
        this.count = 0;
        this.product = product;
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
