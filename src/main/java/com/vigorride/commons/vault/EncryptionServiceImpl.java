package com.vigorride.commons.vault;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.entity.GlobalConfiguration;
import com.vigorride.repository.GlobalConfigurationRepositoryWrapper;

@Service
public class EncryptionServiceImpl implements EncryptionService{

    @Autowired
    private   GlobalConfigurationRepositoryWrapper nedkjw;

    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final int KEY_SIZE = 128; // 128-bit key
    // private  final String ENCRYPTION_KEY =fetchEcryptionKey();//"jdfbuhjbrjdwjdgf"; // Should be kept secure

    // private   String fetchEcryptionKey() {
    //     // Optional<GlobalConfiguration> globalConfiguration=this.nedkjw.findByName("secret_key");
    //     // return globalConfiguration.get().getValue();
    //     return "asdfghjkasdfghfg";
    // }

    @Override
    public String encrypt(String plaintext) throws Exception {
        Optional<GlobalConfiguration> globalConfiguration=this.nedkjw.findByName("secret_key");   

        SecretKey secretKey = generateSecretKey(globalConfiguration.get().getValue());
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        return encryptedText;
    }

    

    @Override
    public String decrypt(String encryptedText) throws Exception {
        Optional<GlobalConfiguration> globalConfiguration=this.nedkjw.findByName("secret_key");   
        SecretKey secretKey = generateSecretKey(globalConfiguration.get().getName());
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);

        return decryptedText;
    }

    private SecretKey generateSecretKey(String key) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ENCRYPTION_ALGORITHM);
        keyGenerator.init(KEY_SIZE);
        return new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ENCRYPTION_ALGORITHM);
    }
}
