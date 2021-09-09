
package s24;

public class PlayWithGenericFunctions {
  //=====================================
  public interface IFunction<T> {
    T valueAt(T x);
  }
  //=================================================
  // TODO: ex2b - declare a generic version of the interface IFoldableOperation

  //=================================================
  // TODO: ex2b - declare a generic version of the interface ISequence
  //=================================================
  static class MyFunctionEx2a { // TODO ex 2a + 2e1
  }
  //=================================================
  public static void ex2a() {
    IFunction<Double> f;
    // **** with internal class ***
    f = null; // TODO ex2a
    System.out.println(f.valueAt(3.0));

    // **** with anonymous class ***
    f = null; // TODO ex2a
    System.out.println(f.valueAt(3.0));

    // **** with lambda expression ***
    f = null; // TODO ex2a
    System.out.println(f.valueAt(3.0));
  }
  
  // TODO: ex2b - define an adapted/generic version of the foldLeft() method

  private static void computeAllEx2e(IFunction<Double> f) {
    // ISequence... vsSeries = CommonSequences.fromSeries(f, 0, 20);
    // ISequence... vsWords = CommonSequences.fromArray(new String[]{"Hello","World","!"});
    
    // System.out.println(foldLeft(vsSeries, FoldOperators.SUM));
    // System.out.println(foldLeft(vsWords, FoldOperators.CONCAT));
    // System.out.println();
  }
  
  public static void main(String[] args) {
    ex2a();
    
    // *******************************************
    // ****** With internal static classes: ******
    // *******************************************

    IFunction<Double> f = null; // TODO
    computeAllEx2e(f);

    // *************************************
    // ****** With anonymous classes: ******
    // *************************************

    f = null; // TODO
    computeAllEx2e(f);

    // **************************************
    // ****** With lambda expressions: ****** 
    // **************************************

    f = null; // TODO
    computeAllEx2e(f);
  }
}
