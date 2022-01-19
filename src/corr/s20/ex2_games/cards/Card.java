package corr.s20.ex2_games.cards;

import corr.s20.ex2_games.Playable;

public abstract class Card implements Playable {
    final Suit suit;

    Card(Suit suit) {
        this.suit = suit;
    }
}