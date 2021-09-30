//==============================================================================
//  HEIA-FR / Jacques Bapst
//==============================================================================

package s03;
import proglib.SimpleIO;

public class Ex0304_with_doubles {

  //----------------------------------------------------------------------------
  // Values a, b and c can be given as program arguments, otherwise they
  // will be read in dialog boxes.
  //
  // Note: with IntelliJ IDEA, program arguments can be passed via the
  //       corresponding field of the "Run/Debug configuration"
  //       (e.g. menu Run -> Edit configurations...)
  //----------------------------------------------------------------------------
  public static void main(String[] args) {
    double a, b ,c;
    if (args.length == 3) {
      a = Double.parseDouble(args[0]);
      b = Double.parseDouble(args[1]);
      c = Double.parseDouble(args[2]);
    } else {
      a = SimpleIO.readDouble("Value of a");
      b = SimpleIO.readDouble("Value of b");
      c = SimpleIO.readDouble("Value of c");
    }

    System.out.println("Equation: ("+a+")x\u00B2 + ("+b+")x + ("+c+") == 0");

    // TODO
    double discriminant;

  }
}
