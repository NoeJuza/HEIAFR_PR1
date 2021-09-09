
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
  // static class MyTrigonometricFct ...   // sin^2 cos


  //=================================================
  public static double foldLeft(INumberSequence ns, IFoldableOperation op) {
    return 0.0; // TODO ...
  }

  private static void computeAll(IFunction fa, IFunction fb) {
    // TODO ...
    //INumberSequence nsArray=...      1.2, 3.4, 5.6 
    //INumberSequence nsSeries=        fa entre 0 et 20
    //INumberSequence nsSamples=       fb entre 0 et PI avec 1000 échantillons
    
    //System.out.println(...   le produit sur nsArray 
    //System.out.println(...   la somme sur nsSeries
    //System.out.println(...   le maximum sur nsSample
  }
  
  public static void main(String[] args) {
    IFunction fa=null, fb=null;
    // *******************************************
    // ****** With internal static classes: ******
    // *******************************************
    // fa=...
    // fb=...
    computeAll(fa, fb);

    // *************************************
    // ****** With anonymous classes: ******
    // *************************************
    // fa=...
    // fb=...
    computeAll(fa, fb);

    // **************************************
    // ****** With lambda expressions: ******  <----- Ce sera pour le TP S22 !!!
    // **************************************
    // fa=...
    // fb=...
    computeAll(fa, fb);

  }
}
