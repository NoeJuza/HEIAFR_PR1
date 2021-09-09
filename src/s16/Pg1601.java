//==============================================================================
//  EIA-FR
//==============================================================================
package s16;

import s16.gizmo.Gizmo;

public class Pg1601 {
  public static void main(String[] args) {
    Gizmo g = new Gizmo(5);
    int a = g.a(g);
    System.out.println(a + "\n" + g.c);
    a = Gizmo.b(g);
    System.out.println(a + "\n" + g.c);
    g = new Gizmo(3);
    System.out.println(Gizmo.d + g.c);
    a = Gizmo.d;
  }
}