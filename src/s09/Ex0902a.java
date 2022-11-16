package s09;

public class Ex0902a {
    public static void main(String[] args) {
        try{
            int a = SquareRoot.intSquareRoot(150);
            System.out.println(a);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
