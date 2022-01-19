package corr.s20.ex2_games.marbles;

public enum Color {
    GREEN,
    YELLOW,
    BLUE,
    RED;

    @Override
    public String toString() {
        switch (this) {
            case GREEN:
                return "green";
            case YELLOW:
                return "yellow";
            case BLUE:
                return "blue";
            case RED:
                return "red";
        }
        return "unknown";
    }
}