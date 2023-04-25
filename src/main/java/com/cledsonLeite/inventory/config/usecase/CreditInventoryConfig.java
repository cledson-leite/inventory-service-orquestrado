package com.cledsonLeite.inventory.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.inventory.adapter.out.SendMessageToKafkaAdapter;
import com.cledsonLeite.inventory.adapter.out.UpdateInventoryAdapter;
import com.cledsonLeite.inventory.application.core.useCase.CreditInventoryUsecase;
import com.cledsonLeite.inventory.application.core.useCase.FindInventoryByProductIdUseCase;

@Configuration
public class CreditInventoryConfig {
	
	@Bean
	public CreditInventoryUsecase creditInventoryUsecase(
			FindInventoryByProductIdUseCase findIUsecase,
			UpdateInventoryAdapter updateInventoryAdapter,
			SendMessageToKafkaAdapter sendUptadeInventoryAdapter
			) {
		return new CreditInventoryUsecase(
				findIUsecase,
				updateInventoryAdapter,
				sendUptadeInventoryAdapter
				);
	}

}
