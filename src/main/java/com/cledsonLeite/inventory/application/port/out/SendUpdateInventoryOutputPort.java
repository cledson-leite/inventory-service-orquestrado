package com.cledsonLeite.inventory.application.port.out;

import com.cledsonLeite.inventory.application.core.domain.Sale;
import com.cledsonLeite.inventory.application.core.domain.enums.SaleEvent;

public interface SendUpdateInventoryOutputPort {
	
	void send(Sale sale, SaleEvent event);

}
