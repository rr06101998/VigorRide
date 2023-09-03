package com.vigorride.repository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.entity.Role;

@Service
public class RoleRepositoryWrapper {
	
    @Autowired
	private RoleRepository RoleRepository;

    public Set<Role> getByUserId(Long id) {
        return this.RoleRepository.getByUserId(id);
    }

	
}
