//==============================================================================
//  HEIA-FR / Jacques Bapst
//==============================================================================

package s03;
import proglib.SimpleIO;

public class Ex0304 {

  //----------------------------------------------------------------------------
  // Values a, b and c can be given as program arguments, otherwise they
  // will be read in dialog boxes.
  //
  // Note: with IntelliJ IDEA, program arguments can be passed via the
  //       corresponding field of the "Run/Debug configuration"
  //       (e.g. menu Run -> Edit configurations...)
  //----------------------------------------------------------------------------
  public static void main(String [] args) {
    int a, b ,c;
    if (args.length == 3) {
      a = Integer.parseInt(args[0]);
      b = Integer.parseInt(args[1]);
      c = Integer.parseInt(args[2]);
    } else {
      a = SimpleIO.readInt("Value of a");
      b = SimpleIO.readInt("Value of b");
      c = SimpleIO.readInt("Value of c");
    }

    System.out.println("Equation: ("+a+")x\u00B2 + ("+b+")x + ("+c+") == 0");

    // TODO
    double discriminant;

  }
}
