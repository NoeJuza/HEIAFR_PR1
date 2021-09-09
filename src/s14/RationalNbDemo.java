//==============================================================================
//  EIA-FR
//==============================================================================
package s14;

public class RationalNbDemo {

  public static void main(String[] args) {
    RationalNumber x, y;
    x = new RationalNumber(3, 4);
    y = new RationalNumber(9, 7);
    x.multiply(y);
    y.add(4);
    System.out.println("As float : " + x.toFloat());             // 0.9642
    System.out.println("As string: " + x.toString());            // "27/28"
    System.out.println(x + " = " + y + " ? " + x.equals(y));
    System.out.println(x + " < " + y + " ? " + x.lessThan(y));
  }
} 
