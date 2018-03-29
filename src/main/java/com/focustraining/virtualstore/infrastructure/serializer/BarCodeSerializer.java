package com.focustraining.virtualstore.infrastructure.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.focustraining.virtualstore.domain.model.valueObject.payment.BarCode;

import java.io.IOException;
import java.util.List;

public class BarCodeSerializer extends JsonSerializer<BarCode> {
    @Override
    public void serialize(BarCode barCode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<String> barCodeString = barCode.getBarCode();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("field1", barCodeString.get(0));
        jsonGenerator.writeObjectField("field2", barCodeString.get(1));
        jsonGenerator.writeObjectField("field3", barCodeString.get(2));
        jsonGenerator.writeObjectField("field4", barCodeString.get(3));
        jsonGenerator.writeObjectField("total", barCode.getTotal());
        jsonGenerator.writeEndObject();
        jsonGenerator.flush();
        jsonGenerator.close();
    }

    public JsonGenerator serialize2Billet(BarCode barCode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<String> barCodeString = barCode.getBarCode();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("field1", barCodeString.get(0));
        jsonGenerator.writeObjectField("field2", barCodeString.get(1));
        jsonGenerator.writeObjectField("field3", barCodeString.get(2));
        jsonGenerator.writeObjectField("field4", barCodeString.get(3));
        jsonGenerator.writeObjectField("total", barCode.getTotal());
        jsonGenerator.writeEndObject();
        return jsonGenerator;
    }
}
