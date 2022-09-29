package s03;
import proglib.*;
public class Ex0305 {
    public static void main(String[] args) {
        int n = SimpleIO.readInt("Entrez un nombre entier n");

        if (n % 6 == 0 && n % 5 == 0){
            System.out.println("" + n +" is divisible by 5 and 6");
        }else if(n % 6 == 0){
            System.out.println("" + n +" is divisible by 6");
        }else if(n % 5 == 0){
            System.out.println("" + n +" is divisible by 5");
        }else{
            System.out.println("" + n +" is divisible by neither 5 nor 6");
        }
    }
}
