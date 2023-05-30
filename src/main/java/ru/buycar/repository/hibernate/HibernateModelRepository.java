package ru.buycar.repository.hibernate;

import org.springframework.stereotype.Repository;
import ru.buycar.entity.Model;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.ModelRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateModelRepository implements ModelRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public List<Model> getAllModelsByBrandId(Long brandId) {
        return null;
    }

    @Override
    public Optional<Model> getModelById(Long modelId) {
        return Optional.empty();
    }

}