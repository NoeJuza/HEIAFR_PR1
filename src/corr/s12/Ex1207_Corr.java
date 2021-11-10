//==============================================================================
//HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;
public class Ex1207_Corr {

  public static void main(String[] args) {
    int[][] res;
    res = testSyracuse(1000000);
    dispSyracuse(res);
  }
  
  //----------------------------------------------------------------------------
  //  Syracuse conjecture
  //----------------------------------------------------------------------------
  public static void dispSyracuse(int[][] res) {
    for (int i=1; i<res.length; i++) {
      System.out.println("Nb : " + i + "   Nb étapes : " + res[i][0]
                       + "   Val max : " + res[i][1]
                       + "   Etapes>n : " + res[i][2]);
    }
  }
  
  public static int[][] testSyracuse(int vMax) {
    int[][] tab = new int[vMax][3];
    int[]   r   = new int[3];
    for (int i=1; i<vMax; i++) {
      r = syracuse(i);
      tab[i][0] = r[0];
      tab[i][1] = r[1];
      tab[i][2] = r[2];
    }
    return tab;
  }
  
  public static int[] syracuse(int n) {
    int ct       = 0;
    int vmax     = n;
    int ninit    = n;
    int nbaltmax = 0;
    int nbalt    = 0;
    while (n != 1) {
      if (n%2 != 0) {
        n = 3*n + 1;
      } else {
        n = n/2;
      }
      ct++;
      if (n>ninit) nbalt++;
      else         nbalt=0;
      if (nbalt>nbaltmax) nbaltmax=nbalt;
      if (n>vmax) vmax=n;
    }
    return new int[] {ct, vmax, nbaltmax};
  }
}
