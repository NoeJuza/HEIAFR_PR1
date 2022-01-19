package corr.s20.ex2_games;

import corr.s20.ex2_games.marbles.MarblesBag;

public class MarblesGame {

    public static void main(String[] args) {
        // ----- BEGIN ASSIGNMENT -----
        // // TODO:
        // ----- END ASSIGNMENT -----
        // ----- BEGIN SOLUTION -----
        MarblesBag bag = new MarblesBag(100);
        GameEngine game = new GameEngine(bag, "Bob", "Alice");
        for (int i = 0; i < 10; i++) {
            game.play();
            System.out.println("-------------------------");
        }
        // ----- END SOLUTION -----
    }
}