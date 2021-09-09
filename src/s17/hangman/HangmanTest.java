package s17.hangman;

import java.util.Scanner;

public class HangmanTest {
  private static void printStart(Hangman h) {
    System.out.println("Welcome to HANGMAN");
    System.out.printf(
        "Please, guess: %s. You have %d lives%n",
        h.status(),
        h.lives());
  }
  private static void playAndPrint(Hangman h, char c) {
    h.play(c);
    System.out.printf("Playing: %c, Status: %s, Lives: %d, Wrong Guesses: %s%n",
        c,
        h.status(),
        h.lives(),
        h.wrongGuesses());
  }
  public static void main(String[] args) {
    Hangman h = new Hangman("turing", 4);
    printStart(h);
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print("Your guess : ");
      String c = sc.next();
      if (c.length() != 1 || c.charAt(0) < 'a' || c.charAt(0) > 'z') {
        System.err.println("Please, enter a letter between 'a' and 'z'");
        continue;
      }
      playAndPrint(h, c.charAt(0));
      if (h.isWinning()) {
        System.out.printf("You won! and you still have %d lives%n", h.lives());
        return;
      }
      if (h.isHanged()) {
        System.out.printf("You lose. The secret was \"%s\"%n", h.secret());
        return;
      }
    }
  }
}
