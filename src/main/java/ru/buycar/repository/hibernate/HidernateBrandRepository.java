package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Brand;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.BrandRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HidernateBrandRepository implements BrandRepository {

    private final BaseCrudRepository baseCrudRepository;

    @Override
    public List<Brand> findAllBrands() {
        return baseCrudRepository.query("FROM Brand", Brand.class);
    }

    @Override
    public Optional<Brand> findBrandById(Long brandId) {
        return baseCrudRepository.optional(
                "FROM Brand WHERE id = :fId", Brand.class,
                Map.of("fId", brandId)
        );
    }

}