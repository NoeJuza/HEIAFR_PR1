package s08;
public class Ex0801 {
    public static void main(String[] args) {
        int[][] test = {{14,12,15},{521,12512},{12,1,125},{5213,1256,12561}};
        display2DimArrayValues(test);
    }
    public static void display2DimArrayValues(int[][] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(i +": ");
            for (int j = 0; j < array[i].length; j++) {
                if (j != array.length-1) {
                    System.out.print(array[i][j]+ " ");
                }else {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println();
        }
    }
}
