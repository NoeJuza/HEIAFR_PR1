
package corr.s25;

public class ArtificialIntelligence {
  private static final int LOWER_BOUND=0, UPPER_BOUND=1000;
  // prints to the console the sequence of guesses
  // (the last one is the correct one)
  public static void solve(GuessGame g) {
    int min=LOWER_BOUND, max=UPPER_BOUND;
    // If needed, we could store the decisions in a collection :
    //   ArrayList<Integer> guesses=new ArrayList<>(); 
    // instead of an ArrayList, we could use an array of sufficient
    // size to hold the worst case (do you see how to compute it?),
    // and a counter....
    while(true) {
      int guess=(min+max)/2;
      System.out.println("Trying with number "+guess);
      int r=g.tryToGuess(guess);
      if(r>=0) break;
      if(r==GuessGame.TOO_SMALL) min=guess+1;
      if(r==GuessGame.TOO_BIG  ) max=guess-1;
    }
  }
  
  //--------------------------------------
  // small demo
  public static void main(String[] args) {
    GuessGame g=new GuessGame();
    solve(g);
  }
}