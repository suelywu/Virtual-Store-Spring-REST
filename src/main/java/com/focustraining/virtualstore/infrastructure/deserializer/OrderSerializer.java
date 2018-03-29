package com.focustraining.virtualstore.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.focustraining.virtualstore.domain.model.entity.Client;
import com.focustraining.virtualstore.domain.model.entity.Order;
import com.focustraining.virtualstore.domain.repository.ClientRepository;
import com.focustraining.virtualstore.infrastructure.serializer.ClientSerializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class OrderSerializer extends JsonSerializer<Order> {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        ClientSerializer clientSerializer = new ClientSerializer();
        jsonGenerator.writeFieldName("client");
        jsonGenerator = clientSerializer.serialize2Order(clientRepository.findById(order.getClientId()),jsonGenerator);

        jsonGenerator.writeObjectField("dateTime", order.getDateTime());

        jsonGenerator.writeFieldName("productHolders");

        jsonGenerator.writeFieldName("payment");

        jsonGenerator.writeEndObject();
        jsonGenerator.flush();
        jsonGenerator.close();
    }
}
