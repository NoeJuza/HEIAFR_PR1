//==============================================================================
//  HEIA-FR
//==============================================================================
package s16.gizmo;

public class Gizmo {
  private int        a;
  static  int        b;
  public  int        c = 1;
  public  static int d = 2;

  public Gizmo(int g) {
    a=2; b=1; c *= ++a; d += g;
  }

  public int a(Gizmo g) {
    a++; b++; d += g.c;
    return d;
  }

  public static int b(Gizmo g) {
    d += b++; g.c += b;
    return d;
  }
}

