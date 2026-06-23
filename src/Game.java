private static final int GAME_ROUNDS = 30;

private final Player player = new Player();
private final List<Market> markets = new LinkedList<>();
private Market currentMarket;

void main() {
    Scanner scanner = new Scanner(System.in);
    // https://patorjk.com/software/taag/#p=display&f=Rectangles&t=SpaceTrader&x=none&v=4&h=4&w=80&we=false
    System.out.println(" _____         _ _   ____          _         ");
    System.out.println("|   __|___ _ _|_| |_|    \\ ___ ___| |___ ___ ");
    System.out.println("|   __|  _| | | |  _|  |  | -_| .'| | -_|  _|");
    System.out.println("|__|  |_| |___|_|_| |____/|___|__,|_|___|_|  ");

    markets.add(new HtlLeondingMarket());
    markets.add(new EbelsbergMarket());
    markets.add(new EferdingMarket());
    markets.add(new LinzMainStationMarket());
    markets.add(new PichlingMarket());
    currentMarket = markets.getFirst();

    for (int i = 0; i < GAME_ROUNDS; i++) {
        currentMarket.rollRound();

        System.out.printf("Day: %d/%d - Balance: %d$ - Debt: %d$ - Inventory Space: %d/%d - Current Market: %s%n", i + 1, GAME_ROUNDS, player.getBalance(), player.getDebt(), player.getItemCount(), Player.ITEM_CAPACITY, currentMarket);
        System.out.println();
        System.out.println("L - LOAN SHARK: Pay off your debt");
        System.out.println("B - BANK: Store money permanently, but get interest");
        System.out.println("J - PRIVATE JET: Change city");
        System.out.println("M - MARKET: Buy/Sell Product");
        System.out.print("Your Choice: ");
        char choice = scanner.next().toUpperCase().charAt(0);

        switch (choice) {
            case 'L':
                System.out.println("LOAN SHARK");
                break;
            case 'B':
                System.out.println("BANK");
                break;
            case 'J':
                System.out.println("MARKET");
                break;
            case 'M':
                System.out.println("PRIVATE JET");
                break;
            default:
                System.out.println("Invalid choice");
                i--;
                break;
        }
    }
}