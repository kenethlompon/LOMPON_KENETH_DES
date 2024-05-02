import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DESExample {

    public static void main(String[] args) throws Exception {
        String plainText = "KENETH LOMPON!";

        // Step 1: Generate a DES key
        String desKey = "secretpa"; // 8 characters for DES
        byte[] keyBytes = desKey.getBytes();

        // Step 2: Create a Cipher instance
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        // Step 3: Convert String to Byte[] Array
        byte[] plainTextBytes = plainText.getBytes();

        // Step 4: Encryption
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Text: " + encryptedText);

        // Step 5: Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
