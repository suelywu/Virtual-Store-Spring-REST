package com.focustraining.virtualstore.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.focustraining.virtualstore.domain.model.entity.Client;

import java.io.IOException;

public class ClientDeserializer extends JsonDeserializer<Client> {


    @Override
    public Client deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {



        return null;
    }
}
