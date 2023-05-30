package ru.buycar.repository.interfaces;

import ru.buycar.entity.Brand;
import ru.buycar.entity.FuelType;

import java.util.List;
import java.util.Optional;

public interface FuelTypeRepository {

    List<FuelType> findAllFuelTypes();

    Optional<FuelType> findFuelTypeById(Long brandId);

}