package s06;

public class Pg0602b {
  public static int p(int i) { //
    int j = 2*i;               //
    i = 10;                    // (*) 2
    return j;
  }
  public static void main(String[] args) {
    int i=3, c=0;              // (*) 1
    c = 2 * p(i);              // (*) 3
    i = c - p(c+1);            // (*) 4
  }
}                              // (b)