package s23;

public class CipherFactory {
  public static final String RSA_ALGO = "RSA";
  public static final String CAESAR_ALGO = "CAESAR";

  public static AsymmetricKeys newKeysForAsymmetricCipher(String algorithm) {
    switch(algorithm) {
      case RSA_ALGO: return RsaKey.newKeyPair();
      default:
        throw new IllegalStateException("Unexpected value: " + algorithm);
    }
  }

  public static CipheringKey newKeyForSymmetricCipher(String algorithm) {
    switch(algorithm) {
      case CAESAR_ALGO: return null;  // TODO
      default:
        throw new IllegalStateException("Unexpected value: " + algorithm);
    }
  }

}
