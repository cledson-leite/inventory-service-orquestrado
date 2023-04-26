package com.cledsonLeite.inventory.application.core.useCase;


import com.cledsonLeite.inventory.application.core.domain.Inventory;
import com.cledsonLeite.inventory.application.core.domain.Sale;
import com.cledsonLeite.inventory.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.inventory.application.port.in.DebitInventoryInputPort;
import com.cledsonLeite.inventory.application.port.in.FindInventoryByProductIdInputPort;
import com.cledsonLeite.inventory.application.port.out.SendMessageToKafkaOutputPort;
import com.cledsonLeite.inventory.application.port.out.UpdateInventoryOutputPort;

public class DebitInventoryUsecase implements DebitInventoryInputPort{
	
	private FindInventoryByProductIdInputPort findInputPort;
	private UpdateInventoryOutputPort updateInventoryOutputPort;
	private SendMessageToKafkaOutputPort sendUptadeInventoryOutputPort;

	public DebitInventoryUsecase(
			FindInventoryByProductIdInputPort findInputPort,
			UpdateInventoryOutputPort updateInventoryOutputPort,
			SendMessageToKafkaOutputPort sendUptadeInventoryOutputPort
			) {
		this.findInputPort = findInputPort;
		this.updateInventoryOutputPort = updateInventoryOutputPort;
		this.sendUptadeInventoryOutputPort = sendUptadeInventoryOutputPort;
	}

	public void debit(Sale sale) {
		try {
			Inventory inventory = findInputPort.find(sale.getProductId());
			if(inventory.getQuantity() < sale.getQuantity()) {
				throw new RuntimeException("estoque insuficiente");
			}
			Integer updateQuantity = inventory.getQuantity() - sale.getQuantity();
			inventory.setQuantity(updateQuantity);
			updateInventoryOutputPort.update(inventory);
			sendUptadeInventoryOutputPort.send(sale, SaleEvent.INVENTORY_PREPARED);
		} catch (Exception erro) {
			sendUptadeInventoryOutputPort.send(sale, SaleEvent.INVENTORY_ERROR);
		}
		
		
	}
	
	

}
