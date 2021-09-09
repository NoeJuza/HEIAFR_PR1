//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package s12;

public class Ex1201a {

  //----------------------------------------------------------------------------
  // TODO: describe the effect...
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
