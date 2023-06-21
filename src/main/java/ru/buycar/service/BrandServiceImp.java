package ru.buycar.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.buycar.entity.Brand;
import ru.buycar.repository.interfaces.BrandRepository;
import ru.buycar.service.interfaces.BrandService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ThreadSafe
public class BrandServiceImp implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> findAllBrands() {
        return brandRepository.findAllBrands();
    }

    @Override
    public Optional<Brand> findBrandById(Long brandId) {
        return brandRepository.findBrandById(brandId);
    }

}