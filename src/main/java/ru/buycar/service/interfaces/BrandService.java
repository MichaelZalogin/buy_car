package ru.buycar.service.interfaces;

import ru.buycar.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> findAllBrands();

    Optional<Brand> findBrandById(Long brandId);

}