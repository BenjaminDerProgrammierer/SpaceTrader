public abstract class Market {
    private Inventory<MarketItem> inventory = new Inventory<>(MarketItem.class);

    public void rollRound() {
        rollEvents();
        rollPrices();
    }
    protected abstract void rollPrices();
    protected abstract void rollEvents();
}
