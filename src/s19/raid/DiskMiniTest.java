
package s19.raid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class DiskMiniTest {

  static final int NUMBER_OF_EXPERIMENTS = 200;
  static final Random RND = new Random();
  static boolean allIsOk = true;

  static byte rndByte() {
    return (byte)(RND.nextInt());
  }

  static Disk demoDiskRaid0(int nDisks) {
    SingleDiskDevice[] disks = new SingleDiskDevice[nDisks];
    for (int i = 0; i < disks.length; i++)
      disks[i] = new SingleDiskDevice();
    return new Raid0(disks);
  }

  static Disk demoDiskRaid1(int nDisks) {
    SingleDiskDevice[] disks = new SingleDiskDevice[nDisks];
    for (int i = 0; i < disks.length; i++)
      disks[i] = new SingleDiskDevice();
    return new Raid1(disks);
  }

  static Disk demoDiskR10() {
    SingleDiskDevice[] disks = new SingleDiskDevice[4];
    for (int i = 0; i < disks.length; i++)
      disks[i] = new SingleDiskDevice();
    Raid r1a = new Raid1(new DiskDevice[]{disks[0], disks[1]});
    Raid r1b = new Raid1(new DiskDevice[]{disks[2], disks[3]});
    Raid r10 = new Raid0(new DiskDevice[]{r1a, r1b});
    return r10;
  }

  static Disk demoDiskR01() {
    SingleDiskDevice[] disks = new SingleDiskDevice[4];
    for (int i = 0; i < disks.length; i++)
      disks[i] = new SingleDiskDevice();
    Raid r0a = new Raid0(new DiskDevice[]{disks[0], disks[1]});
    Raid r0b = new Raid0(new DiskDevice[]{disks[2], disks[3]});
    Raid r01 = new Raid1(new DiskDevice[]{r0a, r0b});
    return r01;
  }

  static long timeToFailure(Disk d) {
    long k = 0;
    boolean isAlive = true;
    byte[] contents = new byte[d.capacity()];
    while(isAlive) {
      k++;
      try {
        applyReadOrWrite(d, contents);
      } catch(DeadDiskException e) {
        isAlive = false;
      }
    }
    return k;
  }

  private static void applyReadOrWrite(Disk d, byte[] contents)
          throws DeadDiskException {
    int index = RND.nextInt(d.capacity());
    boolean isReadOperation = RND.nextBoolean();
    if (isReadOperation) {
      byte b = d.readAt(index);
      byte expected = contents[index];
      if(b != expected)
        throw new IllegalStateException("Oops, bad disk contents...");
    } else {
      byte b = rndByte();
      d.writeAt(index, b);
      contents[index] = b;
    }
  }

  static void miniTest(Supplier<Disk> dp, int expectedCapacity, double expectedMttf) {
    Disk d = dp.get();
    int capacity =  d.capacity();
    boolean capacityOk = (capacity == expectedCapacity);
    if(!capacityOk)
      throw new IllegalStateException(" Oops, capacity is not what was expected");
    List<Long> allTTF = new ArrayList<>();
    for (int i = 0; i < NUMBER_OF_EXPERIMENTS; i++)
      allTTF.add(timeToFailure(dp.get()));
    double mttf = allTTF.stream().mapToDouble(a -> (double)a).average().orElse(-1.0);
    System.out.println("  Mean time (#r/w ops) to failure: " + mttf + ", expected: " + (long)expectedMttf);
    double relativeError = (expectedMttf - mttf) / expectedMttf;  // no abs(), so we accept a better-than-expected mttf!
    double acceptableErrorMargin = 0.20;  // a score 20% too low is rather suspicious (but not totally impossible)...
    boolean mttfOk = (relativeError < acceptableErrorMargin);
    if(!mttfOk) {
      System.out.println(" Oops, mean time-to-failure is not what was expected");
      allIsOk = false;
    }
  }

  public static void main(String[] args) {
    final double singleDeviceBreakdownProbability = (1.0 - SingleDiskDevice.SINGLE_DISK_RELIABILITY);
    // estimations based on experiments; index = number of disks (zero unused)
    final double[] expectedMttfRaid1 = {
            Double.NaN, 9866,  15731, 21548, 25611, 29020, 32092,  34502,  36845,  38526
    };
    int expectedCapacity;
    double expectedMttf;
    for(int i=2; i<4; i++) {
      int nDisks = i;
      expectedCapacity = nDisks * SingleDiskDevice.SINGLE_DISK_CAPACITY;
      expectedMttf = 1.0 / singleDeviceBreakdownProbability;
      System.out.println("\nTrying with a Raid0 with " + nDisks + " disks...");
      miniTest(() -> demoDiskRaid0(nDisks), expectedCapacity, expectedMttf);

      System.out.println("\nTrying with a Raid1 with " + nDisks + " disks...");
      expectedCapacity = SingleDiskDevice.SINGLE_DISK_CAPACITY;
      expectedMttf = expectedMttfRaid1[nDisks];
      miniTest(() -> demoDiskRaid1(nDisks), expectedCapacity, expectedMttf);
    }
    expectedCapacity = 2 * SingleDiskDevice.SINGLE_DISK_CAPACITY;
    expectedMttf = 21500;  // estimation based on experiments
    System.out.println("\nTrying with a Raid10 combination (Raid0 of Raid1)...");
    miniTest(DiskMiniTest::demoDiskR10, expectedCapacity, expectedMttf);

    expectedCapacity = 2 * SingleDiskDevice.SINGLE_DISK_CAPACITY;
    expectedMttf = 16200;   // estimation based on experiments
    System.out.println("\nTrying with a Raid01 combination (Raid1 of Raid0)...");
    miniTest(DiskMiniTest::demoDiskR01, expectedCapacity, expectedMttf);
    if(allIsOk)
      System.out.println("\nAll seems Ok!");
    else
      System.out.println("\nReliability seems problematic; maybe there's a bug...");
  }
}
