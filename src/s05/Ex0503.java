package s05;
public class Ex0503 {
    public static void main(String[] args) {
        double approxofE = 0;
        double increment = 1;
        double lastIncrement = 0;
        int i = 1;
        while (increment > 1e-12){
            int ms = 1;
            lastIncrement = increment;
            approxofE += increment;
            int j=1;
            while (j <=i){
                ms*=j;
                j++;
            }
            //System.out.println(ms);
            increment = (float) (1.0/ms);
            i++;
        }
        System.out.println("Number of iterations: " + (i-1) );
        System.out.println("Last increment was: " + lastIncrement);
        System.out.println("Approx of e is: " + approxofE);
    }
}
