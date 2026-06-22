import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Player {
    private static final int STARTING_MONEY = 200;

    private int balance = STARTING_MONEY;
    private final Inventory inventory = new Inventory();

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
            if (item.getProduct().equals(type)) {
                item.add(amount);
                return;
            }
        }
    }
}
