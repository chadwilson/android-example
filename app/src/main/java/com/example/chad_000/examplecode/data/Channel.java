package com.example.chad_000.examplecode.data;

public class Channel {
    private String title;
    private String description;
    private Integer ttl;
    private Wind wind;
    private Item item;
    private Atmosphere atmosphere;
    private Units units;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }
}
