package ru.buycar.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.buycar.entity.FuelType;
import ru.buycar.repository.interfaces.FuelTypeRepository;
import ru.buycar.service.interfaces.FuelTypeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ThreadSafe
public class FuelTypeServiceImp implements FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;

    @Override
    public List<FuelType> findAllFuelTypes() {
        return fuelTypeRepository.findAllFuelTypes();
    }

    @Override
    public Optional<FuelType> findFuelTypeById(Long brandId) {
        return fuelTypeRepository.findFuelTypeById(brandId);
    }

}