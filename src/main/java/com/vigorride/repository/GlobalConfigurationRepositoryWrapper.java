package com.vigorride.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.entity.GlobalConfiguration;

@Service
public class GlobalConfigurationRepositoryWrapper {
	
    @Autowired
	private GlobalConfigurationRepository globalConfigurationRepository;

    public Optional<GlobalConfiguration> findByName(String name) {
        return this.globalConfigurationRepository.findByName(name);
    }

	

}
