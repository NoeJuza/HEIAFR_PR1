package s17.moon;

// The expected output for the Simulation is as:
// Running simulation 1000 times for SmallRocket:
//    mean cost: 807.2
//    mean crash probability: 0.007911111111111101
// Running simulation 1000 times for BigRocket:
//    mean cost: 806.13
//    mean crash probability: 0.028130952380952323
//
// The crash probability is computed as the ratio between the number of encountered
// crashes and the number of launches.

public class Simulation {
  // Values computed when running a single simulation.
  private int missionCost;
  private int nbrOfCrashes;
  private int nbrOfLaunches;

  // Enumeration type for the different types of rocket.
  enum RocketType {
    SmallRocket,
    BigRocket
  }

  // Factory method used for creating a Rocket of a given type.
  static Rocket createRocket(RocketType rocketType) {
    // TODO: create the rocket instance of the required type and return it.
    return null;
  }

  // Method for creating the array of items to be moved to the Moon.
  private Item[] createItems() {
    Item[] items = new Item[]{
        new Item("building tool", 2000),
        new Item("building tool", 2000),
        new Item("building tool", 2000),
        new Item("building tool", 2000),
        new Item("building tool", 1000),
        new Item("building tool", 5000),
        new Item("building tool", 3000),
        new Item("building tool", 5000),
        new Item("building tool", 6000),
        new Item("shelter equipment", 5000),
        new Item("construction equipment", 5000),
        new Item("plants", 1000),
        new Item("steel", 8000),
        new Item("books", 1000),
        new Item("water", 5000) };
    return items;
  }

  // Method called for launching a rocket. If the rocket crashes at launch,
  // it must be launched again. In this case, the cost of the crashed rocket
  // must be added to the mission cost.
  private void launchRocket(Rocket rocket) {
    // TODO: implement the method. Hint: you must call rocket.launch() as
    //       many times as requested for a successful launch.
  }

  // Method called for running the simulation for a specific rocket type.
  // Solution with a nested loop.
  private void runSimulation(RocketType rocketType) {
    // Create the list of items to be moved.
    Item[] items = createItems();

    // We iterate over all items, load a rocket and launch it
    // We load as many items as allowed in the rocket.
    // When a rocket crashes at launch, we launch it again.

    // At this point, the mission cost is 0.
    this.missionCost = 0;

    // Count the number of launches and crashes for computing
    // the overall crash probability.
    this.nbrOfLaunches = 0;
    this.nbrOfCrashes = 0;

    // i is the next item index.
    int i = 0;
    while (i < items.length) {
      // Create a rocket of the required type.
      Rocket rocket = createRocket(rocketType);

      // Make sure that the next item can be loaded as a single item
      // in the newly created rocket. This is necessary for preventing
      // an endless loop below.
      if (! rocket.canCarry(items[i])) {
        System.out.println("Item cannot be loaded in any rocket, simulation stops");
        return;
      }

      // TODO: Load the item in the rocket as long as there are items
      //       and that they can be carried in the current rocket.


      // TODO: At this point, the rocket is fully loaded. Launch it.

    }
  }
  
  // Accessors
  private int missionCost() {
    return this.missionCost;
  }

  private int nbrOfCrashes() {
    return this.nbrOfCrashes;
  }

  private int nbrOfLaunches() {
    return this.nbrOfLaunches;
  }

  // Call main for running all simulations.
  public static void main(String[] args) {
    Simulation simulation = new Simulation();
    final int NBR_OF_SIMULATIONS = 1000;

    // run the simulation for all rocket types
    RocketType[] rocketTypes = RocketType.values();

    for (RocketType rocketType : rocketTypes) {
      System.out.println("Running simulation " + NBR_OF_SIMULATIONS +
                         " times for " + rocketType + ":");
      double meanMissionCost = 0;
      double meanCrashProbability = 0.0;

      for (int i = 0; i < NBR_OF_SIMULATIONS; i++) {
        simulation.runSimulation(rocketType);
        meanMissionCost += simulation.missionCost();
        meanCrashProbability += ((double) simulation.nbrOfCrashes() / (double) simulation.nbrOfLaunches());
      }
      meanMissionCost /= NBR_OF_SIMULATIONS;
      meanCrashProbability /= NBR_OF_SIMULATIONS;
      System.out.println(" mean cost: " + meanMissionCost);
      System.out.println(" mean crash probability: " + meanCrashProbability);
    }    
  }
}
