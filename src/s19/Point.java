//==============================================================================
//  HEIA-FR
//==============================================================================
package s19;

public class Point {
  private double x, y;
  
  public Point(double x, double y) {
    this.x = x; this.y = y;
  }
  
  public void move(double dx, double dy) {
    x += dx; y += dy;
  }
  
  @Override
  public String toString() {
    return "Point at (" + x + "," + y + ")";
  }
  
  public double getX() { return x; }
  
  public double getY() { return y; }
}
