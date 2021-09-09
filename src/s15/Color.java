// SUP 2019-11-19

/* ---- Conversions between colour models ----

  From HexString to RGB:
  - ignore the initial '#' character if it is present
  - the first two characters from left give the hexadecimal of R, the next two
    give G, and the last two give B
  - example: "#FFD700" → (0xFF, 0xD7, 0x00) → (255, 215, 0)

  From RBG to CMYK:
  - there is no unique formula in general, but for this exercise we apply the
    following rules
  - the R, G and B values in the range [0,255] are first divided by 255 to
    lie in the range [0,1]. Let's call those new values R’, G’ and B’.
  - the K value (meaning black) is computed as :  K = 1 – max(R’, G’, B’).
  - the C value (meaning cyan) is computed as:    C = (1 – R’ – K) / (1 – K)
  - the M value (meaning magenta) is computed as: M = (1 – G’ – K) / (1 – K)
  - the Y value (meaning yellow) is computed as:  Y = (1 – B’ – K) / (1 – K)

  From CMYK to RBG
  - according to the previous paragraph, the values R, G and B can be computed
    from C, M, Y and K values: R = 255 * (1 – C) * (1 – K)
                               G = 255 * (1 – M) * (1 – K)
                               B = 255 * (1 – Y) * (1 – K)

  Hexadecimal strings can be converted to/from int like this:
    int x = Integer.parseInt("A8", 16);
    String s = String.format("%02X", 29);
 */

package s15;

import java.util.Arrays;

public class Color {

    // TODO: declare attributes

    // Constructor from a valid HEX-String
    public Color(String s) {
        // TODO
    }

    // RGB Constructor
    public Color(int r, int g, int b) {
        // TODO
    }

    // CMYK Constructor
    public Color(double c, double m, double y, double k) {
        // TODO
    }

    // Returns the color as RGB
    public int[] rgb() {
        return null; // TODO
    }

    // Returns the color as CMYK
    public double[] cmyk() {
        return null; // TODO
    }

    // Returns the color as HEX String
    public String hexColor() {
        return ""; // TODO
    }

    @Override
    public String toString() {
        return hexColor();
    }

    static void println(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Color heiaBlue = new Color("#007CB7");
        Color heiaGrey = new Color(172, 163, 154);
        Color heiaRed = new Color(0.0, 0.94, 0.84, 0.05);

        println(heiaBlue.hexColor());
        println(heiaGrey.hexColor());
        println(heiaRed.hexColor());

        println(Arrays.toString(heiaBlue.rgb()));
        println(Arrays.toString(heiaGrey.rgb()));
        println(Arrays.toString(heiaRed.rgb()));

        println(Arrays.toString(heiaBlue.cmyk()));
        println(Arrays.toString(heiaGrey.cmyk()));
        println(Arrays.toString(heiaRed.cmyk()));

        System.out.println(Integer.parseInt("A8", 16));
        System.out.println(String.format("%02X", 29));
        /* Expected output:
             #007CB7
             #ACA39A
             #F20E26
             [0, 124, 183]
             [172, 163, 154]
             [242, 14, 38]
             [1.0, 0.32240437158469937, 0.0, 0.2823529411764706]
             [0.0, 0.05232558139534898, 0.10465116279069779, 0.3254901960784313]
	         [0.0, 0.9421487603305785, 0.8429752066115702, 0.050980392156862786]
         */
    }
}
