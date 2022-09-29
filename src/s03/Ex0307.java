package s03;
import proglib.SimpleIO;
public class Ex0307{
    public static void main(String[] args) {
        int input = SimpleIO.readInt("N° of day of week:");
        switch (input){
            case 1,2,3,4,5:
                System.out.println("Working day");
                break;
            case 6,7:
                System.out.println("Week-end");
                break;
            default:
                System.out.println("Not a valid day");
                break;
        }
    }
}
