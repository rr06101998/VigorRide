package com.vigorride.commons.vault;

public interface EncryptionService {
    public String encrypt(String plaintext) throws Exception;
    public String decrypt(String encryptedText) throws Exception;
}
