package s01;
//--------------- Second Program ---------------------
public class SecondProgram {

  public static void main(String[] args) {
    int length, width, area;

    length = 8;
    width  = 6;
    area   = length * width;

    System.out.println("Rectangle length : " + length);
    System.out.println("Rectangle width  : " + width);
    System.out.println("Rectangle area   : " + area);
    System.out.println();

    length = length * 2;
    width  = width  * 2;
    area   = length * width;

    System.out.println("Rectangle length : " + length);
    System.out.println("Rectangle width  : " + width);
    System.out.println("Rectangle area   : " + area);
  }
}
