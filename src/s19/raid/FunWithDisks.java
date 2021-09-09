
package s19.raid;

import java.util.Random;

// Try to solve those little brain-teasers! It's not allowed to create
// new sub-classes (even anonymous) of the 5 Disk classes, nor to modify
// their existing implementation (nor to use reflection or similar black-magic).

public class FunWithDisks {

  static final Random RND = new Random();

  static byte rndByte() {
    return (byte)(RND.nextInt());
  }

  // returns an array of length nDisks
  static SingleDiskDevice[] mysteriousDisks(int nDisks) {
    SingleDiskDevice[] t = new SingleDiskDevice[nDisks];
    for(int i=0; i<nDisks; i++)
      t[i] = new SingleDiskDevice();
    if(nDisks > 1)
      t[1] = t[0];
    return t;
  }

  static DiskDevice strangeCapacityDisk() {
    // TODO
    return new SingleDiskDevice();
  }

  static DiskDevice badDisk() {
    // TODO
    return new SingleDiskDevice();
  }

  static void brainteasers() {
    Disk raid0 = new Raid0(mysteriousDisks(5));
    Disk raid1 = new Raid1(mysteriousDisks(5));
    System.out.println("Is there any problem with this raid0?");
    System.out.println("Is there any problem with this raid1?");

    Disk strangeCapacityDisk = strangeCapacityDisk();
    int rest = strangeCapacityDisk.capacity() % SingleDiskDevice.SINGLE_DISK_CAPACITY;
    System.out.println("Non-zero rest (eg 112): " + rest);

    DiskDevice badDisk = badDisk();
    System.out.println("Now we face a surprising failure...");
    try {
      badDisk.writeAt(0, (byte)0);
      System.out.println("That's not surprising at all...");
    } catch(DeadDiskException | InvalidIndexException | NullPointerException e) {
      System.out.println("Not surprising enough...");
    } catch(Throwable e) {
      System.out.println("That's the bad surprise! \n" + e);
    }
  }

  public static void main(String[] args) {
    brainteasers();
  }

}
