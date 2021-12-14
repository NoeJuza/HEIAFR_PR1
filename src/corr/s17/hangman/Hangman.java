package corr.s17.hangman;

public class Hangman {

    private final String secret;
    private int lives;
    private final Letter[] letters = new Letter['z' - 'a' + 1];

    // Constructor given the secret word and the number of lives
    public Hangman(String secret, int lives) {
        this.secret = secret;
        for (char c = 'a'; c <= 'z'; c++) {
            this.letters[indexOf(c)] = new Letter(c);
        }
        for (char c : secret.toCharArray()) {
            this.letters[indexOf(c)] = new SecretLetter(c);
        }
        this.lives = lives;
    }

    public static int indexOf(char letter) {
        return letter - 'a';
    }

    public String secret() {
        return this.secret;
    }

    public int lives() {
        return this.lives;
    }

    // isHanged returns true if the player is hanged (i.e. he has lost)
    public boolean isHanged() {
        return this.lives <= 0;
    }

    // isWinning returns true if the player found the hidden word
    public boolean isWinning() {
        for (char c : this.secret.toCharArray()) {
            if (!(this.letters[indexOf(c)].isPlayed())) {
                return false;
            }
        }
        return true;
    }

    public String status() {
        String result = "";
        for (char c : this.secret.toCharArray()) {
            result = result + this.letters[indexOf(c)].letter();
        }
        return result;
    }

    public String wrongGuesses() {
        String result = "";
        for (Letter l : this.letters) {
            if (l.isWrong()) {
                result = result + l.letter();
            }
        }
        return result;
    }

    public void play(char letter) {
        if ((this.letters[indexOf(letter)].isSecret())) {
            this.letters[indexOf(letter)] = new PlayedLetter(letter);
        } else if (!(this.letters[indexOf(letter)].isPlayed())) {
            if (this.lives > 0) {
                this.lives = this.lives - 1;
            }
            this.letters[indexOf(letter)] = new WrongLetter(letter);
        }
    }

}
