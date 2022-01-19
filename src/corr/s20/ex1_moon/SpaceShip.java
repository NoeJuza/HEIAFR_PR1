package corr.s20.ex1_moon;

public interface SpaceShip {
  // The launch() method throws a RunTimeException if the rocket crashes at launch.
  void launch() throws CrashAtLaunchException;
  // returns true if the rocket can carry such item
  // or false if it will exceed the weight limit
  boolean canCarry(Item item);
  // takes an Item object and updates the current weight of the rocket
  // implementation throws an exception if the item cannot be carried
  void carry(Item item);
  // returns the cost of the space ship
  int cost();
}
