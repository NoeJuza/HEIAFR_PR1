//==============================================================================
//  HEIA-FR
//==============================================================================
package s09;

import java.io.*;

public class LineKiller {
  static void readFirstLine(BufferedReader br) {
    String s;
    try {
      s = br.readLine();
      if(!s.startsWith("/*")) 
        println(s);
    } catch (IOException e) {
      println("error... " + e);
      System.exit(-1);
    }
  }
  //--------------------------------------------------------------------------------
  static void readOtherLines(BufferedReader br) {
    String s;
    try {
      s=br.readLine();
      while(s != null) {
        println(s); 
        s = br.readLine();
      }
    } catch (IOException e) {
      println("error... " + e);
      System.exit(-1);
    }
  }
  //--------------------------------------------------------------------------------
  static void processFile(String filename) {
    BufferedReader br=null;
    try {
      br= new BufferedReader(new FileReader(filename));
      readFirstLine(br); 
      readOtherLines(br);    
    } catch (IOException e) {
      println("error... " + e);
      System.exit(-1);
    }
    try {
      br.close();
    } catch (IOException e) {
      println("error... " + e);
      System.exit(-1);
    }
  }
  //--------------------------------------------------------------------------------
  public static void println(String s) {
    System.out.println(s);
  }
  //--------------------------------------------------------------------------------
  public static void main(String [] args) {
    String filename = "LineKiller.java";
    processFile(filename);
  }
}
