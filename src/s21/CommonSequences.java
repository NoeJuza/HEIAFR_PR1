
package s21;
import static s21.PlayWithFunctions.*;

public class CommonSequences {
  // ***********************************
  // ****** With internal classes ******
  // ***********************************
  
  public static INumberSequence fromArray(double[] t) {
    return null; // TODO ...  return new ArrayNumberSequence(t)
  }
  
  public static INumberSequence fromSeries(IFunction f, int from, int to) {
    return null; // TODO ...  return new SeriesNumberSequence(...)
  }
  
  public static INumberSequence fromSampledFunction(IFunction f, 
                                                    double from, double to, 
                                                    int nSubSamples) {
    return null; // TODO ... return new SampledFunctionNumberSequence(...)
  }
  
  // static class ArrayNumberSequence ...  // TODO ...
  
  // static class SeriesNumberSequence ...  // TODO ...

  // static class SampledFunctionNumberSequence ...  // TODO ...
  
  
  
  // ************************************
  // ****** With anonymous classes ******
  // ************************************
  
  public static INumberSequence fromArray1(final double[] t) {
    return null; // TODO...
  }

  public static INumberSequence fromSeries1(final IFunction f, 
                                            final int from, final int to) {
    return null; // TODO...
  }
  
  public static INumberSequence fromSampledFunction1(final IFunction f, 
                                                     final double from, 
                                                     final double to, 
                                                     final int nSubSamples) {
    return null; // TODO...
  }
}
