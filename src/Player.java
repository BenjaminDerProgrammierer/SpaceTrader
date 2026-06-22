import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Player {
    private static final int STARTING_MONEY = 200;
    private static final Path PRODUCTS_CSV = Path.of("data", "products.csv");

    private int balance;
    private final List<InventoryItem> inventory;

    public Player() {
        this.balance = STARTING_MONEY;

        this.inventory = new ArrayList<>();
        loadProductsFromCsv();
    }

    private void loadProductsFromCsv() {
        try (var reader = Files.newBufferedReader(PRODUCTS_CSV)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] columns = line.split(",");
                if (columns.length != 3) {
                    throw new IllegalStateException("Invalid product row: " + line);
                }

                String name = columns[0].trim();
                int minPrice = Integer.parseInt(columns[1].trim());
                int maxPrice = Integer.parseInt(columns[2].trim());

                inventory.add(new InventoryItem(name, minPrice, maxPrice));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read products CSV: " + PRODUCTS_CSV, e);
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
            if (item.getProduct().equals(type)) {
                item.add(amount);
                return;
            }
        }
    }
}
