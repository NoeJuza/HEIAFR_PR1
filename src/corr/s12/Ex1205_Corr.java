//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;

public class Ex1205_Corr {

  public static void main(String[] args) {
    System.out.println(rk(26, 3));
    System.out.println(rk(27, 3));
    System.out.println(rk(1, 1));
    System.out.println(rk(123, 2));
  }

  //----------------------------------------------------------------------------
  // Computes the k-th integer root of n: rk(26, 3) -> 2
  //                                      rk(27, 3) -> 3
  //----------------------------------------------------------------------------
  public static int rk(int n, int k) {
    int i, p=0;
    for (i=1 ; p<=n ; i++) {
      p=i;
      for (int j=1; j<k ; j++) {
        p = p * i;
      }
    }
    return i-2;
  }
}
