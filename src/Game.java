private static final int GAME_ROUNDS = 30;

private final Player player = new Player();
private final List<Market> markets = new LinkedList<>();
private Market currentMarket;

void main() {
    // https://patorjk.com/software/taag/#p=display&f=Rectangles&t=SpaceTrader&x=none&v=4&h=4&w=80&we=false
    System.out.println(" _____                 _____           _         ");
    System.out.println("|   __|___ ___ ___ ___|_   _|___ ___ _| |___ ___ ");
    System.out.println("|__   | . | .'|  _| -_| | | |  _| .'| . | -_|  _|");
    System.out.println("|_____|  _|__,|___|___| |_| |_| |__,|___|___|_|  ");
    System.out.println("      |_|                                        ");

    // TODO: Populate markets

    for (int i = 0; i < GAME_ROUNDS; i++) {
        System.out.printf("Day: %d/%d - Balance: %d$ - Debt: %d$ - Inventory Space: %d/%d - City: %s%n", i + 1, GAME_ROUNDS, player.getBalance(), player.getDebt(), player.getItemCount(), Player.ITEM_CAPACITY, currentMarket);

        // TODO: Menu
        // Loan Shark: Pay off Debt (+10%/DAY)
        // Bank: Store Money with interest (+2%/DAY)
        // Private Jet: Change City
        // Market: Buy/Sell items
        // Roll Market prices and events
        currentMarket.rollRound();
    }
}