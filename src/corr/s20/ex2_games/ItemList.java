package corr.s20.ex2_games;

public class ItemList implements Provider {

    private int position = 0;
    private final Playable[] items;

    public ItemList(Playable[] items) {
        this.items = items;
    }

    @Override
    public boolean hasMore() {
        // ----- BEGIN SOLUTION -----
        return position < items.length;
        // ----- END SOLUTION -----
        // TODO
    }

    @Override
    public Playable getNext() {
        // ----- BEGIN SOLUTION -----
        return items[position++];
        // ----- END SOLUTION -----
        // TODO
    }
}