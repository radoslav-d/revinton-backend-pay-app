package org.revinton.payapp.persistence.entities;

import org.revinton.payapp.core.model.PlaceModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.net.URL;
import java.util.UUID;

@Entity
@Table(name="Place")
@NamedQuery(name="Place.getAll", query="SELECT p FROM Place p")
public class Place {

    @Id
    private UUID id;
    private String name;
    private String address;
    private Double rating;
    private URL image;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public static Place of(PlaceModel model) {
        Place place = new Place();
        place.setId(model.getId());
        place.setName(model.getName());
        place.setAddress(model.getAddress());
        place.setRating(model.getRating());
        place.setImage(model.getImage());
        return place;
    }
}
