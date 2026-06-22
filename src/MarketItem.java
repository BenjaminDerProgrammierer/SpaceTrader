import java.util.concurrent.ThreadLocalRandom;

public class MarketItem extends InventoryItem {
    private int price;

    MarketItem(ProductType product) {
        super(product);
        rollPrice();
    }

    public int getPrice() {
        return price;
    }

    public void rollPrice() {
        this.price = ThreadLocalRandom.current().nextInt(getProduct().getMinPrice(), getProduct().getMaxPrice() + 1);;
    }
}
