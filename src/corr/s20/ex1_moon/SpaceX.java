package corr.s20.ex1_moon;

// This company has very different commercial conditions: the ship itself has
// no weight limit (!), and the cost is proportional to the weight (plus 
// an initial constant cost).

public class SpaceX implements SpaceShip {
  protected long cargoWeight = 0;

  private static final double LAUNCH_EXPLOSION_CHANCE = 0.7;
  private static final int BASE_COST = 200;
  private static final double COST_PER_WEIGHT = 0.01;

  public SpaceX() { }

  @Override
  public boolean canCarry(Item item) {
    return true;
  }

  @Override
  public void carry(Item item) {
    this.cargoWeight += item.weight();
  }

  @Override
  public void launch() throws CrashAtLaunchException {
    // use a random number for computing the chance of explosion
    double rand = Math.random() * 100.0;

    // crash happens if prob is larger than rand
    // e.g. for a probability of 3%, rand has to be between 0 and 3 (out of 100)
    // for a crash to happen
    if (rand < LAUNCH_EXPLOSION_CHANCE) {
      throw new CrashAtLaunchException();
    }
  }

  @Override
  public int cost() {
    return (int) (BASE_COST + cargoWeight * COST_PER_WEIGHT);
  }
}

