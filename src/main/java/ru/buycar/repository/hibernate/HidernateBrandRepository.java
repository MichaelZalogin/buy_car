package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Brand;
import ru.buycar.repository.interfaces.BrandRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HidernateBrandRepository implements BrandRepository {

    @Override
    public List<Brand> findAllBrands() {
        return null;
    }

    @Override
    public Optional<Brand> findBrandById(int brandId) {
        return Optional.empty();
    }

}