//==============================================================================
//  HEIA-FR / Rudolf Scheurer
//==============================================================================

package s15;

import java.io.*;

public class Ex1502 {

  //----------------------------------------------------------------------------
  public static void main(String[] args) {
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

    String line = fileIn.readLine();
    while (line != null) {
      // Handle the line ...
      line = fileIn.readLine();
    }

    // Close file

    // Print statistics

  }
}
