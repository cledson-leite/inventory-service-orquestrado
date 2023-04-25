package com.cledsonLeite.inventory.adapter.out.repository.mapper;

import org.mapstruct.Mapper;

import com.cledsonLeite.inventory.adapter.out.repository.entity.InventoryEntity;
import com.cledsonLeite.inventory.application.core.domain.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {
	Inventory toInventory(InventoryEntity entity);
	InventoryEntity toEntity(Inventory inventory);

}
