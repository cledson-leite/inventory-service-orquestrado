package com.cledsonLeite.inventory.application.port.in;

import com.cledsonLeite.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {
	Inventory find(Integer productId);
}
