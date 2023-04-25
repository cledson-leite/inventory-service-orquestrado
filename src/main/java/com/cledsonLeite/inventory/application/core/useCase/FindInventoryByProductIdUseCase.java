package com.cledsonLeite.inventory.application.core.useCase;

import com.cledsonLeite.inventory.application.core.domain.Inventory;
import com.cledsonLeite.inventory.application.port.in.FindInventoryByProductIdInputPort;
import com.cledsonLeite.inventory.application.port.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort{

	private FindInventoryByProductIdOutputPort findOutput;

	public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutputPort findOutput) {
		super();
		this.findOutput = findOutput;
	}

	@Override
	public Inventory find(Integer productId) {

		return findOutput
				.find(productId)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado no estoque!"));

	}

}
