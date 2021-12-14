package corr.s17.hangman;

public class PlayedLetter extends Letter {

    public PlayedLetter(char c) {
        super(c);
    }

    @Override
    public final boolean isPlayed() {
        return true;
    }

}
