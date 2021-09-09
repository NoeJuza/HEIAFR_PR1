package s20.ex2_games.cards;

import s20.ex2_games.Playable;

public class NumberCard extends Card {

    private final int rank;

    public NumberCard(Suit suit, int rank) {
        super(suit);
        this.rank = rank;
    }

    @Override
    public int gameResult(Playable c) {
        if (c instanceof NumberCard) {
            return Integer.compare(this.rank, ((NumberCard) c).rank);
        }
        return -1; // FaceCard beats NumberCard
    }

    @Override
    public String toString() {
        String rankName;
        switch (this.rank) {
            case 2:
                rankName = "two";
                break;
            case 3:
                rankName = "three";
                break;
            case 4:
                rankName = "four";
                break;
            case 5:
                rankName = "five";
                break;
            case 6:
                rankName = "six";
                break;
            case 7:
                rankName = "seven";
                break;
            case 8:
                rankName = "eight";
                break;
            case 9:
                rankName = "nine";
                break;
            case 10:
                rankName = "ten";
                break;
            default:
                rankName = "unknown";
                break;
        }
        return rankName + " of " + suit.toString();
    }
}
