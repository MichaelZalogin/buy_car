package ru.buycar.service.interfaces;

import ru.buycar.entity.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {

    public List<Model> getAllModelsByBrandId(Long brandId);

    public Optional<Model> getModelById(Long modelId);

}