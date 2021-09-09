
package s19.raid;

// Memory model: an array of bytes
public interface Disk {
  int capacity();

  // Any read-write can cause a breakdown; once the disk is
  // broken, those methods always throw an exception
  byte readAt(int index)             throws DeadDiskException, InvalidIndexException;
  void writeAt(int index, byte data) throws DeadDiskException, InvalidIndexException;
}
