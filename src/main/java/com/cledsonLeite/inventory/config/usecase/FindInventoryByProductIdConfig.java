package com.cledsonLeite.inventory.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.inventory.adapter.out.FindInventoryByProductIdAdapter;
import com.cledsonLeite.inventory.application.core.useCase.FindInventoryByProductIdUseCase;

@Configuration
public class FindInventoryByProductIdConfig {

	@Bean
	public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
			FindInventoryByProductIdAdapter findInventoryByProductIdAdapter) {
		return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
	}

}
