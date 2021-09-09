//==============================================================================
//  EIA-FR
//==============================================================================
package s18;

public class Ex1801 {
  public static void main(String[] args) {
    Thing a,b,c;
    a = new Thing(4);
    a.e(); a.f();
    System.out.println(a.x +" "+ a.y);
    b = new Thing(3);
    Thing.f();
    System.out.println(b.x +" "+ b.y);
    c=a;
    c.e(); c.f();
    System.out.println(a.x +" "+ a.y);
  }
}

