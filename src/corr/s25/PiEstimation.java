
package corr.s25;
import java.util.Random;

public class PiEstimation {
  private final Random random=new Random();
  private final int nPoints;
  
  public PiEstimation(int nbOfPoints) {
    this.nPoints=nbOfPoints;
  }
  
  public double piApproximation() {
    return piApproximation(nPoints, random);
  }

  private static double piApproximation(long nPoints, Random rnd) {
    long hits=0;
    for(int i=0; i<nPoints; i++) {
      double x=2*rnd.nextDouble()-1.0; // so in [-1.0 .. +1.0[
      double y=2*rnd.nextDouble()-1.0;
      if(x*x + y*y < 1) hits++;
    }
    return 4*hits/(double)nPoints;
  }
  
  //------------------------------------------------------
  // tiny demo
  
  private static void estimateSeveralTimes(int n, int nExp) {
    PiEstimation pe=new PiEstimation(n);
    double peMin=pe.piApproximation(), peMax=peMin;
    for(int i=0; i<nExp; i++) {
      double c1=pe.piApproximation();
      peMin=Math.min(peMin, c1);
      peMax=Math.max(peMax, c1);
    }
    System.out.print("Over "+nExp+" experiments, ");
    System.out.println("with "+n+" points: [ "+peMin+" .. "+peMax+" ]");

  }
  public static void main(String[] args) {
    estimateSeveralTimes(   100_000, 100);
    estimateSeveralTimes( 1_000_000, 100);
    estimateSeveralTimes(10_000_000, 100);
  }
}
