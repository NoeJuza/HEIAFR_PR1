package s09;

public class Ex0901 {
  
  public static void main(String[] args) {
    System.out.println("A");
    try {
      System.out.println("B");
      px(0);
      System.out.println("C");
    } catch (Exception e) {
      System.out.println("Z");
    }
    System.out.println("D");
  }

  public static void px(int i) throws Exception {
    int[] t = new int[3];
    int j;
    try {
      j = 100 / i;
      System.out.println("X");
    } catch (Exception e) {
      System.out.println("W");
    } 
    for (j=0; j<5; j++) {
      System.out.println(j);
      t[j] = 3+j;
    }
    System.out.println(t.length);
  }  
}
