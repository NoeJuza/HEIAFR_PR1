//==============================================================================
//  EIA-FR / Jacques Bapst
//==============================================================================
package s05;

public class Pg0501 {
  public static void ex1a() {
    int n = 5; int sum = 0;           // (a)
    while (n>0) {
      sum += n;
      n--;
    }
    System.out.println(sum);
  }

  public static void ex1b() {
    int n = 5; int sum = 0;           // (b)
    {
      while (n>0)
        n--;
        sum += n;
    }
    for (int i=1; i<10; i=2*i) sum+=i;
    System.out.println(sum);
  }
  
  public static void ex1c() {
    int n = 5; int sum = 0;           // (c)
    while (n>0) {
      sum += --n;
    }
    System.out.println(sum);
  }
  
  public static void ex1d() {
    int n = 5; int sum = 0;           // (d)
    while (n>0); {
      sum += n;
      n--;  
    }
    System.out.println(sum);
  }

  public static void ex1e() {
    int n = 5; int m = 0; int sum = 0;    // (e)
    while (--n > 0) {
      m=0;
      if (n==3) continue;
      while (m++ < n) sum += n;
    }
    while (m++ < 5) sum += 1;
    System.out.println(sum);
  }

  public static void ex1f() {
    int sum = 0;                          // (f)
    for (double y=0.1; y!=1.0; y+=0.1)
      sum++;
    System.out.println(sum);
  }

  public static void main(String[] args) {
    ex1a();
    ex1b();
    ex1c();
    ex1d();
    ex1e();
    ex1f();
  }
}
