//==============================================================================
//  HEIA-FR
//==============================================================================
package s18;

public class PlotterDemo {
  public static void main(String [] args) {
    Plotter p = new Plotter();
    p.raise();
    p.move(+30, +30);
    p.drop();
    p.move(+10, 0);
    p.move(0, -15);
    System.out.println(p.strokeLength());
    System.out.println(p.isDown());
    System.out.println(p.xCoord() + " "
                      +p.yCoord());
  }
}
//----- Output :  25.0
//                true
//                40 15

