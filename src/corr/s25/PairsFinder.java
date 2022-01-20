
package corr.s25;

import java.util.Arrays;

// Trouver et afficher toutes les paires d'entiers naturels (non nuls et 
// distincts) inférieurs à M, telles que la différence des carrés des deux 
// nombres soit égale au cube de leur différence (la paire [6, 3] est un exemple).

public class PairsFinder {
  private final int upperBound;
  private int crtI=1, crtJ=1;
  
  public PairsFinder(int m) {
    upperBound=m;
  }
  
  private boolean isSolution() {
    int i=crtI, j=crtJ;
    long sqDiff = i*i - j*j;
    long diff = (i-j);
    long diffCube = diff*diff*diff;
    return sqDiff==diffCube; 
  }
  
  private void nextStep() {
    crtJ++;
    if(crtJ<crtI) return;
    crtI++;
    crtJ=1;
  }
  
  // returns null eventually
  public int[] nextPair() {
    while(crtJ<upperBound) {
      nextStep();
      if(isSolution()) return new int[]{crtI, crtJ};
    }
    return null;
  }
  
  /* Here, the idea is to adapt the following code so that one step
   * of the following double-loop can be triggered via a method:
    for(int i=1; i<m; i++) {
      for(int j=1; j<i; j++) {
        int sqDiff = i*i - j*j;
        int diff = (i-j);
        int diffCube = diff*diff*diff;
        if(sqDiff==diffCube) {
          System.out.println(i+" "+j+" "+diffCube);
        }
      }
    }
   */
  
  //--------------------------------
  public static void main(String... args) {
    PairsFinder pf=new PairsFinder(50000);
    int count=0;
    int[] sol=pf.nextPair();
    while(sol!=null) {
      count++;
      System.out.println(Arrays.toString(sol));
      sol=pf.nextPair();
    }
    System.out.println(count+" solutions");
  }
}