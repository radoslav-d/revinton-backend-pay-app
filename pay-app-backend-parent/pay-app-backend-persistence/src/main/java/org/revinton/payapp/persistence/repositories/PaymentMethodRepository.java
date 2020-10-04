package org.revinton.payapp.persistence.repositories;

import org.revinton.payapp.persistence.entities.PaymentMethod;

import java.util.Collection;
import java.util.UUID;

public class PaymentMethodRepository extends AbstractRepository<PaymentMethod> {

    @Override
    public void insert(PaymentMethod model) {
        executeInTransaction(manager -> {
            manager.persist(model);
            return null;
        });
    }

    @Override
    public Collection<PaymentMethod> getAll() {
        return executeInTransaction(manager -> manager.createNamedQuery("PaymentMethod.getAll")
                                                      .getResultList());
    }

    @Override
    public PaymentMethod get(UUID uuid) {
        return executeInTransaction(manager -> manager.find(PaymentMethod.class, uuid));
    }

    @Override
    public void remove(PaymentMethod model) {
        executeInTransaction(manager -> {
            PaymentMethod toRemove = model;
            if (!manager.contains(model)) {
                toRemove = manager.merge(model);
            }
            manager.remove(toRemove);
            return null;
        });
    }
}
