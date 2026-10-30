
package com.quickrelief.demo1.service;

import com.quickrelief.demo1.Supply;
import com.quickrelief.demo1.repository.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    public int addOrRestock(Supply supply) {
        if (supply.getItemName() == null || supply.getItemName().isBlank()) {
            throw new IllegalArgumentException("Item name is required");
        }

        if (supply.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        return supplyRepository.addOrRestock(supply);
    }
}




