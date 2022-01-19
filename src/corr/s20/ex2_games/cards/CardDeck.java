package corr.s20.ex2_games.cards;

import corr.s20.ex2_games.ItemList;

import java.security.SecureRandom;

public class CardDeck extends ItemList {

    private final static int NUMBER_OF_CARDS = 52;

    private static Card[] shuffledDeck() {
        Card[] items = new Card[NUMBER_OF_CARDS];
        // Build deck
        int i = 0;
        for (Suit s : Suit.values()) {
            for (Face f : Face.values()) {
                items[i++] = new FaceCard(s, f);
            }
            for (int r = 2; r <= 10; r++) {
                items[i++] = new NumberCard(s, r);
            }
        }
        if (i != NUMBER_OF_CARDS) {
            throw new RuntimeException("Error with cards");
        }

        // Shuffle deck
        SecureRandom r = new SecureRandom();
        for (i = items.length-1; i >= 0; i--) {
            int j = r.nextInt(i + 1);
            Card t = items[i];
            items[i] = items[j];
            items[j] = t;
        }
        return items;
    }

    public CardDeck() {
        super (shuffledDeck());
    }

}