package com.vigorride.framework.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import lombok.Data;

@Data
public class FileData {

    private File file;
    private String fileName;
    private String contentType;
    private InputStream inputStream;

    public FileData(File file, String fileName, String contentType) {
        this.fileName = fileName;
        this.file = file;
        this.contentType = contentType;
        try {
            this.inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            this.inputStream = null;
        }
    }
}
