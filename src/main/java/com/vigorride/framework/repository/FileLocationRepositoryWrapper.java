package com.vigorride.framework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.framework.entity.FileLocation;

@Service
public class FileLocationRepositoryWrapper {

    @Autowired
    private FileLocationRepository fileLocationRepository;

    public FileLocation save(FileLocation fileLocation) {
        return this.fileLocationRepository.save(fileLocation);
    }

}
