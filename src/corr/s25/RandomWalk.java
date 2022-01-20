
package corr.s25;
import java.util.Random;

public class RandomWalk {
  private long crtX, crtY;
  protected final Random rnd=new Random();
  
  public RandomWalk() { }
  
  public void walkOneStep() {
    switch(rnd.nextInt(4)) {
      case 0: crtX++; break;
      case 1: crtX--; break;
      case 2: crtY++; break;
      case 3: crtY--; break;
    }
  }
  
  public long currentX() {
    return crtX;
  }
  
  public long currentY() {
    return crtY;
  }
  
  public boolean isAtOrigin() {
    return crtX==0 && crtY==0;
  }
  
  //----------------------------
  // creates a RandomWalk, run it until it comes back to origin (true is 
  // returned), or else maxSteps have been applied (false is returned)
  public static boolean newWalkFinishes(long maxSteps) {
    RandomWalk rw=new RandomWalk();
    for(int i=0; i<maxSteps; i++) {
      rw.walkOneStep();
      if(rw.isAtOrigin()) return true;
    }
    return false;
  }
  
  public static double probabilityToHalt(long maxSteps, int nExperiments) {
    if (nExperiments<=0) 
      throw new IllegalArgumentException("nExperiments must be >0");
    int m=0;
    for(int i=0; i<nExperiments; i++)
      if (newWalkFinishes(maxSteps)) m++;
    return m/(double)nExperiments;
  }
  
  public static void main(String... args) {
    int nExp = 10_000;
    System.out.println("(Estimated on "+nExp+" experiments)");
    System.out.println("Probability to finish the walk in at most ...:");
    for(int s:new int[]{2, 5, 10, 100, 1000})
      System.out.printf("... %4d steps: %.3f\n", s, probabilityToHalt(s, nExp));
  }
}