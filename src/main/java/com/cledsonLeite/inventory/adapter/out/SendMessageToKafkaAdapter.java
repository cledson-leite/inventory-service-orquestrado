package com.cledsonLeite.inventory.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.cledsonLeite.inventory.adapter.out.message.SaleMessage;
import com.cledsonLeite.inventory.application.core.domain.Sale;
import com.cledsonLeite.inventory.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.inventory.application.port.out.SendMessageToKafkaOutputPort;

public class SendMessageToKafkaAdapter implements SendMessageToKafkaOutputPort{

	@Autowired
	private KafkaTemplate<String, SaleMessage> template;
	
	@Override
	public void send(Sale sale, SaleEvent event) {
		SaleMessage message = new SaleMessage(sale, event);
		template.send("topic-saga-sale", message);
		
	}

}
