//==============================================================================
//  EIA-FR
//==============================================================================
package s18;

public class Derived extends Base {
  public    int d;
  private   int e;
  public      Derived() {
    super();
    System.out.println("C");
  }
  public void doIt() {
    System.out.println("D");   // (3)
    super.doIt();
  }
  public void doIt(int i) {
    System.out.println("E");
    d = 3;
    doIt();
  }
}
