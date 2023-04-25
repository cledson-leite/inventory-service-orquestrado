package com.cledsonLeite.inventory.adapter.out.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cledsonLeite.inventory.adapter.out.repository.entity.InventoryEntity;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer>{

	Optional<InventoryEntity> findByProductId(Integer productId);
}
