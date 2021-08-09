//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package s02;

public class Pg0201 {
  public static void main(String [] args) {
    byte   b = 5;    
    float  f = 2.5F;
    short  s = 8;    
    double d = 5.2;
    int    i = 9;

    System.out.println( d/2 );
    System.out.println( s*4 );
    System.out.println( (b+s) > (5*f) );
    System.out.println( i/4 + d );
    System.out.println( 1/3 );
    System.out.println( b&6 );
    
    System.out.println( b*b );
    System.out.println( i^3 );
    System.out.println( i*4/12%6 );
    System.out.println( b << 2 );
    System.out.println( s==5 | !false );
    System.out.println( i++ );
  }
}
