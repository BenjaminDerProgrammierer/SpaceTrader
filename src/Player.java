import java.util.ArrayList;
import java.util.List;

public class Player {
    private int balance;
    private final List<InventoryItem> inventory;

    public Player() {
        this.balance = 0;

        this.inventory = new ArrayList<>();
        // read data/products.csv
        
        inventory.add(new InventoryItem("Meth", 0, 10));
        inventory.add(new InventoryItem("Grünzeug", 0, 10));
        inventory.add(new InventoryItem("Meth", 0, 10));
        inventory.add(new InventoryItem("Meth", 0, 10));
        inventory.add(new InventoryItem("Meth", 0, 10));
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
