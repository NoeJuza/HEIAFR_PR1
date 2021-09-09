package s19.raid;

// Here we define an "unchecked exception", because a reasonable caller
// of the Disk read/write operation can guarantee that the index is Ok.
public class InvalidIndexException extends IllegalArgumentException {
}
