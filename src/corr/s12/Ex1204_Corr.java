//==============================================================================
//HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;

public class Ex1204_Corr {

  public static void main(String[] args) {
  }
  
  public static boolean[] kthRow(boolean[][] t, int k) {
    boolean[] r=new boolean[t[k].length];
    for(int i=0; i<r.length; i++) {
      r[i]=t[k][i];
    }
    return r;
    // The one-line variant:           return t[k];
    // is also possible, but be aware that it has 
    // a different effect (and is not consistent
    // with kthColumn() method)... For instance in the 
    // following calling context:
    //   System.out.println(t[0][0]);
    //   boolean[] a=kthRow(t, 0);
    //   a[0]=!a[0];
    //   System.out.println(t[0][0]);
  }
  
  public static boolean isRectangular(boolean[][] t) {
    if(t.length==0)
      return true;  // annoying case: is a 0x0 grid "rectangular"?
    int m=t[0].length;
    for(int i=0; i<t.length; i++) 
      if(t[i].length != m) return false;
    return true;
  }
  
  public static boolean[] kthColumn(boolean[][] t, int k) {
    if(!isRectangular(t)) return null;
    boolean[] r=new boolean[t.length];
    for(int i=0; i<r.length; i++) {
      r[i]=t[i][k];
    }
    return r;
  }

}
