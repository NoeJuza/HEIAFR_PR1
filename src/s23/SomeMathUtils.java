
package s23;

public class SomeMathUtils {
  //========================================================
  public interface PowerModulo {
    /** Precondition: base, exponent and modulo > 0 */
    long powerModulo(long base, long exponent, long modulo);
  }
  //========================================================

  public static long powerModA(long x, long y, long z) {
    return (long) Math.pow(x, y) % z;
  }

  public static long powerModB(long x, long y, long z) {
    long res = 1;
    while (y-- > 0)
      res = res * x;
    return res % z;
  }

  public static long powerModC(long x, long y, long z) {
    long res = 1;
    while (y-- > 0)
      res = (res * x) % z;
    return res;
  }

  public static long powerModD(long x, long y, long z) {
    long res = 1;
    while (y > 0) {
      if (y % 2 != 0)  // exponent is odd
        res = (res * x) % z;
      x = (x * x) % z;
      y = y / 2;
    }
    return res;
  }

  public static void tinyTest() {
    PowerModulo[] algos = {
            SomeMathUtils::powerModA,
            SomeMathUtils::powerModB,
            SomeMathUtils::powerModC,
            SomeMathUtils::powerModD,
    };
    for (PowerModulo algo : algos) {
      long result;
      result = algo.powerModulo(2, 4, 5);
      assertEquals(1, result);
      result = algo.powerModulo(187, 1769, 281);
      assertEquals(190, result);
    }
    System.out.println("Every algorithm seems correct!");
    System.out.println("Let's make another try to see if they agree... ");
    System.out.print("  powerModulo(183, 1768, 280) = ");
    for (PowerModulo algo : algos) {
      long result = algo.powerModulo(183, 1768, 280);
      System.out.print(result + " ... ");
    }
    System.out.println("\n  Strange, isn't it?");
  }

  private static void assertEquals(long expected, long effective) {
    if (expected != effective)
      throw new RuntimeException("Bad news: expected " + expected + " got " + effective);
  }

  // returns a long d such that (d * e) MODULO nPrime == 1
  // (and such that d != e)
  public static long moduloInverseNaive(long e, long nPrime) {
    assert nPrime > 0 && e > 0;
    long d = 3;
    while (d * e % nPrime != 1 || d == e) d++;
    return d;
  }

  static boolean isPrime(long n) {
    if (n < 2) return false;
    for (long div = 2; div < n; div++) {
      if (n % div == 0) return false;
    }
    return true;
  }

  // PRE: kth > 0
  public static long getKthPrimeNb(int kth) {
    long n = 0;
    int k = 0;
    for (k = 0; k < kth; n++)
      if (isPrime(n)) {
        k++;
      }
    return n - 1;
  }

  // returns a value that is relatively prime to x.
  public static long aNumberCoPrimeWith(long x) {
    assert x > 0;
    long i = 3; // initializing i to (1+x/2) is a very very bad idea
    while (gcd(x, i) != 1) i++;
    return i;
  }

  // greatest common divisor.
  private static long gcd(long a, long b) {
    while (b != 0) {
      long aux = b;
      b = a % b;
      a = aux;
    }
    return a;
  }


  // Adapted from [Weiss]

  /**
   * Works back through Euclid’s algorithm to find x and y such that
   * if gcd(a,b) = 1, ax + by = 1.
   * @return an array {x, y}
   */
  static long[] fullGcd(long a, long b) {
    long x1, y1;
    if (b == 0)
      return new long[] {1, 0};
    long[] xy = fullGcd(b, a % b);
    long x = xy[0], y = xy[1];
    x1 = x;
    y1 = y;
    x = y1;
    y = x1 - (a / b) * y1;
    return new long[] {x, y};
  }

  /**
   * Solve a * x == 1 (mod n), assuming gcd(a, n) = 1.
   * @return x.
   */
  public static long moduloInverseEfficient(long a, long n) {
    long[] xy =fullGcd( a, n );
    long x = xy[0];
    return x > 0 ? x : x + n;
  }

  public static void main(String[] args) {
    tinyTest();
  }

}
