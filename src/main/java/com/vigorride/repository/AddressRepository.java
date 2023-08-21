package com.vigorride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
