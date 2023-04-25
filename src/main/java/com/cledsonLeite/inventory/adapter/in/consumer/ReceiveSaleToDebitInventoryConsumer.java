package com.cledsonLeite.inventory.adapter.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.cledsonLeite.inventory.adapter.out.message.SaleMessage;
import com.cledsonLeite.inventory.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.inventory.application.port.in.DebitInventoryInputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

	@Autowired
	private DebitInventoryInputPort inputPort;

	@KafkaListener(topics = "topic-saga-sale", groupId = "inventory-debit")
	public void receive(SaleMessage message) {
		if (SaleEvent.CREATED_SALE.equals(message.getEvent())) {
			log.info("Separando mercadorias ...");
			inputPort.debit(message.getSale());
			log.info("Mercadoria separada");
		}
	}

}
