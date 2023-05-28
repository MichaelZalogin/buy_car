package ru.buycar.repository.interfaces;

import ru.buycar.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepository {

    List<Brand> findAllBrands();

    Optional<Brand> findBrandById(int brandId);

}