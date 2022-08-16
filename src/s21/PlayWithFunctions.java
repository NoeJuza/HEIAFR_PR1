
package s21;

public class PlayWithFunctions {
  public interface IFoldableOperation {
    double initialValue();
    double combine(double accumulated, double newValue);
  }
  //=================================================
  public interface INumberSequence {
    boolean hasMoreNumbers();
    double  nextNumber();
  }
  //=================================================
  public interface IFunction {
    double valueAt(double x);
  }
  //=================================================
  // TODO ...
  // static class MySeriesFct ...          // i/2^i

  // TODO ...
  // static class MyTrigonometricFct ...   // sin^2(x) * cos(x)


  //=================================================
  public static double foldLeft(INumberSequence ns, IFoldableOperation op) {
    return 0.0; // TODO (Exercise s21.ex2b)
  }

  private static void computeAll(IFunction fa, IFunction fb) {
    // TODO (Exercise s21.ex2d)
    //INumberSequence nsArray = ...    // 1.2, 3.4, 5.6    (Exercise s21.ex2d)
    //INumberSequence nsSeries =       // fa entre 0 et 20 (Exercise s21.ex2d)
    //INumberSequence nsSamples =      // fb entre 0 et PI avec 1000 échantillons (Exercise s21.ex2d, optional)
    
    //System.out.println(...   // le produit sur nsArray  (Exercise s21.ex2d)
    //System.out.println(...   // la somme sur nsSeries   (Exercise s21.ex2d)
    //System.out.println(...   // le maximum sur nsSample (Exercise s21.ex2d, optional)
  }
  
  public static void main(String[] args) {
    IFunction fa=null, fb=null;
    // *******************************************
    // ****** With internal static classes: ******
    // *******************************************
    // fa = ...
    // fb = ...
    computeAll(fa, fb);

    // *************************************
    // ****** With anonymous classes: ******
    // *************************************
    // fa = ...
    // fb = ...
    computeAll(fa, fb);

    // **************************************
    // ****** With lambda expressions: ******  <----- Ce sera pour le TP S22 !!!
    // **************************************
    // fa = ...
    // fb = ...
    computeAll(fa, fb);

  }
}
