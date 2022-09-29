package s03;
import proglib.SimpleIO;
public class Ex0307b {
    public static void main(String[] args) {
        int input = SimpleIO.readInt("N° of day of week:");
        if (input < 6 && input > 0){
            System.out.println("Working day");
        }else if (input < 8 && input > 0){
            System.out.println("Week-end");
        }else {
            System.out.println("Not a valid day");
        }
    }
}