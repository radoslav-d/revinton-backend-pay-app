package org.revinton.payapp.persistence.entities;

import org.revinton.payapp.core.model.PaymentMethodModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.net.URL;
import java.util.UUID;

@Entity
@Table(name="PaymentMethod")
@NamedQuery(name="PaymentMethod.getAll", query="SELECT m FROM PaymentMethod m")
public class PaymentMethod {

    @Id
    private UUID id;
    private String name;
    private Boolean isDefault;
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

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public void fromModel(PaymentMethodModel model) {
        setId(model.getId());
        setName(model.getName());
        setDefault(model.getDefault());
        setImage(model.getImage());
    }
}
