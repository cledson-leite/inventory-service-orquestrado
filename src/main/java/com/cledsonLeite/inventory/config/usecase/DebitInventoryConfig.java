package com.cledsonLeite.inventory.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.inventory.adapter.out.SendMessageToKafkaAdapter;
import com.cledsonLeite.inventory.adapter.out.UpdateInventoryAdapter;
import com.cledsonLeite.inventory.application.core.useCase.DebitInventoryUsecase;
import com.cledsonLeite.inventory.application.core.useCase.FindInventoryByProductIdUseCase;

@Configuration
public class DebitInventoryConfig {
	
	@Bean
	public DebitInventoryUsecase debitInventoryUsecase (
			FindInventoryByProductIdUseCase findInventoryByProductId,
			UpdateInventoryAdapter updateInventoryAdapter,
			SendMessageToKafkaAdapter sendMessageToKafkaAdapter
			) {
		return new DebitInventoryUsecase(
				findInventoryByProductId,
				updateInventoryAdapter,
				sendMessageToKafkaAdapter
				);
	}

}
