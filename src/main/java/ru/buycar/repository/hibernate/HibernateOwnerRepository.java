package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import ru.buycar.entity.Owner;
import ru.buycar.repository.BaseCrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HibernateOwnerRepository {

    BaseCrudRepository baseCrudRepository;

    public Owner create(Owner owner) {
        baseCrudRepository.run(session -> session.persist(owner));
        return owner;
    }

    public void update(Owner owner) {
        baseCrudRepository.run(session -> session.merge(owner));
    }

    public void delete(Long ownerId) {
        baseCrudRepository.run(
                "DELETE FROM Owner WHERE id = :fId",
                Map.of("fId", ownerId)
        );
    }

    public List<Owner> findAll() {
        return baseCrudRepository.query("FROM Owner", Owner.class);
    }

    public Optional<Owner> findById(int ownerId) {
        return baseCrudRepository.optional(
                "FROM Owner WHERE id = :fId", Owner.class,
                Map.of("fId", ownerId)
        );
    }

}