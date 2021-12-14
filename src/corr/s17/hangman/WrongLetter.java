package corr.s17.hangman;

public class WrongLetter extends PlayedLetter {

    public WrongLetter(char c) {
        super(c);
    }

    @Override
    public final boolean isWrong() {
        return true;
    }

}
