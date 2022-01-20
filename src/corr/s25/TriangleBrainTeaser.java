
package corr.s25;

import java.util.Arrays;

public class TriangleBrainTeaser {
  private long nineDigitNumber = 100_000_000;
    
  // gives all solutions cyclicly
  public int[] nextSolution() {
    nextCandidate();
    while(!isSolution()) nextCandidate();
    return asDigitArray();
  }
  
  private boolean isSolution() {
    int[] t = asDigitArray();
    int a=sumOfSide(t, 0), b=sumOfSide(t, 1), c=sumOfSide(t, 2);
    if(a != b || a != c) return false;
    return hasAllDigits(t);
  }

  private static int sumOfSide(int[] t, int i) {
    int sum = 0;
    for(int j=0; j<4; j++)
      sum += t[(3*i + j) % 9];
    return sum;
  }

  private boolean hasAllDigits(int[] t) {
    for(int i=1; i<=9; i++)
      if(!hasDigit(t, i)) return false;
    return true;
  }

  private boolean hasDigit(int[] t, int i) {
    for(int d:t) 
      if(d == i) return true;
    return false;
  }

  // Splits nineDigitNumber into an array of digits
  // Example: nineDigitNumber == 135246789
  //     ---> returns {9,8,7,6,4,2,5,3,1}
  private int[] asDigitArray() {
    long n = nineDigitNumber;
    int[] t = new int[9];
    for(int i=0; i<9; i++) {
      t[i] = (int)(n % 10);
      n /= 10;
    }
    return t;
  }
  
  private void nextCandidate() {
    nineDigitNumber = (nineDigitNumber+1) % 1_000_000_000;
    //if(nineDigitNumber%100_000_000 == 0) System.out.println(nineDigitNumber);
  }
  
  //----------------------------------
  // small demo
  public static void main(String... args) {
    TriangleBrainTeaser t = new TriangleBrainTeaser();
    int[] firstSol = t.nextSolution(), sol = firstSol;
    System.out.println(Arrays.toString(sol));
    sol = t.nextSolution();
    while(!Arrays.equals(sol, firstSol)) {
      System.out.println(Arrays.toString(sol));
      sol = t.nextSolution();
    }
  }
}