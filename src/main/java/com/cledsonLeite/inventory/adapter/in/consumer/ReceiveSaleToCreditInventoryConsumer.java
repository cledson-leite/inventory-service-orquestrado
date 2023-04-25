package com.cledsonLeite.inventory.adapter.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.cledsonLeite.inventory.adapter.out.message.SaleMessage;
import com.cledsonLeite.inventory.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.inventory.application.port.in.CreditInventoryInputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiveSaleToCreditInventoryConsumer {
	
	@Autowired
	private CreditInventoryInputPort inputPort;
	
	@KafkaListener(topics = "topic-saga-sale", groupId = "inventory-credit")
	public void receive(SaleMessage message) {
		if (SaleEvent.FAILED_PAYMENT.equals(message.getEvent())) {
			log.info("devolvendo mercadoria não vendida ...");
			inputPort.credit(message.getSale());
			log.info("Mercadoria devolvida");
		}
	}


}
