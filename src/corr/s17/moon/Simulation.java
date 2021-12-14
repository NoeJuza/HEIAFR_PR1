package corr.s17.moon;

// ------------------------------------------
// ----- Réponses aux questions posées: -----
// ------------------------------------------
//
//  5a: Est-il possible d’instancier des objets de la classe de base Rocket ?
//      Si oui, est-ce souhaitable ?
//
//  Oui, il est possible de créer des objets de la classe de base Rocket.
//  Il n'y a pas de raison syntaxique empêchant de créer une instance de cette
//  classe et il serait pourtant souhaitable que ce soit interdit. La raison est
//  qu'au moins la méthode launch() de la classe Rocket réalise le comportement
//  "not implemented" en levant une exception. [cf. notion de "classe abstraite"
//  à voir dans un prochain chapitre]
//
//  5b: quel sera le résultat de la simulation si l’on utilise des objets de la
//      classe de base ?
//
//  Une exception sera levée à l'appel de la méthode launch() de la classe
//  Rocket. Cette exception n'est probablement pas traitée et l'exécution
//  s'interrompra. Cela illustre le fait qu'il n'est pas souhaitable
//  de pouvoir créer des instance de Rocket.
//
//	5c: Sur la base des connaissances acquises jusque-là, existe-t-il un autre
//      moyen de réaliser le polymorphisme souhaité ?
//
//  Si on souhaite pouvoir manipuler des instances de Rocket (qui sont soit des
//  SmallRocket, soit des BigRocket) comme dans le programme Simulation,
//  l'existence d'une classe Rocket dont héritent SmallRocket et BigRocket est
//  requise.
//
//  5d: Comment réaliser le comportement souhaité sans héritage ?
//      Quels seraient les avantages et désavantages d'une telle approche ?
//
//  Il serait possible que la classe Rocket soit utilisée par agrégation dans
//  SmallRocket et BigRocket. Dans ce cas, les deux classes utilisent une
//  instance de Rocket à laquelle elle délègue certaines méthodes. Les deux
//  classes n'héritent donc pas de la classe de base mais appellent des méthodes
//  de cette classe.
//  Un des défauts reconnu de l'héritage est le fait que lors de la redéfinition
//  (override) d'une méthode, des malentendus peuvent survenir quant aux
//  hypothèses sur l'état interne de la classe mère. Et des modifications
//  dans la classe mère peuvent avoir des effets secondaires dans les classes
//  qui héritent.
//  (Il faudrait illustrer avec un exemple, mais ça sort un peu du cadre de
//  ce cours...).
//
//  A part ça, il semble dommage ici de perdre le "lien de parenté" naturel
//  entre BigRocket et SmallRocket, qui sont bien deux spécialisations d'un
//  concept commun.

// --------------------------------------------
// The expected output for the Simulation is as:
// Running simulation 1000 times for SmallRocket:
//    mean cost: 807.2
//    mean crash probability: 0.007911111111111101
// Running simulation 1000 times for BigRocket:
//    mean cost: 806.13
//    mean crash probability: 0.028130952380952323

// The crash probability is computed as the ratio between the number of
// encountered crashes and the number of launches.

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
  // [Note that this method, together with the enum, is the only place in
  //  Simulation where there is a dependency to the concrete classes
  //  SmallRocket/BigRocket]
  private static Rocket createRocket(RocketType rocketType) {
    return rocketType == RocketType.BigRocket ? new BigRocket() : new SmallRocket();
  }

  // Method called for creating the array of items to be moved to the Moon.
  private Item[] createItems() {
    Item[] items = new Item[]{
      // SmallRocket 1
      // BigRocket 1
      new Item("building tool", 2000),
      new Item("building tool", 2000),
      new Item("building tool", 2000),
      new Item("building tool", 2000),
      // SmallRocket 2
      new Item("building tool", 1000),
      // BigRocket 2
      new Item("building tool", 5000),
      // SmallRocket 3
      new Item("building tool", 3000),
      // BigRocket 3
      new Item("building tool", 5000),
      // SmallRocket 4
      new Item("building tool", 6000),
      // SmallRocket 5
      // BigRocket 4
      new Item("shelter equipment", 5000),
      // SmallRocket 6
      new Item("construction equipment", 5000),
      // BigRocket 5
      new Item("plants", 1000),
      // SmallRocket 7
      new Item("steel", 8000),
      // SmallRocket 8
      new Item("books", 1000),
      // BigRocket 6
      new Item("water", 5000) };
    return items;
  }

  // Method called for launching a rocket. If the rocket crashes at launch,
  // it must be launched again. In this case, the cost of the crashed rocket
  // must be added to the mission cost.
  private void launchRocket(Rocket rocket) {
    while (true) {
      this.nbrOfLaunches++;
      this.missionCost += rocket.cost();
      try {
        rocket.launch();
        break;
      } catch (CrashAtLaunchException e) {
        // This rocket crashed at launch.
        // Since we need to move the items that were
        // loaded on this rocket, reuse the same rocket instance
        // for the next launch.
        this.nbrOfCrashes++;
      }
    }
  }

  // For running the simulation, we consider that the rocket is fully loaded
  // when the current item cannot be loaded.
  // This algorithm is sub-optimal, since we should at least try to load
  // another remaining lighter item and even enumerate all possible
  // combinations for choosing the minimal number of rockets.
  // For the sake of simplicity, we do not optimize the algorithm.
  //
  // Method called for running the simulation for a specific rocket type.
  // Solution with a single loop.
  private void runSimulation1(RocketType rocketType) {
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

    // The tester is a rocket of type "rocketType" made to check if an item
    // is too big to fit the rocket
    Rocket tester = createRocket(rocketType);
    // The carrier is the rocket used to carry goods
    Rocket carrier = createRocket(rocketType);
    for (Item item : items) {
      // check if the item alone is too big to fit the rocket
      if (!tester.canCarry(item)) {
        throw new RuntimeException("A single rocket can't carry this item!");
      }
      // If the carrier can't carry the item, then launch the carrier and
      // make a new one. We are sure that the carrier can carry the item
      // because the tester checked it.
      if (!carrier.canCarry(item)) {
        launchRocket(carrier);
        carrier = createRocket(rocketType);
      }
      carrier.carry(item);
    }
    // Launch the last rocket. Unless the items array was empty, we know
    // that the carrier has at least one item.
    launchRocket(carrier);
  }

  // Method called for running the simulation for a specific rocket type.
  // Solution with a nested loop.
  private void runSimulation2(RocketType rocketType) {
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

      // Load the item in the rocket as long as there are items
      // and that they can be carried in the current rocket.
      while (i < items.length && rocket.canCarry(items[i])) {
        rocket.carry(items[i++]);
      }

      // At this point, the rocket is fully loaded. Launch it.
      launchRocket(rocket);
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
        simulation.runSimulation1(rocketType);
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
