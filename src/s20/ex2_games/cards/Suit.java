package s20.ex2_games.cards;

public enum Suit {
    HEART,
    SPADE,
    DIAMOND,
    CLUB;

    @Override
    public String toString() {
        switch (this) {
            case HEART:
                return "heart";
            case SPADE:
                return "spade";
            case DIAMOND:
                return "diamond";
            case CLUB:
                return "club";
        }
        return "unknown";
    }
}