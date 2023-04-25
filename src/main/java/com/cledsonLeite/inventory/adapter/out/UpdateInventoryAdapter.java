package com.cledsonLeite.inventory.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cledsonLeite.inventory.adapter.out.repository.InventoryRepository;
import com.cledsonLeite.inventory.adapter.out.repository.entity.InventoryEntity;
import com.cledsonLeite.inventory.adapter.out.repository.mapper.InventoryEntityMapper;
import com.cledsonLeite.inventory.application.core.domain.Inventory;
import com.cledsonLeite.inventory.application.port.out.UpdateInventoryOutputPort;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

	@Autowired
	private InventoryRepository repository;
	
	@Autowired
	private InventoryEntityMapper mapper;
	
	@Override
	public void update(Inventory inventory) {
		InventoryEntity entity = mapper.toEntity(inventory);
		repository.save(entity);
	}

}
