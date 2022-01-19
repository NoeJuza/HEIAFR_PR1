package corr.s20.ex1_moon;

public class SpaceShipFactory {
  public enum SpaceShipKind {
    BIG_ROCKET,
    SMALL_ROCKET,
    SPACE_X
  }

  static SpaceShip createSpaceShip(SpaceShipKind kind) {
    switch (kind) {
      case BIG_ROCKET:
        return new BigRocket();
      case SMALL_ROCKET:
        return new SmallRocket();
      case SPACE_X:
        return new SpaceX();
      default:
        throw new IllegalArgumentException("unknown kind");
    }
  }
}
