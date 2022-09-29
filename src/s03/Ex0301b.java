package s03;
import proglib.*;
import java.util.*;
public class Ex0301b {
    public static void main(String[] args) {
        int numOfSides = SimpleIO.readInt("Entrez le nombres de côtés de votre forme"); // number of sides selected by user
        boolean isATriangle = true; // flag to check if the values provided really make a correct polygon
        double sum = 0; // sum of the length of the sides
        List<Double> ls = new ArrayList(); // list to store all the sides ls = ListSides
        for (int i = 0; i < numOfSides; i++) {
            ls.add(SimpleIO.readDouble("Entrez la valeur de la longeur " + (i+1))); // prompting the user to get the values
        }
        for(int i = 0; i < ls.size(); i++){
            sum += ls.get(i);
        }
        for (int i = 0; i < ls.size(); i++) {
            if (sum - ls.get(i) < ls.get(i)){
                isATriangle = false;
            }
        }
        if (isATriangle){
            System.out.println("C'est un polygone à "+numOfSides+" côtés valable et de périmètre "+sum);
        }else{
            System.out.println("Ce n'est pas un polygone à "+numOfSides+" côtés valable!");
        }
    }
}