package corr.s17.moon;

public class Rocket {
  protected final long cargoLimit;
  protected long cargoWeight = 0;
  protected int nbrOfItems = 0;
  private final int cost;

  public Rocket(int cost, int cargoLimit) {
    this.cost = cost;
    this.cargoLimit = cargoLimit;
  }

  public boolean canCarry(Item item) {
    return (this.cargoWeight + item.weight() <= this.cargoLimit);
  }

  public void carry(Item item) {
    if (!canCarry(item)) {
      throw new IllegalArgumentException("Cannot load item");
    }
    this.cargoWeight += item.weight();
    this.nbrOfItems++;
  }

  public int cost() {
    return cost;
  }

  // This method must be overridden by inheriting classes for a proper behavior.
  // We throw an exception for forcing inheriting classes to implement these methods.
  // The launch() method throws a RunTimeException if the rocket crashes at launch.
  public void launch() throws CrashAtLaunchException {
    throw new RuntimeException("Not implemented");
  }

}

