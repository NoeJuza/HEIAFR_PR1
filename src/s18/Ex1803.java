//==============================================================================
//  HEIA-FR
//==============================================================================
package s18;

public class Ex1803 {
  public int t;
  public static void main(String[] args) {
    Base    x = new Base();
    Derived y = new Derived();         // (2)
    x.doIt(); y.doIt(); y.doIt(3);
  }
}
