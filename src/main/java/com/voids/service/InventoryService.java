package com.voids.service;

import com.voids.model.IncomingInventory;
import com.voids.repo.IncomingInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private IncomingInventoryRepository inventoryRepository;

    private static final Long ALERT_THRESHOLD = 10L;

    public List<IncomingInventory> getInventoryStatus() {
        return inventoryRepository.findAll();
    }

    @Scheduled(fixedRate = 600000)
    public void checkInventoryStatusAndGenerateAlert() {
        List<IncomingInventory> inventoryList = inventoryRepository.findAll();
        for (IncomingInventory inventory : inventoryList) {
            if (inventory.getIncomingQuantity() <= ALERT_THRESHOLD) {
                generateAlert("Out of stock alert for product at location: " + inventory.getLocation());
            }
        }
    }

    private void generateAlert(String message) {
        System.out.println("Alert: " + message);
    }

}


