package corr.s20.ex1_moon;

public class SmallRocket extends RocketBase {
  private static final int ROCKET_WEIGHT = 10_000;
  private static final int MAX_WEIGHT = 18_000;
  private static final double LAUNCH_EXPLOSION_RISK_BY_ITEM = 0.5;
  private static final int ROCKET_COST = 100;
  private static final double MAX_CRASH_PROBABILITY = 5.0;

  public SmallRocket() {
    super(ROCKET_COST, MAX_WEIGHT - ROCKET_WEIGHT);
  }

  @Override
  public void launch() throws CrashAtLaunchException {
    // compute crash probability at launch (between 0 and 100)
    double prob = LAUNCH_EXPLOSION_RISK_BY_ITEM * this.nbrOfItems;
    prob = Math.min(MAX_CRASH_PROBABILITY, prob);

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

