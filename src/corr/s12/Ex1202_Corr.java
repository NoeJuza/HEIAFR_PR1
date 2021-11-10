//==============================================================================
//HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;

import java.util.Arrays;

public class Ex1202_Corr {

  public static void main(String[] args) {
    int[][] a={
        {1,2},
        {3,4},
        {5,6}
    };
    int[][] b={
        {1,6},
        {3,4},
        {5,6}
    };
    int[][] c={
        {1,2},
        {},
        {5}
    };
    int[][] d={
        {1,6},
        {},
        {5}
    };
    System.out.println(Arrays.deepToString(sumOfAnyGrid        (a, b)));
    System.out.println(Arrays.deepToString(sumOfRectangularGrid(a, b)));
    System.out.println(Arrays.deepToString(sumOfAnyGrid        (c, d)));
    System.out.println(Arrays.deepToString(sumOfRectangularGrid(c, d)));
    System.out.println(Arrays.deepToString(sumOfAnyGrid        (a, c)));
    System.out.println(Arrays.deepToString(sumOfRectangularGrid(a, c)));
  }
  
  public static boolean isRectangular(int[][] t) {
    if(t.length==0)
      return true;  // annoying case: is a 0x0 grid "rectangular"?
    int m=t[0].length;
    for(int i=0; i<t.length; i++) 
      if(t[i].length != m) return false;
    return true;
  }

  public static int[][] sumOfRectangularGrid(int[][] a, int[][] b) {
    int n=a.length, m=a[0].length;
    if(b.length!=n || b[0].length!=m) return null;
    if(!isRectangular(a) || !isRectangular(b)) return null;
    int[][] r=new int[n][m];
    for(int i=0; i<n; i++) {
      for(int j=0; j<m; j++) {
        r[i][j]=a[i][j]+b[i][j];
      }
    }
    return r;
  }
  
  public static int[][] sumOfAnyGrid(int[][] a, int[][] b) {
    int n=a.length;
    int[][] r=new int[n][];
    if(b.length!=n) return null;
    for(int i=0; i<n; i++) {
      int m=a[i].length;
      r[i]=new int[m];
      if(b[i].length != m) return null;
      for(int j=0; j<m; j++) {
        r[i][j]=a[i][j]+b[i][j];
      }
    }
    return r;
  }

}
