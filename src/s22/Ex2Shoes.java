package s22;

// import java.util.function. ... ;

public class Ex2Shoes {
  //================================================
  public static class Shoes  {
    private final String type;
    private final String color;
    private final int size;
    public Shoes(String type, String color, int size) {
      super();
      this.type = type;
      this.color = color;
      this.size = size;
    }
    public String getType() {
      return type;
    }
    public String getColor() {
      return color;
    }
    public int getSize() {
      return size;
    }
    public String toString() {
      return "Shoe "+type+" "+color+" "+size;
    }
  }
  //================================================
  public interface ShoesSelector {
    public boolean isOk(Shoes s);
  }
  //================================================
//  static class BySizeSelector implements ShoesSelector {
//    // TODO
//  }
  //================================================
  public static void main(String[] args) {

    Shoes[] shoesArray = new Shoes[] {
        new Shoes("Running", "Red",    41),
        new Shoes("Boots",   "Brown",  38),
        new Shoes("Running", "Brown",  43),
        new Shoes("Running", "Yellow", 40),
        new Shoes("Walking", "Red",    41),
        new Shoes("Boots",   "Red",    45)
    };

    // Print by size [with a separate class]
    System.out.println("---- size=41");
    //printShoes(shoesArray, new BySizeSelector(41));

    // Print by color [with an anonymous class]
    System.out.println("---- color=Brown");
    //printShoes(shoesArray, ......"Brown"... );

    // Print by type [with a lambda expression]
    System.out.println("---- type=Boots");
    //printShoes(shoesArray, ......"Boots"...);

    // Print by type [with a lambda expression of a "standard library" type]
    // ??? runningShoesSelector = (...) -> ..."Running"...;
    System.out.println("---- type=Running");
    //printShoes1(shoesArray, runningShoesSelector);
  }
  
  public static void printShoes(Shoes[] t, ShoesSelector c) {
    // TODO
  }

  // -----------------------------------------------------
  // printShoes method with a "standard library" interface
  // -----------------------------------------------------
  //public static void printShoes1(Shoes[] t, ... ) {
  //  ...  
  //}
}
