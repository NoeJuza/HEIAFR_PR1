package s06;

public class Ex0604 {
    public static void main(String[] args) {
        generatePairs(1000);
    }
    public static void generatePairs(int p){
        for (int a = 1; a < p; a++) {
            for (int b = 1; b<a; b++) {
                if ((( (a*a) + (b*b) +1 ) % (a*b) == 0) ){
                    System.out.println("a="+a + ",b=" + b);
                }
            }
        }
    }
}
