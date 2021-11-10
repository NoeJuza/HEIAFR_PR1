//==============================================================================
//HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;

public class Ex1209_Corr {

  public static void main(String[] args) {
    int[] tab = {2, 1, 3, 2, 1, 3, 2, 1, 3, 5};
    int[] res = myst(tab, 2);
    for (int i=0; i<res.length; i++) {
      System.out.println(res[i]);
    }
  }

  //----------------------------------------------------------------------------
  // Returns an array (same length as v) holding the elements which appear at
  // least n times in the array v.
  // The returned array is sorted by frequency: the most frequent elements
  // first, the least frequent last.
  // The remaining cells are filled with the value -1.
  //
  // The methods works correctly only if the elements of v are all >= 0
  //
  // Examples: ({3,1,2,4,2,1,3,1,5,3}, 1) --> {1,3,2,4,5,-1,-1,-1,-1,-1}
  //           ({3,1,2,4,2,1,3,1,5,3}, 2) --> {1,3,2,-1,-1,-1,-1,-1-1,-1}
  //           ({2,1,3,2,1,3,2,1,3,5}, 2) --> {1,2,3,-1,-1,-1,-1,-1-1,-1}
  //----------------------------------------------------------------------------
  public static int[] myst(int[] v, int n) {
    int[] r = new int[v.length];
    int m=v[0];
    for (int i=0; i<v.length; i++) {
      if (v[i]>m) m= v[i];
      r[i] = -1;
    }
    int[] t = new int[m+1];
    m=t[0];
    for (int i=0; i<v.length; i++) {
      t[v[i]]++;
      if (t[v[i]]>m) m=t[v[i]];
    }
    int p=0;
    for (int i=m; i>=n; i--) {
     for (int j=0; j<t.length; j++) {
       if (t[j] == i) {
         r[p] = j;
         p++;
       }
     }
   }
   return r;
  }
}