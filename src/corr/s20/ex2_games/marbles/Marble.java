package corr.s20.ex2_games.marbles;

import corr.s20.ex2_games.Playable;

public class Marble implements Playable {
    final Color color;

    public Marble(Color color) {
        this.color = color;
    }

    @Override
    public int gameResult(Playable o) {
        return color.compareTo(((Marble) o).color);
    }

    @Override
    public String toString() {
        return color.toString() + " marble";
    }
}