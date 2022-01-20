
package corr.s25;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;

public class BenfordAnalyzer {
  private static final int BASE=10;
  private int nConsideredCandidates=0;
  private final int[] firstDigitCount=new int[BASE]; 
  
  public BenfordAnalyzer() { }
  
  /** @return the first significant digit of d, 
   * or 0 if there is none (as in 0.0, NaN, POSITIVE_INFINITY...) */
  public static int firstDigit(double d) {
    String s=String.valueOf(d);
    for(int i=0; i<s.length(); i++) {
      char c= s.charAt(i);
      if(c >= '1' && c <='9')
        return (c-'1') + 1;
    }
    // could be "POSITIVE_INFINITY", "NaN", "0.0"...
    return 0;
  }

  public void addNumber(double d) {
    int digit=firstDigit(d);
    if(digit != 0) {
      nConsideredCandidates++;
      firstDigitCount[digit]++;
    }
  }
  
  public void addArray(double[] tab) {
    for(double d:tab) 
      addNumber(d);
  }
  
  public void addStream(DoubleStream ds) {
    ds.forEach(this::addNumber);
  }
  
  /** returns an array r with r.length==10; 
   * r[0] is not used, "r[d]==f" means that
   * digit d appears as first significant digit 
   * with frequency f (0 <= f <= 1)
   * It considers all numbers added so far.
   */
  public double[] firstDigitDistribution() {
    double[] res=new double[BASE];
    if(nConsideredCandidates==0) 
      return res;
    for(int i=0; i<BASE; i++)
      res[i] = firstDigitCount[i]/(double)nConsideredCandidates;
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