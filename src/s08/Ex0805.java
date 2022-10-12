package s08;
public class Ex0805 {
    public static void main(String[] args) {
        int[][] image = new int[8][16];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = 0 + (int)(Math.random() * ((127 - 0) + 1));
            }
        }
        System.out.println("image before reduction:");
        display2DimArrayValues(image);
        int[][] reduced = reduceImageMatrixBy4(image);
        System.out.println("image after reduction:");
        display2DimArrayValues(reduced);
    }
    public static int[][] reduceImageMatrixBy4(int[][] image){
        int[][] clone = image.clone();
        int[][]res = new int[clone.length/2][];
        for (int i = 0; i < clone.length; i += 2) {
            //System.out.println(i + "," + res.length);
            res[i/2] = new int[clone[i].length /2];
                        for (int j = 0; j < clone[i].length; j += 2) {
                res[i/2][j/2] = (int) ((double)((clone[i][j] + clone[i+1][j]+ clone[i][j+1] + clone[i+1][j+1])/4));
            }
        }
        return res;
    }
    public static void display2DimArrayValues(int[][] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(i +": ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
    }
}