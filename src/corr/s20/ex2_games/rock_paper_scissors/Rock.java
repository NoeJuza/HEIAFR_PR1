// DO NOT PUT IN ASSIGNMENT!

package corr.s20.ex2_games.rock_paper_scissors;

import corr.s20.ex2_games.Playable;

public class Rock implements Playable {

    @Override
    public int gameResult(Playable o) {
        if (o instanceof Scissor) {
            return 1;
        }
        if (o instanceof Paper) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}
