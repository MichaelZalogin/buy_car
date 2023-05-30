package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.FuelType;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.FuelTypeRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateFuelTypeRepository implements FuelTypeRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public List<FuelType> findAllFuelTypes() {
        return baseCrudRepository.query("FROM FuelType", FuelType.class);
    }

    @Override
    public Optional<FuelType> findFuelTypeById(Long brandId) {
        return baseCrudRepository.optional(
                "FROM FuelType WHERE id = :fId", FuelType.class,
                Map.of("fId", brandId)
        );
    }

}