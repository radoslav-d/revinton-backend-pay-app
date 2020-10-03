package org.revinton.payapp.core.model;

import java.net.URL;
import java.util.UUID;

public class OfferModel {

    private UUID id;
    private String name;
    private Double price;
    private URL image;
    private UUID placeId;

    public UUID getId() {
        return id;
    }

    public OfferModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OfferModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public OfferModel setPrice(Double price) {
        this.price = price;
        return this;
    }

    public URL getImage() {
        return image;
    }

    public OfferModel setImage(URL image) {
        this.image = image;
        return this;
    }

    public UUID getPlaceId() {
        return placeId;
    }

    public void setPlaceId(UUID placeId) {
        this.placeId = placeId;
    }
}
