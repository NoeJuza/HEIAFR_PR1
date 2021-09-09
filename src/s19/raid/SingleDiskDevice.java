
package s19.raid;

public final class SingleDiskDevice extends DiskDevice {
  public static final double SINGLE_DISK_RELIABILITY = 1.0 - 1E-4;
  public static final int SINGLE_DISK_CAPACITY = 1_000;

  private final double reliability;
  private final byte[] buffer;
  
  private SingleDiskDevice(double operationReliability, int capacity) {
    super();
    this.reliability = operationReliability;
    this.buffer = new byte[capacity];
  }

  public SingleDiskDevice() {
    this(SINGLE_DISK_RELIABILITY, SINGLE_DISK_CAPACITY);
  }

  private void mightFail() throws DeadDiskException {
    if(Math.random() < reliability) return;
    this.causeFatalDamage();
  }

  @Override
  public int capacity() {
    return buffer.length;
  }

  @Override
  public byte readAt(int index) throws DeadDiskException, InvalidIndexException {
    throwIfInvalidIndex(index);
    throwIfDead();
    mightFail();
    return buffer[index];
  }

  @Override
  public void writeAt(int index, byte data) throws DeadDiskException, InvalidIndexException {
    throwIfInvalidIndex(index);
    throwIfDead();
    mightFail();
    buffer[index] = data;
  }

}
