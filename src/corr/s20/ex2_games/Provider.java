package corr.s20.ex2_games;

public interface Provider {
    boolean hasMore();  // returns true if the provider has more items

    Playable getNext(); // returns the next Playable item
}