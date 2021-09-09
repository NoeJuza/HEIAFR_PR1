
package s18;

public class Parent {
  public  int bPub = 2;
  private int bPriv = 4;
  static  int bStat = 5;

  static void m(Object[] z) {
    int v = 1;
    z[v] = z;
    // (*)
    v = 3;
  }

  public static void main(String[] args) {
    Object[] t = {null, null};
    Child.cStat = new Child(t);
    m(t);
    bStat++;
  }
}

//===========================================

class Child extends Parent {
  private int   cPriv = 6;
  static Object cStat = null;
    
  public Child(Object[] h) {
    int w = 0;
    h[w] = this;
  }
}
