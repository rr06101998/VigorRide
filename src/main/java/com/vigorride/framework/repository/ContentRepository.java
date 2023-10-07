package com.vigorride.framework.repository;

import java.io.InputStream;

import com.vigorride.framework.command.DocumentCommand;
import com.vigorride.framework.data.DocumentData;
import com.vigorride.framework.data.FileData;

public interface ContentRepository {

    public String saveFile(InputStream data, DocumentCommand documentCommand);

    public FileData fetchFile(DocumentData documentData);

}
