package s23;

// Remember: in cryptography, any "naive" realization like this one
// is useful for pedagogical goals only, and
// must _never_ be considered secure!

import java.security.SecureRandom;

import static s23.SomeMathUtils.*;

// Here we define a class which can represent a public key or a private key
// - note that they both share the same structure, and the same services
// (to transmit a confidential message you cipher with a public key,
// but ciphering with a private key is the basis for digital signature).
public class RsaKey implements CipheringKey {

  // TODO (fields + constructor)

  // Returns a sequence of space-separated base10 numbers, like "345 772 67".
  // The first number (eg 345) will correspond to the encryption of the first
  // character, and so on for the second, third etc.
  @Override
  public String cipher(String msg) {
    return "";  // TODO
  }

  // Receives a sequence of space-separated base10 numbers, like "345 772 67"
  // Each number in this sequence must be extracted and decrypted back as one
  // character.
  @Override
  public String decipher(String encoded) {
    // encoded.split(" ") is useful here...
    return "";  // TODO
  }

  public static AsymmetricKeys newKeyPair() {
    SecureRandom rnd = new SecureRandom();
    // chosen so that if m=getKthPrimeNb(minKth), Character.MAX_VALUE < m*m
    final int minKth = 58;
    // chosen arbitrarily (but ensuring maxPrime*maxPrime doesn't overflow)
    final int maxNbOfPrimesChoices = 1000;
    int pIndex = minKth + rnd.nextInt(maxNbOfPrimesChoices);
    int qIndex = minKth + rnd.nextInt(maxNbOfPrimesChoices);
    long p = getKthPrimeNb(pIndex);
    long q = getKthPrimeNb(qIndex);
    long n = p * q;
    long t = (p - 1) * (q - 1);
    long e = aNumberCoPrimeWith(t);
    long d = moduloInverseNaive(e, t);
    // now the public key is (e, n) and the private key is (d, n)
    return null; // TODO
  }

  // Recomputes the private key from the public key
  public static CipheringKey hackedPrivateKey(CipheringKey publicKey) {
    if(!(publicKey instanceof RsaKey))
      throw new IllegalArgumentException("not an RSA key...");
    RsaKey keyPub = (RsaKey) publicKey;
    return null; // TODO
  }

}
