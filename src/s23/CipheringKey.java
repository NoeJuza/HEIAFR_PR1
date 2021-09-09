package s23;

public interface CipheringKey {
  String cipher(String msg);
  String decipher(String encoded);
}
