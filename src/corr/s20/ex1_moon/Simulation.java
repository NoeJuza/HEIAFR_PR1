package corr.s20.ex1_moon;

import static corr.s20.ex1_moon.SpaceShipFactory.SpaceShipKind;
import static corr.s20.ex1_moon.SpaceShipFactory.createSpaceShip;

// ------------------------------------------
// ----- Réponses aux questions posées: -----
// ------------------------------------------
//
// 	Comment est-il possible que la classe RocketBase réalise l'interface SpaceShip
// 	sans que chaque méthode de l'interface ne soit définie dans la classe ?
//
//  Réponse:
//    Pour cela, il est suffisant et nécessaire que la classe RocketBase soit définie comme
//    une classe abstraite. Il faut noter que la classe RocketBase ne définit pas de nouvelle
//    méthode abstraite mais comme elle ne fournit pas la réalisation de la méthode launch() définie
//    dans l'interface SpaceShip, elle doit être déclarée 'abstract'.

// 	Expliquez en quoi il est plus approprié de réaliser une interface que d'utiliser
// 	des classes concrètes dans le programme de simulation.
// 	Serait-il possible de modifier la réalisation de la série 17 afin d'ajouter SpaceX
// 	comme nouveau véhicule spatial ?
//
//  Réponse:
//    L'utilisation d'une interface permet de découpler totalement la réalisation de la classe concrète
//    de son utilisation. En d'autres termes, dans le programme de simulation, nous nous soucions
//    seulement du fait que les objets que nous utilisons réalisent l'interface SpaceShip.
//    Ce concept est plus propre et, comme le démontre le cas du SpaceX, permet d'utiliser
//    dans la simulation des objets dont les classes n'ont pas de parent commun,
//    mais qui réalisent le comportement d'un vaisseau spatial.
//
//    Il est possible de modifier la réalisation de la série 17 et de construire SpaceX comme héritant
//    d'une classe de base. Mais cela force l'héritage d'attributs qui n'appartiennent pas à SpaceX.
//    La construction de la classe de base RocketBase serait déjà "détournée" en forçant l'utilisation
//    de paramètres effectifs "limites".
//
//    C'est un peu comme si on voulait représenter tous les animaux ayant des jambes en
//    prétendant que le serpent a 0 jambes.
//    Dire qu'un serpent a zéro jambes n'est pas faux, mais on doit alors imaginer le comportement d'un
//    serpent qui marche sur zéro jambes...


public class Simulation {
  // Values computed when running a single simulation.
  private int missionCost;
  private int nbrOfCrashes;
  private int nbrOfLaunches;

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
  private void launchSpaceShip(SpaceShip spaceShip) {
    while (true) {
      this.nbrOfLaunches++;
      this.missionCost += spaceShip.cost();
      try {
        spaceShip.launch();
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
  private void runSimulation1(SpaceShipKind spaceShipKind) {
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
    SpaceShip tester = createSpaceShip(spaceShipKind);
    // The carrier is the rocket used to carry goods
    SpaceShip carrier = createSpaceShip(spaceShipKind);
    for (Item item : items) {
      // check if the item alone is too big to fit the rocket
      if (!tester.canCarry(item)) {
        throw new RuntimeException("A single rocket can't carry this item!");
      }
      // If the carrier can't carry the item, then launch the carrier and
      // make a new one. We are sure that the carrier can carry the item
      // because the tester checked it.
      if (!carrier.canCarry(item)) {
        launchSpaceShip(carrier);
        carrier = createSpaceShip(spaceShipKind);
      }
      carrier.carry(item);
    }
    // Launch the last rocket. Unless the items array was empty, we know
    // that the carrier has at least one item.
    launchSpaceShip(carrier);
  }

  // Method called for running the simulation for a specific rocket type.
  // Solution with a nested loop.
  private void runSimulation2(SpaceShipKind spaceShipKind) {
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
      SpaceShip spaceShip = createSpaceShip(spaceShipKind);

      // Make sure that the next item can be loaded as a single item
      // in the newly created rocket. This is necessary for preventing
      // an endless loop below.
      if (! spaceShip.canCarry(items[i])) {
        System.out.println("Item cannot be loaded in any rocket, simulation stops");
        return;
      }

      // Load the item in the rocket as long as there are items
      // and that they can be carried in the current rocket.
      while (i < items.length && spaceShip.canCarry(items[i])) {
        spaceShip.carry(items[i++]);
      }

      // At this point, the rocket is fully loaded. Launch it.
      launchSpaceShip(spaceShip);
    }
  }

  // Accessors.
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
    SpaceShipKind[] spaceShipKinds = SpaceShipKind.values();

    for (SpaceShipKind kind : spaceShipKinds) {
      System.out.println("Running simulation " + NBR_OF_SIMULATIONS +
                         " times for " + kind + ":");
      double meanMissionCost = 0;
      double meanCrashProbability = 0.0;
      for (int i = 0; i < NBR_OF_SIMULATIONS; i++) {
        simulation.runSimulation1(kind);
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
