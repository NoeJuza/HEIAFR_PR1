
package s25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BenfordReader {
  
  public void addNumbersFoundInString(String s) {
    // TODO
  }
  
  public void addNumbersFoundInFile(String filename) throws IOException {
    // TODO
  }
  
  /** returns an array r with r.length==10; 
   * r[0] is not used, "r[d]==f" means that
   * digit d appears as first significant digit 
   * with frequency f (0 <= f <= 1)
   * It considers all numbers added so far.
   */
  public double[] firstDigitDistribution() {
    return new double[10]; // TODO
  }
  
  //------------------------------------------------------------
  public static void main(String... args) {
    BenfordReader ba=new BenfordReader();
    String s="Rule 8 - Here is a 25.9 mark on a 0.04 box; it costs $ 8.5 now.";
    ba.addNumbersFoundInString(s);
    System.out.println(Arrays.toString(ba.firstDigitDistribution()));
  }
 
}