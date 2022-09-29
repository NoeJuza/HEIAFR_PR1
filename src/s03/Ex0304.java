package s03;
import proglib.SimpleIO;
public class Ex0304 {
  public static void main(String[] args) {
    double a, b ,c;
    if (args.length == 3) {
      a = Double.parseDouble(args[0]);
      b = Double.parseDouble(args[1]);
      c = Double.parseDouble(args[2]);
    } else {
      a = SimpleIO.readDouble("Value of a");
      b = SimpleIO.readDouble("Value of b");
      c = SimpleIO.readDouble("Value of c");
    }

    System.out.println("Equation: ("+a+")x\u00B2 + ("+b+")x + ("+c+") == 0");

    // TODO
    double rep;
    double discriminant;
    if (a == 0){
      if (b== 0){
        if (c == 0){
          System.out.println("Infinite solutions to equation");
        }else{
          System.out.println("Impossible equation (no solutions)");
        }
      }else {
        // in this case; Equation can be simplified to ax+b
        // y= ax+b
        // 0 = ax+b
        // => x= b/a
        System.out.println("x = c/b = " + c + "/" + b + " = " + (c/b) ); ;
      }
    }else{
      discriminant = Math.pow(b,2) - 4 * a * c;
      System.out.println("Δ = " + discriminant);
      if (discriminant < 0){
        //x1=–b/2a+i* sqrt(–discriminant)/2a and x2=–b/2a–i* sqrt(–discriminant)/2a
        System.out.println("No solution in R");
        System.out.println("x1 = -b/2a + i*(-Δ)⁰·⁵ /2a and x2 = -b/2a - i*(-Δ)⁰·⁵ /2a = " + ((-b)/2*a) +
                " + i*"+ Math.sqrt(discriminant) + "/" + (2*a) +" and x2 = " + ((-b)/2*a) + " - i*" + Math.sqrt(discriminant) + "/" + (2*a) );
      }else if(discriminant == 0){
        //x1,2=–b/2a
        System.out.println("x1,2 = -b/2a = " + (-b) + "/" + (2*a)+ " = " + ((-b)/(2*a)));
      }else{
        //x1=(–b+ sqrt(discriminant) )/2a and x2=(–b – sqrt(discriminant) )/2a
        System.out.println("x1=(–b+ sqrt(Δ) )/2a and x2=(–b – sqrt(Δ) )/2a = " + "x1=" + ((-b + Math.sqrt(discriminant))/2*a) + " and x2= " + ((-b - Math.sqrt(discriminant))/2*a) );
      }
    }
  }
}