package corr.s20.ex2_games.marbles;

import corr.s20.ex2_games.ItemList;

import java.security.SecureRandom;

public class MarblesBag extends ItemList {

    // ----- BEGIN SOLUTION -----
    private static Marble[] randomBag(int size) {
        Marble[] items = new Marble[size];
        SecureRandom r = new SecureRandom();
        for (int i = 0; i < size; i++) {
            switch (r.nextInt(4)) {
                case 0:
                    items[i] = new Marble(Color.GREEN);
                    break;
                case 1:
                    items[i] = new Marble(Color.YELLOW);
                    break;
                case 2:
                    items[i] = new Marble(Color.BLUE);
                    break;
                case 3:
                    items[i] = new Marble(Color.RED);
                    break;
                default:
                    throw new RuntimeException("Impossible");
            }
        }
        return items;
    }
    // ----- END SOLUTION -----

    public MarblesBag(int size) {
        // create a marble bags with `size` marbles
        // and shake (randomize) the marbles.
        // You can use `java.security.SecureRandom`
        // ----- BEGIN SOLUTION -----
        super (randomBag(size));
        // ----- END SOLUTION -----
        // TODO
    }
}