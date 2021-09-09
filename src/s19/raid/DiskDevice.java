
package s19.raid;

public abstract class DiskDevice implements Disk {
  private boolean isAlive;

  protected DiskDevice() {
    isAlive = true;
  }

  protected void causeFatalDamage() throws DeadDiskException {
    isAlive = false;
    throw new DeadDiskException();
  }

  protected void throwIfInvalidIndex(int index) throws InvalidIndexException {
    if(index<0 || index>this.capacity())
      throw new InvalidIndexException();
  }

  protected void throwIfDead() throws DeadDiskException {
    if(!isAlive) throw new DeadDiskException();
  }
}
