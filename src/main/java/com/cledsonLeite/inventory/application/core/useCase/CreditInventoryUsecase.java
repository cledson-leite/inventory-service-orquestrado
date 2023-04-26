package com.cledsonLeite.inventory.application.core.useCase;

import com.cledsonLeite.inventory.application.core.domain.Inventory;
import com.cledsonLeite.inventory.application.core.domain.Sale;
import com.cledsonLeite.inventory.application.port.in.CreditInventoryInputPort;
import com.cledsonLeite.inventory.application.port.in.FindInventoryByProductIdInputPort;
import com.cledsonLeite.inventory.application.port.out.UpdateInventoryOutputPort;

public class CreditInventoryUsecase implements CreditInventoryInputPort{
	
	private FindInventoryByProductIdInputPort findInputPort;
	private UpdateInventoryOutputPort updateInventoryOutputPort;
	
	
	
	public CreditInventoryUsecase(FindInventoryByProductIdInputPort findInputPort,
			UpdateInventoryOutputPort updateInventoryOutputPort
			) {
		this.findInputPort = findInputPort;
		this.updateInventoryOutputPort = updateInventoryOutputPort;
	}



	public void credit(Sale sale){
		Inventory inventory = findInputPort.find(sale.getProductId());
		Integer updateQuantity = inventory.getQuantity() + sale.getQuantity();
		inventory.setQuantity(updateQuantity);
		updateInventoryOutputPort.update(inventory);
	}

}
