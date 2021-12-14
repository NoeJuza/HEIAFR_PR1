package corr.s17.hangman;

public class SecretLetter extends Letter {

    public SecretLetter(char c) {
        super(c);
    }

    public char letter() {
        return '_';
    }

    @Override
    public final boolean isSecret() {
        return true;
    }

}
