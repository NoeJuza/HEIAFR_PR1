
package s06;

public class Pg0602a {
  public static void main(String[] args) {
    int a=3, b=0;               // (*) 1
    b = f(a++);                 // (*) 4
    a++;                        // (*) 5
  }
  public static int f(int i) {
    int a = 4*i;                // (*) 2
    i=a++;                      // (*) 3
    return a;
  }
}                               // (a)
