package s22;
import java.util.Random;
import java.util.function.DoubleSupplier;

public class Ex5MethodRef {
  private static final Random rnd=new Random();
  
  static double randomValue(double[] t) {
    return t[rnd.nextInt(t.length)];
  }
  
  static double randomValue(DoubleSupplier[] t) {
    return t[rnd.nextInt(t.length)].getAsDouble();
  }
  
  static double hardComputation1() {
    double res=0.0;
    for(int i=1; i<10_000_000; i++) {
      res+= Math.sin(Math.sqrt(Math.sqrt(Math.PI/i)));
    }
    return res;
  }

  static double hardComputation2() {
    double res=0.0;
    for(int i=1; i<10_000_000; i++) {
      res+= Math.atan(Math.pow(Math.PI/i, Math.sqrt(i)));
    }
    return res;
  }
  
  static double hardComputation3() {
    return Math.log(hardComputation1()+hardComputation2());
  }

  public static void main(String[] args) {
    System.out.println("start");
    double[] t = {
        hardComputation1(),
        hardComputation2(),
        hardComputation3()
    };
    double d=randomValue(t);
    System.out.println(d);
  }

}
