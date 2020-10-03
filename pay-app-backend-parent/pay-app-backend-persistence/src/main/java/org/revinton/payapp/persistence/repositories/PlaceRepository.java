package org.revinton.payapp.persistence.repositories;

import org.revinton.payapp.persistence.entities.Place;

import java.util.List;

public class PlaceRepository extends AbstractRepository {

    public List<Place> getAll() {
        return executeInTransaction(manager -> manager.createNamedQuery("Place.getAll")
                                                      .getResultList());
    }
}
