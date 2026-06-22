import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Inventory<T> extends ArrayList<T> {
    private static final Path PRODUCTS_CSV = Path.of("data", "products.csv");
    private final Class<T> itemType;

    public Inventory(Class<T> itemType) {
        super();
        this.itemType = itemType;

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

                ProductType product = new ProductType(name, minPrice, maxPrice);
                this.add(createItem(product));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read products CSV: " + PRODUCTS_CSV, e);
        }
    }

    private T createItem(ProductType product) {
        if (itemType == InventoryItem.class) {
            return itemType.cast(new InventoryItem(product));
        }

        if (itemType == MarketItem.class) {
            return itemType.cast(new MarketItem(product));
        }

        throw new IllegalArgumentException("Unsupported inventory item type: " + itemType.getName());
    }
}
