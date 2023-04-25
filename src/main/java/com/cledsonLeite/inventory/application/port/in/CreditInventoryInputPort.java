package com.cledsonLeite.inventory.application.port.in;

import com.cledsonLeite.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {
	void credit(Sale sale);
}
