//==============================================================================
//HEIA-FR / Jacques Bapst
//==============================================================================
package corr.s12;

public class Ex1206_Corr {

  public static void main(String[] args) {
    System.out.println(fA (10, 6));
    System.out.println(fAa(10, 6));
    System.out.println(fAb(10, 6));
    System.out.println(fA (10, 0));
    System.out.println(fAa(10, 0));
    System.out.println(fAb(10, 0));
  }
  
  //----------------------------------------------------------------------------
  // Computes the sum (n-k) + (n-(k-1)) + (n-(k-2)) + ... + (n-1)
  //                  =  kn - k(k+1)/2  =  k(n - (k+1)/2)
  //----------------------------------------------------------------------------
  public static int fA(int n, int k) {
    int sum = 0;
    for (int i=k ; i>0 ; i--)
      sum += (n-i);
    return sum;
  }
  
  public static int fAa(int n, int k) {
    int sum = 0;
    int i=k; 
    while(i>0) {
      sum += (n-i);
      i--;
    }
    return sum;
  }
  
  public static int fAb(int n, int k) {
    int sum = 0;
    int i=k;
    if(i>0) {
      do {
        sum += (n-i);
        i--;
      } while(i>0);
    }
    return sum;
  }
}
