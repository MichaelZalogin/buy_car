package ru.buycar.service.interfaces;

import ru.buycar.entity.FuelType;

import java.util.List;
import java.util.Optional;

public interface FuelTypeService {

    List<FuelType> findAllFuelTypes();

    Optional<FuelType> findFuelTypeById(Long brandId);

}