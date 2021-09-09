package s20.ex2_games;

public class GameEngine {

    final String[] players;
    final Provider provider; // item providers (i.e. cards, marbles, ...)

    public GameEngine(Provider provider, String player1, String player2) {
        this.players = new String[]{player1, player2};
        this.provider = provider;
    }

    public void play() {
        // This engine only works for 2 players
        assert players.length == 2;
        Playable[] draw = new Playable[players.length];

        while (true) {
            // each player draws an item
            for (int i = 0; i < draw.length; i++) {
                // if the provider has no more item, then the game ends with a tie.
                if (!provider.hasMore()) {
                    System.out.println("No more item. Tie game!");
                    return;
                }
                // player i gets an item
                draw[i] = provider.getNext();
                System.out.printf("%s plays %s%n", players[i], draw[i]);
            }
            if ((draw[0]).gameResult(draw[1]) > 0) {
                System.out.printf("%s wins with %s%n", players[0], draw[0]);
                break;
            } else if ((draw[0]).gameResult(draw[1]) < 0) {
                System.out.printf("%s wins with %s%n", players[1], draw[1]);
                break;
            } else {
                System.out.println("***** tie! *****");

            }
        }
    }
}
