package ru.buycar.repository.interfaces;

import ru.buycar.entity.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    Owner addOwner(Owner owner);

    void updateOwner(Owner owner);

    void deleteOwner(Long ownerId);

    List<Owner> findAllOwners();

    Optional<Owner> findOwnerById(Long ownerId);

    List<Owner> findAllOwnersByCarId(Long carId);

}