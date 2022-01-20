
package corr.s25;

public class RandomWalk3D extends RandomWalk {
  private long crtZ;

  public RandomWalk3D() {
    super();  // it would be implicit when omitted
  }
  
  public void walkOneStep() {
    switch(rnd.nextInt(6)) {
      case 0:
      case 1:
      case 2: 
      case 3: super.walkOneStep(); break;
      case 4: crtZ++; break;
      case 5: crtZ--; break;
    }
  }
  
  public long currentZ() {
    return crtZ;
  }
  
  public boolean isAtOrigin() {
    return crtZ==0 && super.isAtOrigin();
  }
  
  //----------------------------
  // creates a RandomWalk, run it until it comes back to origin (true is 
  // returned), or else maxSteps have been applied (false is returned)
  public static boolean newWalkFinishes(long maxSteps) {
    RandomWalk rw=new RandomWalk3D();  // <--- only change wrt RandomWalk!
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
  
  public static void main(String...args) {
    System.out.println(probabilityToHalt(10, 10_000));
  }
}