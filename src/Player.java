import java.util.ArrayList;
import java.util.List;

public class Player {
    private int balance;
    private final List<InventoryItem> inventory;

    public Player() {
        this.balance = 0;
        this.inventory = new ArrayList<>();

        for (ProductType currentType : ProductType.values()) {
            inventory.add(new InventoryItem(currentType));
        }
    }

    public int getBalance() {
        return balance;
    }

    public void addMoney(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount may not be negative");
        }

        balance += amount;
    }

    public boolean removeMoney(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public void addItem(ProductType type, int amount) {
        for (InventoryItem item : inventory) {
            if (item.getProduct() == type) {
                item.add(amount);
            }
        }
    }
}
