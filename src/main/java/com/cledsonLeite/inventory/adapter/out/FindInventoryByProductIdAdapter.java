package com.cledsonLeite.inventory.adapter.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cledsonLeite.inventory.adapter.out.repository.InventoryRepository;
import com.cledsonLeite.inventory.adapter.out.repository.mapper.InventoryEntityMapper;
import com.cledsonLeite.inventory.application.core.domain.Inventory;
import com.cledsonLeite.inventory.application.port.out.FindInventoryByProductIdOutputPort;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort{

	@Autowired
	private InventoryRepository repository;
	
	@Autowired
	private InventoryEntityMapper mapper;
	
	@Override
	public Optional<Inventory> find(Integer productId) {
		var entity = repository.findByProductId(productId);
		return entity.map( item -> mapper.toInventory(item));
	}

}
