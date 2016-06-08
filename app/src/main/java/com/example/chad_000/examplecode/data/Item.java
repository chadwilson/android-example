package com.example.chad_000.examplecode.data;

import com.example.chad_000.examplecode.ForecastDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class Item {

    @JsonProperty("forecast")
    private List<Forecast> forecasts;
    private Condition condition;

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}

