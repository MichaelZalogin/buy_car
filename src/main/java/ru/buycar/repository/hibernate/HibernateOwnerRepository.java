package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Owner;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.OwnerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateOwnerRepository implements OwnerRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public Owner addOwner(Owner owner) {
        baseCrudRepository.run(session -> session.persist(owner));
        return owner;
    }

    @Override
    public void updateOwner(Owner owner) {
        baseCrudRepository.run(session -> session.merge(owner));
    }

    @Override
    public void deleteOwner(Long ownerId) {
        baseCrudRepository.run(
                "DELETE FROM Owner WHERE id = :fId",
                Map.of("fId", ownerId)
        );
    }

    @Override
    public List<Owner> findAllOwners() {
        return baseCrudRepository.query("FROM Owner", Owner.class);
    }

    @Override
    public Optional<Owner> findOwnerById(Long ownerId) {
        return baseCrudRepository.optional(
                "FROM Owner WHERE id = :fId", Owner.class,
                Map.of("fId", ownerId)
        );
    }

    @Override
    public List<Owner> findAllOwnersByCarId(Long carId) {
        return null;
    }

}