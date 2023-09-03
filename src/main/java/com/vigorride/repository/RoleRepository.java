package com.vigorride.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Set<Role> getByUserId(Long id);

}
