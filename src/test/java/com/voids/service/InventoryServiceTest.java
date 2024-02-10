package com.voids.service;

import com.voids.model.IncomingInventory;
import com.voids.repo.IncomingInventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

    @Mock
    private IncomingInventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    private List<IncomingInventory> testInventoryList;

    private final String LOCATION_HAMBURG = "HAMBURG";

    private final String LOCATION_MUNICH = "MUNICH";
    LocalDateTime localDateTime = LocalDateTime.of(2024, 2, 10, 12, 0);

    @BeforeEach
    void setUp() {
        testInventoryList = new ArrayList<>();

        testInventoryList.add(new IncomingInventory(1L, localDateTime, LOCATION_HAMBURG, 5L));
        testInventoryList.add(new IncomingInventory(2L, localDateTime, LOCATION_MUNICH, 15L));
    }

    @Test
    void getInventoryStatus_ReturnsAllInventory() {
        when(inventoryRepository.findAll()).thenReturn(testInventoryList);

        List<IncomingInventory> result = inventoryService.getInventoryStatus();

        assertEquals(testInventoryList.size(), result.size());
        assertEquals(testInventoryList, result);
    }


}

