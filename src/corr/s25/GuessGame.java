package corr.s25;

import proglib.SimpleIO;

import java.util.Random;

public class GuessGame {
  public static final int TOO_SMALL = -1;
  public static final int TOO_BIG   = -2;
  
  private int nbOfTries=0;
  private final int secretTarget;
  private static final Random RANDOM = new Random();
  
  public GuessGame() {
    secretTarget=RANDOM.nextInt(1001); // so in [0..1000]
  }
  // returns TOO_SMALL / TOO_BIG, or
  // the number of tries, including 
  // that successful one
  public int tryToGuess(int guess){
    nbOfTries++;
    if(guess==secretTarget) 
      return nbOfTries;
    if(guess <secretTarget) 
      return TOO_SMALL;
    return TOO_BIG;
  }
  
  //--------------------------------------
  // small interactive game...
  public static void main(String[] args) {
    GuessGame g=new GuessGame();
    String prefix="";
    final String invitation="Propose a number: ";
    
    while(true) {
      int guess=SimpleIO.readInt(prefix+invitation);
      int r=g.tryToGuess(guess);
      if(r>=0) break;
      if(r==TOO_SMALL) prefix=guess+"is too small, sorry... ";
      if(r==TOO_BIG  ) prefix=guess+"is too big, sorry... ";
    }
    SimpleIO.display("That's it, congratulations!");
  }
}