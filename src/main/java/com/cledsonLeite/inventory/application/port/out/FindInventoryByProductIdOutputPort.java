package com.cledsonLeite.inventory.application.port.out;

import java.util.Optional;

import com.cledsonLeite.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdOutputPort {
	
	Optional<Inventory> find(final Integer productId);

}
