package org.revinton.payapp.persistence.entities;

import org.revinton.payapp.core.model.OfferModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.net.URL;
import java.util.UUID;

@Entity
@Table(name="Offer")
@NamedQuery(name="Offer.getAll", query="SELECT o FROM Offer o")
@NamedQuery(name = "Offer.getByPlaceId", query = "SELECT o FROM Offer o WHERE o.placeId = :placeId")
public class Offer {

    @Id
    private UUID id;
    private String name;
    private Double price;
    private URL image;
    private UUID placeId;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public UUID getPlaceId() {
        return placeId;
    }

    public void setPlaceId(UUID placeId) {
        this.placeId = placeId;
    }

    public static Offer of(OfferModel model) {
        Offer offer = new Offer();
        offer.setId(model.getId());
        offer.setName(model.getName());
        offer.setPrice(model.getPrice());
        offer.setImage(model.getImage());
        offer.setPlaceId(model.getPlaceId());
        return offer;
    }
}
