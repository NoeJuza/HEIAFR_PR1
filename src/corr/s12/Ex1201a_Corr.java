//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;

public class Ex1201a_Corr {

  public static void main(String[] args) {
    disp(4);
  }
  //----------------------------------------------------------------------------
  // Displays a triangle of stars, of height nL, int the form:       |   *
  //                                                                 |  ***
  //                                              Example with nL=4  | *****
  //                                                                 |*******
  //----------------------------------------------------------------------------
   public static void disp(int nL) {
    char c = '*';
    int nbl, nbe, j;

    for (nbl=0 ; nbl<nL ; nbl++) {
      nbe = nL - nbl - 1;
      for (j=0; j<nbe; j++)
        System.out.print(' ') ;
      for (j=0; j<2*nbl+1; j++)
        System.out.print(c) ;
      System.out.println() ;
    }
  }
}
