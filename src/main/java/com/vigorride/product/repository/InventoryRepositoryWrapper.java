package com.vigorride.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.product.entity.Inventory;

@Service
public class InventoryRepositoryWrapper {

    @Autowired
    private InventoryRepository inventoryRepository;

    public void save(Inventory inventory) {
        this.inventoryRepository.save(inventory);
    }
    
}
