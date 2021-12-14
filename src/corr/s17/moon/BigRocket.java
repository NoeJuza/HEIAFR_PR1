package corr.s17.moon;

public class BigRocket extends Rocket {
  private static final int ROCKET_WEIGHT = 18_000;
  private static final int MAX_WEIGHT = 29_000;
  private static final double LAUNCH_EXPLOSION_RISK = 4.0;
  private static final int ROCKET_COST = 130;

  public BigRocket() {
    super(ROCKET_COST, MAX_WEIGHT - ROCKET_WEIGHT);
  }

  @Override
  public void launch() throws CrashAtLaunchException {
    // compute crash probability at launch (between 0 and 100)
    double prob = LAUNCH_EXPLOSION_RISK * ((double) this.cargoWeight / (double) this.cargoLimit);

    // use a random number for computing the chance of explosion
    double rand = Math.random() * 100.0;

    // crash happens if prob is larger than rand
    // e.g. for a probability of 3%, rand has to be between 0 and 3 (out of 100)
    // for a crash to happen
    if (prob > rand) {
      throw new CrashAtLaunchException();
    }
  }

}

