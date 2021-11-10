//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;

public class Ex1201b_Corr {

  public static void main(String[] args) {
    System.out.println(np2(0));
    System.out.println(np2(1));
    System.out.println(np2(2));
    System.out.println(np2(3));
    System.out.println(np2(12));
    System.out.println(np2(15));
    System.out.println(np2(16));
  }
  
  //----------------------------------------------------------------------------
  // Computes the next higher power of two greater than k   np2(12) -> 16
  //                                                        np2(16) -> 32
  //----------------------------------------------------------------------------
  public static int np2(int k) {
    int i, s, n=0;

    while (k>1) {
      k /= 2;
      n++;
    }
    s=1;
    for (i=0 ; i<=n ; i++) {
      s *= 2;
    }
    return s;
  }
}
