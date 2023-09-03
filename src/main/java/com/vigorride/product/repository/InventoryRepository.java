package com.vigorride.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.product.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{


}
