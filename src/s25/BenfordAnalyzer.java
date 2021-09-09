
package s25;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.Random;

public class BenfordAnalyzer {
  // TODO
  
  public BenfordAnalyzer() {
    // TODO
  }
  
  /** @return the first significant digit of d, 
   * or 0 if there is none (as in 0.0, NaN, POSITIVE_INFINITY...) */
  public static int firstDigit(double d) {
    return 0;  // TODO
  }

  public void addNumber(double d) {
    // TODO
  }
  
  public void addArray(double[] tab) {
    // TODO
  }
  
  public void addStream(DoubleStream ds) {
    // TODO
  }
  
  /** returns an array r with r.length==10; 
   * r[0] is not used, "r[d]==f" means that
   * digit d appears as first significant digit 
   * with frequency f (0 <= f <= 1)
   * It considers all numbers added so far.
   */
  public double[] firstDigitDistribution() {
    // TODO
    double[] res=new double[10];
    return res;
  }
  
  //------------------------------------------------------------
  public static void main(String... args) {
    BenfordAnalyzer ba=new BenfordAnalyzer();
    ba.addNumber( 4.5 );
    ba.addArray(new double[] { -0.089 , 4987.0 , 4.5E-19 });
    System.out.println(Arrays.toString(ba.firstDigitDistribution()));
    
    Random rnd=new Random();
    DoubleStream ds=DoubleStream
        .generate(rnd::nextGaussian)
        .limit(100_000);
    ba.addStream(ds);
    System.out.println(Arrays.toString(ba.firstDigitDistribution()));
  }
 
}