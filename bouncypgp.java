import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSAGenerator {
    public static void main(String[] args) {
        // Set up parameters for RSA key generation
        RSAKeyPairGenerator rsaKeyPairGenerator = new RSAKeyPairGenerator();
        RSAKeyGenerationParameters rsaKeyGenerationParameters = new RSAKeyGenerationParameters(
                new BigInteger("10001", 16), // public exponent (usually 65537)
                new SecureRandom(), // random number generator
                2048, // key size in bits
                80 // certainty level (should be at least as large as the key size)
        );
        rsaKeyPairGenerator.init(rsaKeyGenerationParameters);

        // Generate RSA keypair
        AsymmetricCipherKeyPair keyPair = rsaKeyPairGenerator.generateKeyPair();
        RSAKeyParameters publicKey = (RSAKeyParameters) keyPair.getPublic();
        RSAKeyParameters privateKey = (RSAKeyParameters) keyPair.getPrivate();

        // Print out the keys
        System.out.println("Public key modulus: " + publicKey.getModulus().toString(16));
        System.out.println("Public key exponent: " + publicKey.getExponent().toString(16));
        System.out.println("Private key modulus: " + privateKey.getModulus().toString(16));
        System.out.println("Private key exponent: " + privateKey.getExponent().toString(16));
    }
}
