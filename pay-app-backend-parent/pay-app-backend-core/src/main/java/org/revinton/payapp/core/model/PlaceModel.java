package org.revinton.payapp.core.model;

import java.net.URL;
import java.util.UUID;

public class PlaceModel {

    private UUID id;
    private String name;
    private String address;
    private Double rating;
    private URL image;

    public UUID getId() {
        return id;
    }

    public PlaceModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlaceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PlaceModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public PlaceModel setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public URL getImage() {
        return image;
    }

    public PlaceModel setImage(URL image) {
        this.image = image;
        return this;
    }

}
