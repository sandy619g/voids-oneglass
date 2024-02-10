package com.voids.repo;

import com.voids.model.IncomingInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingInventoryRepository extends JpaRepository<IncomingInventory, Long> {
}


