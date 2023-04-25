package com.cledsonLeite.inventory.config.kafka;

import com.cledsonLeite.inventory.adapter.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializer implements Serializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String string, SaleMessage saleMessage) {
        try {
            if (saleMessage == null){
                return null;
            }
            return objectMapper.writeValueAsBytes(saleMessage);
        } catch (Exception error) {
            throw new SerializationException("Erro ao serializar SaleMessage para byte[]");
        }
    }


}
