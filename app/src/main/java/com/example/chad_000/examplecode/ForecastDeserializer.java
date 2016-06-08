package com.example.chad_000.examplecode;

import com.example.chad_000.examplecode.data.Forecast;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.List;

public class ForecastDeserializer extends JsonDeserializer<List<Forecast>> {

    @Override
    public List<Forecast> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        InnerForecasts innerItems = jp.readValueAs(InnerForecasts.class);

        return innerItems.elements;
    }

    private static class InnerForecasts {
        public List<Forecast> elements;
    }
}
