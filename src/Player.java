import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Player {
    private static final int STARTING_MONEY = 200;
    private static final int STARTING_DEBT = 5500;
    public static final int ITEM_CAPACITY = 5500;

    private int balance = STARTING_MONEY;
    private int debt = STARTING_DEBT;
    private final Inventory<InventoryItem> inventory = new Inventory<>(InventoryItem.class);

    public int getBalance() {
        return balance;
    }

    public int getDebt() {
        return debt;
    }

    public int getItemCount() {
        int count = 0;

        for (InventoryItem item : inventory) {
            count += item.getCount();
        }

        return count;
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
            if (item.getProduct().equals(type)) {
                item.add(amount);
                return;
            }
        }
    }
}
