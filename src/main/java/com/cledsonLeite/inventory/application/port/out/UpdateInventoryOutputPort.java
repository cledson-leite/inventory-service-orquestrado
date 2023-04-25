package com.cledsonLeite.inventory.application.port.out;

import com.cledsonLeite.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {
	
	void update(Inventory inventory);

}
