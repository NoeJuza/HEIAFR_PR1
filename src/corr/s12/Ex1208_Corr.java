//==============================================================================
//HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;

public class Ex1208_Corr {

  public static void main(String[] args) {
    dispChange(6, 5, 2, 1);
  }
  
  //----------------------------------------------------------------------------
  // Displays every possible way to change N francs
  // with coins of ka, kb and kc francs
  //----------------------------------------------------------------------------
  public static int dispChange(int N, int ka, int kb, int kc) {
    int nka, nkb, nkc;
    int nkaMax=N/ka, nkbMax=N/kb, nkcMax=N/kc;
    int nb = 0;                               // number of solutions
    for (nka = 0; nka <= nkaMax; nka++)
      for (nkb = 0; nkb <= nkbMax; nkb++)
        for (nkc = 0; nkc <= nkcMax; nkc++)
          if (kc * nkc + kb * nkb + ka * nka == N) {    // amount is Ok
            nb++;
            System.out.print(N + " Fr = ");
            if (nkc != 0)
              System.out.print(nkc + " x " + kc + " Fr");
            if (nkb != 0) {
              if (nkc != 0)
                System.out.print("  +  ");
              System.out.print(nkb + " x " + kb + " Fr");
            }
            if (nka != 0) {
              if ((nkc != 0) || (nkb != 0))
                System.out.print("  +  ");
              System.out.print(nka + " x " + ka + " Fr");
            }
            System.out.println();
          }
    System.out.println();
    System.out.println("There are " + nb + " ways to change " + N + " Fr");
    return nb;
  }
}
