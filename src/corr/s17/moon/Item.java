package corr.s17.moon;

public class Item {
  private final String name;
  private final int weight;

  public Item(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  public String name() {
    return this.name;
  }

  public int weight() {
    return this.weight;
  }
}
