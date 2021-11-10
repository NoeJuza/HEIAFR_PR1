//==============================================================================
//  HEIA-FR / Rudolf Scheurer
//==============================================================================

package corr.s12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex1210_Corr {

  //----------------------------------------------------------------------------
  public static void main(String[] args) {
    //args=new String[]{"a.txt"}; 
    if (args.length != 1) {
      System.out.println("Error: one single argument expected (filename).");
      return;
    }
    try {
      makeLetterStatistics(args[0]);
    } catch(IOException e) {
      System.out.println("something went wrong...");
    }
  }

  //----------------------------------------------------------------------------
  public static void makeLetterStatistics(String filename) throws IOException {

    BufferedReader fileIn = new BufferedReader(new FileReader(filename));
    int[] occ=new int[26];
    int total=0;
    String line = fileIn.readLine();
    while (line != null) {
      for(int i=0; i<line.length(); i++) {
        char c=line.charAt(i);
        if(c<'A' || c>'Z') continue;
        occ[c-'A']++;
        total++;
      }
      line = fileIn.readLine();
    }

    // Close file
    fileIn.close();
    
    // Print statistics
    System.out.println("Letter statistics: Total="+total);
    for(int i=0; i<occ.length; i++) {
      int a=occ[i];
      if(a==0) continue;
      System.out.print  (" Letter "+( (char)(i+'A')) +" occurs ");
      System.out.println(a+" times, in % : " + (a/(double)total) );
    }
  }
}
