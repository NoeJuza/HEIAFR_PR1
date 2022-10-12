package s08;

public class Ex0804 {
  public static int nMonotonies(int[] t) {
    int nbMonotonies = 0;
    for (int i = 1; i < t.length; i++) {
      if (t[i] > t[i-1]) {
        nbMonotonies++;
      }
    }
    return nbMonotonies; // TODO
  }

  public static void main(String[] args) {
    int[] t = {3, 1, 4, 6, 2, 9};
    System.out.println(nMonotonies(t));
  }
}
