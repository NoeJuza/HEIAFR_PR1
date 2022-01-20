
package corr.s25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BenfordReader {
  private final BenfordAnalyzer benford=new BenfordAnalyzer();

  
  public void addNumbersFoundInString(String s) {
    // try-with-resources (Scanner is AutoCloseable)
    try(Scanner scn=new Scanner(s)) {   
      while(scn.hasNext()) {
        if(scn.hasNextDouble())
          benford.addNumber(scn.nextDouble());
        else
          scn.next();
      }
    }
  }
  
  public void addNumbersFoundInFile(String filename) throws IOException {
    try(FileReader fr=new FileReader(filename); 
        BufferedReader bf=new BufferedReader(fr)) {
      bf.lines().forEach(this::addNumbersFoundInString);
    }
  }
  
  /** returns an array r with r.length==10; 
   * r[0] is not used, "r[d]==f" means that
   * digit d appears as first significant digit 
   * with frequency f (0 <= f <= 1)
   * It considers all numbers added so far.
   */
  public double[] firstDigitDistribution() {
    return benford.firstDigitDistribution();
  }
  
  //------------------------------------------------------------
  public static void main(String... args) {
    BenfordReader ba=new BenfordReader();
    String s="Rule 8 - Here is a 25.9 mark on a 0.04 box; it costs $ 8.5 now.";
    ba.addNumbersFoundInString(s);
    System.out.println(Arrays.toString(ba.firstDigitDistribution()));
    
    ba=new BenfordReader();
    // a couple of numbers: 14.55 , -0.019 , 19.98 , 0.0001935... 
    ba=new BenfordReader();
    String f="src/corr/s23/BenfordReader.java";
    try {
      ba.addNumbersFoundInFile(f);
    } catch(IOException e) {
      e.printStackTrace();
    }
    System.out.println(Arrays.toString(ba.firstDigitDistribution()));
  }
 
}