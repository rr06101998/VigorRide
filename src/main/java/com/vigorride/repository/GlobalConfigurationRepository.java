package com.vigorride.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.entity.GlobalConfiguration;

public interface GlobalConfigurationRepository extends JpaRepository<GlobalConfiguration,Long> {

    Optional<GlobalConfiguration> findByName(String name);

}
