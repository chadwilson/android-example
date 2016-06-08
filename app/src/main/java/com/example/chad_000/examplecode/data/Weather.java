package com.example.chad_000.examplecode.data;


public class Weather {
    private Query query;

    public Weather() {}

    public Weather(Query query) {
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
