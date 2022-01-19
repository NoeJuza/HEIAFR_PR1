package corr.s20.ex1_moon;

public abstract class RocketBase implements SpaceShip {
  protected final long cargoLimit;
  protected long cargoWeight = 0;
  protected int nbrOfItems = 0;
  private final int cost;

  public RocketBase(int cost, int cargoLimit) {
    this.cost = cost;
    this.cargoLimit = cargoLimit;
  }

  @Override
  public boolean canCarry(Item item) {
    return (this.cargoWeight + item.weight() <= this.cargoLimit);
  }

  @Override
  public void carry(Item item) {
    if (! canCarry(item)) {
      throw new IllegalArgumentException("Cannot load item");
    }
    this.cargoWeight += item.weight();
    this.nbrOfItems++;
  }

  @Override
  public int cost() {
    return cost;
  }
}

