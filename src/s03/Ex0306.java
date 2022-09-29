package s03;
import proglib.*;
import java.util.*;
public class Ex0306 {
    public static void main(String[] args) {
        int nToEvaluate = 3;
        int maxOfN = 0;
        List<Integer> ln = new ArrayList<Integer>();

        for (int i = 0; i < nToEvaluate; i++) {
            ln.add(SimpleIO.readInt("Input the Integer N°" + (i+1) ));
        }
        System.out.print("The numbers you chose are: ");
        for (int i = 0; i < ln.size(); i++) {
            System.out.print( ln.get(i) + " " );
            if (maxOfN < ln.get(i)) {
                maxOfN = ln.get(i);
            }
        }
        System.out.print("\n");
        System.out.println("The maximal number out of the " + nToEvaluate + " numbers is " + maxOfN);
    }
}
