package ru.buycar.repository;

import lombok.AllArgsConstructor;
import ru.buycar.entity.Owner;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class OwnerRepository {

    CrudRepository crudRepository;

    public Owner create(Owner owner) {
        crudRepository.run(session -> session.persist(owner));
        return owner;
    }

    public void update(Owner owner) {
        crudRepository.run(session -> session.merge(owner));
    }

    public void delete(Long ownerId) {
        crudRepository.run(
                "DELETE FROM Owner WHERE id = :fId",
                Map.of("fId", ownerId)
        );
    }

    public List<Owner> findAll() {
        return crudRepository.query("FROM Owner", Owner.class);
    }

    public Optional<Owner> findById(int ownerId) {
        return crudRepository.optional(
                "FROM Owner WHERE id = :fId", Owner.class,
                Map.of("fId", ownerId)
        );
    }

}