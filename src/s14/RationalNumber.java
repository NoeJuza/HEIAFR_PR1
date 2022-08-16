//==============================================================================
//  EIA-FR
//==============================================================================
package s14;

public class RationalNumber {

  // should raise an IllegalArgumentException when denominator == 0
  public RationalNumber(int numerator, int denominator) { }

  public void    multiply(RationalNumber a) { }
  public void    divide  (RationalNumber a) { }
  public void    add     (RationalNumber a) { }
  public void    subtract(RationalNumber a) { }
  public void    multiply(int i)            { }
  public void    add     (int i)            { }
  public boolean lessThan(RationalNumber a) { return false; }
  public boolean equals  (RationalNumber a) { return false; }
  public float   toFloat ()                 { return 0;     }
  public String  toString()                 { return "";    }
}