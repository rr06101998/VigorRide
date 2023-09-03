package com.vigorride.framework.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.vigorride.framework.command.DocumentCommand;

@Service
public class FileSystemContentRepository implements ContentRepository {

    public String saveFile(InputStream data, DocumentCommand documentCommand) {
        final String fileName = documentCommand.getFileName();
        final String uploadDocumentLocation = generateFileParentDirectory(documentCommand);
        return saveFileWithLocation(fileName, uploadDocumentLocation, data);
    }

    private String generateFileParentDirectory(DocumentCommand documentCommand) {
        final String parentEntityType = documentCommand.getParentEntityType();
        final Long parentEntityId = documentCommand.getParentEntityId();

        return getFileStoragePath() + File.separator + parentEntityType + File.separator + parentEntityId
                + File.separator + java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
    }

    private String getFileStoragePath() {
        return System.getProperty("user.home");
    }

    private String saveFileWithLocation(String fileName, String uploadDocumentLocation, InputStream data) {
        makeDirectory(uploadDocumentLocation);
        final String fileLocation = uploadDocumentLocation + File.separator + fileName;
        writeFileToFileSystem(fileName, data, fileLocation);

        return fileLocation;
    }

    private void makeDirectory(String uploadDocumentLocation) {
        if (!new File(uploadDocumentLocation).isDirectory()) {
            new File(uploadDocumentLocation).mkdirs();
        }
    }

    private void writeFileToFileSystem(String fileName, InputStream data, String fileLocation) {
        try (
                final OutputStream out = new FileOutputStream(new File(fileLocation))) {
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = data.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (final IOException ioException) {

        }
    }
}
