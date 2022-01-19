package corr.s20.ex2_games;

public class GameEngineX {

    final String[] players;
    final Provider provider; // item providers (i.e. cards, marbles, ...)

    public GameEngineX(Provider provider, String... names) {
        this.players = names;
        this.provider = provider;
    }

    public void play() {
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

            Playable bestMove = draw[0];
            String winner = players[0];
            for (int i = 1; i < draw.length; i++) {
                if ((draw[i]).gameResult(bestMove) > 0) {
                    bestMove = draw[i];
                    winner = players[i];
                } else if ((draw[i]).gameResult(bestMove) == 0) {
                    // more than one player with the winning move
                    winner = null;
                }
            }

            if (winner == null) { // more than one player with the winning move, so tie
                System.out.println("***** tie! *****");
            } else { // `winner` is the only winner.
                System.out.printf("%s wins with %s%n", winner, bestMove);
                break;
            }
        }
    }
}
