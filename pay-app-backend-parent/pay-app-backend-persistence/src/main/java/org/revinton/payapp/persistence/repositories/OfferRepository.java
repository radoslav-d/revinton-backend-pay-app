package org.revinton.payapp.persistence.repositories;

import org.revinton.payapp.persistence.entities.Offer;

import java.util.Collection;
import java.util.UUID;

public class OfferRepository extends AbstractRepository<Offer> {

    @Override
    public void insert(Offer model) {
        executeInTransaction(manager -> {
            manager.persist(model);
            return null;
        });
    }

    @Override
    public Collection<Offer> getAll() {
        return executeInTransaction(manager -> manager.createNamedQuery("Offer.getAll")
                                                      .getResultList());
    }

    public Collection<Offer> getByPlaceId(UUID placeId) {
        return executeInTransaction(manager -> manager.createNamedQuery("Offer.Offer.getByPlaceId")
                                                      .setParameter("placeId", placeId)
                                                      .getResultList());
    }

    @Override
    public Offer get(UUID uuid) {
        return executeInTransaction(manager -> manager.find(Offer.class, uuid));
    }

    @Override
    public void remove(Offer model) {
        executeInTransaction(manager -> {
            Offer toRemove = model;
            if (!manager.contains(model)) {
                toRemove = manager.merge(model);
            }
            manager.remove(toRemove);
            return null;
        });
    }
}
