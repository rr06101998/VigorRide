package com.vigorride.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.framework.entity.FileLocation;

public interface FileLocationRepository extends JpaRepository<FileLocation, Long> {

}
