package corr.s20.ex2_games;

import corr.s20.ex2_games.rock_paper_scissors.RPSProvider;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        // ----- BEGIN SOLUTION -----
        RPSProvider rpsProvider = new RPSProvider();
        GameEngine game = new GameEngine(rpsProvider, "Bob", "Alice");
        for (int i = 0; i < 10; i++) {
            game.play();
            System.out.println("-------------------------");
        }
        // ----- END SOLUTION -----
    }
}