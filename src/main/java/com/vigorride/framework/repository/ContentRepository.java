package com.vigorride.framework.repository;

import java.io.InputStream;

import com.vigorride.framework.command.DocumentCommand;

public interface ContentRepository {
    
    public String saveFile(InputStream data, DocumentCommand documentCommand);
}
