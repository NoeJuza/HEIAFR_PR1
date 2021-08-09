package s01;

import proglib.SimpleIO;

// ---------- Prog3 ---------------------
public class Prog3 {
  public static void main(String[] args) {
    int n1, n2, gcd, k;

    n1  = SimpleIO.readInt("Integer n1 :");
    n2  = SimpleIO.readInt("Integer n2 :");
    gcd = 1;
    k   = 1;

    while (k<=n1 && k<=n2) {
      if (n1%k==0 && n2%k==0) gcd=k;
      k++;
    }

    SimpleIO.display("Greatest common divisor of"
            + n1 + " and " + n2 + " is ", gcd);
  }
}
