//==============================================================================
//  EIA-FR
//==============================================================================
package s18;

public class Base {
  public    int a;
  protected int b;
  private   int c;
  public      Base() {
    System.out.println("A");
  }
  public void doIt() {
    System.out.println("B");     // (1)
  }
}
