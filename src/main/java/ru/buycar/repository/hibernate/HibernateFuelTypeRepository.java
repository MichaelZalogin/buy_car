package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.FuelType;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.FuelTypeRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateFuelTypeRepository implements FuelTypeRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public List<FuelType> findAllFuelTypes() {
        return null;
    }

    @Override
    public Optional<FuelType> findFuelTypeById(Long brandId) {
        return Optional.empty();
    }

}