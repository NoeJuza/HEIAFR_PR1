//==============================================================================
// EIA-FR / Jacques Bapst
//==============================================================================
package s07;

public class Ex07 {

  public static void ex1() {
    int i = 0;
    while (i < 5) {
      for  (int j=i; j>1; j--)
        System.out.print(j + " ");
      System.out.println("***");
      i++;
    }
  }

  public static void ex3(int n) {
    int counter = 2;
    do {
      System.out.println(counter);
      counter+=2;
    } while (counter<n);
  }
  
  public static int twice(int k) {
    return 2 * k;
  }
  
  public static void ex5() {
    int a = 3;
    int b = 10;
    while ( (a < 10) && (b!=6) ) {
       System.out.println("(*)1  a:"+a+" b: "+b);         // (*) 1
      if (a>5 || a==4)
        b = b - 2;
      a = a + 1;
    }
    System.out.println("(*)2  a:"+a+" b: "+b);            // (*) 2
  }

  public static void ex6() {
    int r, n=3;
    n=3; r = twice(n);
    System.out.println("r=" + r + "  n=" + n);
    n=3; r = twice(n)+1;
    System.out.println("r=" + r + "  n=" + n);
    n=3; r = twice(n+1);
    System.out.println("r=" + r + "  n=" + n);
    n=3; r = twice(n++);
    System.out.println("r=" + r + "  n=" + n);
    n=3; r = twice(++n);
    System.out.println("r=" + r + "  n=" + n);
    n=3; r = twice(twice(n));
    System.out.println("r=" + r + "  n=" + n);
    n=3; r = twice(twice(3+twice(n++))); 
    System.out.println("r=" + r + "  n=" + n);
  }
  
  public static void ex8() {
    int u = a(12);
    System.out.println("result " + u);
    u = a(b(a(3)));
    System.out.println("result " + u);
  }

  public static int a(int i) {
    System.out.println("a gets " + i);
    return i + b(i * 2);
  }

  public static int b(int j) {
    System.out.println("b gets " + j);
    return j - 1;
  }

  public static void main(String[] args) {
    ex1();
    System.out.println("--------------");
    ex5();
    System.out.println("--------------");
    ex6();
    System.out.println("--------------");
    ex8();
  }

}
