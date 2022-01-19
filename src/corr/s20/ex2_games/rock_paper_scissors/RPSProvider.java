package corr.s20.ex2_games.rock_paper_scissors;

import corr.s20.ex2_games.Playable;
import corr.s20.ex2_games.Provider;

import java.security.SecureRandom;

public class RPSProvider implements Provider {

    private final SecureRandom rand = new SecureRandom();

    @Override
    public boolean hasMore() {
        return true;
    }

    @Override
    public Playable getNext() {
        switch (rand.nextInt(3)) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            case 2:
                return new Scissor();
            default:
                throw new RuntimeException("Impossible");
        }
    }
}