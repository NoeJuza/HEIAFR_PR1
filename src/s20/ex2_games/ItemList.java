package s20.ex2_games;

public class ItemList implements Provider {

    private int position = 0;
    private final Playable[] items;

    public ItemList(Playable[] items) {
        this.items = items;
    }

    @Override
    public boolean hasMore() {
        // TODO
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Playable getNext() {
        // TODO
        throw new RuntimeException("Not yet implemented");
    }
}