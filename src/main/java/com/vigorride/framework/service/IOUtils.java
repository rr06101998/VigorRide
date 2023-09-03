package com.vigorride.framework.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

@Component
public class IOUtils {
    
    public byte[] read(final File file) throws IOException {
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            final byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        } finally {
            closeQuietly(ous);
            closeQuietly(ios);
        }
        return ous.toByteArray();
    }

    public byte[] read(final String string) throws IOException {
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            ous = new ByteArrayOutputStream();
            ios = new ByteArrayInputStream(string.getBytes("UTF-8"));
            final byte[] buffer = new byte[4096];
            int read;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        } finally {
            closeQuietly(ous);
            closeQuietly(ios);
        }
        return ous.toByteArray();
    }

    // Helper method to close streams quietly
    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Log or handle the exception as needed
            }
        }
    }
}
