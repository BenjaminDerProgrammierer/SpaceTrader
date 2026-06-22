private final Player player = new Player();
private final List<Market> markets = new LinkedList<>();

void main() {
    // https://patorjk.com/software/taag/#p=display&f=Rectangles&t=SpaceTrader&x=none&v=4&h=4&w=80&we=false
    System.out.println(" _____                 _____           _         ");
    System.out.println("|   __|___ ___ ___ ___|_   _|___ ___ _| |___ ___ ");
    System.out.println("|__   | . | .'|  _| -_| | | |  _| .'| . | -_|  _|");
    System.out.println("|_____|  _|__,|___|___| |_| |_| |__,|___|___|_|  ");
    System.out.println("      |_|                                        ");

    for (Market market : markets) {
        market.rollRound();
    }
    // TODO: Markets
    // TODO: Game loop
}