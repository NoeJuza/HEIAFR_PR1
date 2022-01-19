package corr.s20.ex2_games.cards;

import corr.s20.ex2_games.Playable;

public class FaceCard extends Card {

    private final Face face;

    public FaceCard(Suit suit, Face face) {
        super(suit);
        this.face = face;
    }

    @Override
    public int gameResult(Playable c) {
        if (c instanceof FaceCard) {
            return this.face.compareTo(((FaceCard) c).face);
        }
        return 1; // FaceCard beats NumberCard
    }

    @Override
    public String toString() {
        return face.toString() + " of " + suit.toString();
    }
}