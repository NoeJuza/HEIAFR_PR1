package s09;

public class SquareRoot {
    public static int intSquareRoot(int n) throws IllegalArgumentException{
        int intSqrt = 0;
        if (n < 0){
            throw new IllegalArgumentException("Negative number!!");
        }
        for (int i = 0; i <= n/2; i++) {
            if (i*i <= n) {
                intSqrt = i;
            }
        }
        return intSqrt;
    }
}
