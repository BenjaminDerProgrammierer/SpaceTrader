public abstract class Market {
    public void rollRound() {
        rollEvents();
        rollPrices();
    }
    protected abstract void rollPrices();
    protected abstract void rollEvents();
}
