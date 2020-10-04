package org.revinton.payapp.persistence.repositories;

import org.revinton.payapp.persistence.entities.Place;

import java.util.List;
import java.util.UUID;

public class PlaceRepository extends AbstractRepository<Place> {

    @Override
    public List<Place> getAll() {
        return executeInTransaction(manager -> manager.createNamedQuery("Place.getAll")
                                                      .getResultList());
    }

    @Override
    public Place get(UUID uuid) {
        return executeInTransaction(manager -> manager.find(Place.class, uuid));
    }

    @Override
    public void remove(Place place) {
        executeInTransaction(manager -> {
            Place toRemove = place;
            if (!manager.contains(place)) {
                toRemove = manager.merge(place);
            }
            manager.remove(toRemove);
            return null;
        });
    }

    @Override
    public void insert(Place place) {
        executeInTransaction(manager -> {
            manager.persist(place);
            return null;
        });
    }
}
