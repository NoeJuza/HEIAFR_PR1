//==============================================================================
//  EIA-FR
//==============================================================================
package s18;

public class Thing {
  public         int x=0;
  public static  int y=0;
  public Thing(int v)    {
    x = x+v; y = y+v;
  }
  public        void e() {
    x++; y++;
  }
  public static void f() {
    y = 10*y;
  }
}

