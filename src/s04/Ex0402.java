//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package s04;

public class Ex0402 {

  public static void main(String[] args) {
    int i=3, j=5, r=1; boolean b;
    r += i;                              // r:
    r *= j + 2;                          // r:
    b = (false!=false) | !(true==true);  // b:
    b = !b || (i++ >= --j);              // b:
    b ^= b;                              // b:
    r = i++ - j--;                       // r:
    System.out.println(r);
  }
}
