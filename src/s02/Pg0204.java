//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package s02;

public class Pg0204 {
  public static void main(String [] args) {
    int a,c;          // (*) 1
    int b = 4;
    c = 8;            // (*) 2
    a = b++ + --c;
    if (a != b) {
      int d = 3;      // (*) 3
      a = 2*d;        // (*) 4
    }
    a += b;           // (*) 5
  }
}
