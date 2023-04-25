package com.cledsonLeite.inventory.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.inventory.adapter.out.SendUpdateInventoryAdapter;
import com.cledsonLeite.inventory.adapter.out.UpdateInventoryAdapter;
import com.cledsonLeite.inventory.application.core.useCase.DebitInventoryUsecase;
import com.cledsonLeite.inventory.application.core.useCase.FindInventoryByProductIdUseCase;

@Configuration
public class DebitInventoryConfig {
	
	@Bean
	public DebitInventoryUsecase debitInventoryUsecase (
			FindInventoryByProductIdUseCase findInventoryByProductId,
			UpdateInventoryAdapter updateInventoryAdapter,
			SendUpdateInventoryAdapter sendUpdateInventoryAdapter
			) {
		return new DebitInventoryUsecase(
				findInventoryByProductId,
				updateInventoryAdapter,
				sendUpdateInventoryAdapter
				);
	}

}
