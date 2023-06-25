package ru.buycar.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.buycar.entity.Model;
import ru.buycar.repository.interfaces.ModelRepository;
import ru.buycar.service.interfaces.ModelService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ThreadSafe
public class ModelServiceImp implements ModelService {

    private final ModelRepository modelRepository;

    @Override
    public List<Model> getAllModelsByBrandId(Long brandId) {
        return modelRepository.getAllModelsByBrandId(brandId);
    }

    @Override
    public Optional<Model> getModelById(Long modelId) {
        return modelRepository.getModelById(modelId);
    }

}