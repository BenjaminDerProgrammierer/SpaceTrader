import java.util.Objects;

public class ProductType {
    String name;
    int minPrice;
    int maxPrice;

    public String getName() {
        return name;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    ProductType(String name, int minPrice, int maxPrice) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank.");
        }
        if (minPrice > maxPrice || minPrice <= 0) {
            throw new IllegalArgumentException("Prices must be positive and maxPrice must be greater than minPrice.");
        }

        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductType that)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
