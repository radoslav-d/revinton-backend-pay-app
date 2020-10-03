package org.revinton.payapp.core.model;

import java.net.URL;
import java.util.UUID;

public class PaymentMethodModel {

    private UUID id;
    private String name;
    private Boolean isDefault;
    private URL image;

    public UUID getId() {
        return id;
    }

    public PaymentMethodModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaymentMethodModel setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public PaymentMethodModel setDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public URL getImage() {
        return image;
    }

    public PaymentMethodModel setImage(URL image) {
        this.image = image;
        return this;
    }
}
