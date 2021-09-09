package s20.ex2_games.rock_paper_scissors;

import s20.ex2_games.Playable;
import s20.ex2_games.Provider;

import java.security.SecureRandom;

public class RPSProvider implements Provider {

    private final SecureRandom rand = new SecureRandom();

    @Override
    public boolean hasMore() {
        // TODO
        throw new RuntimeException("not yet implemented");
    }

    @Override
    public Playable getNext() {
        // TODO
        // You can use `rand.nextInt(3)` that returns a random int between 0 and 2
        throw new RuntimeException("not yet implemented");
    }
}