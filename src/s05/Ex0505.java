package s05;

public class Ex0505 {
    public static void main(String[] args) {
        int currentNumberOfNumbersOnLine = 0;
        for (int i = 50; i <= 1000 ; i++) {
            if (i % 6 == 0 && i % 5 == 0){
                currentNumberOfNumbersOnLine++;
                if (currentNumberOfNumbersOnLine >= 10){
                    System.out.println(i);
                    currentNumberOfNumbersOnLine = 0;
                }else {
                    System.out.print(i + ",");
                }
            }
        }
    }
}
