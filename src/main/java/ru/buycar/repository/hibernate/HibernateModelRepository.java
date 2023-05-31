package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Model;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.ModelRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HibernateModelRepository implements ModelRepository {

    private final BaseCrudRepository baseCrudRepository;

    @Override
    public List<Model> getAllModelsByBrandId(Long brandId) {
        return baseCrudRepository.query("FROM Model", Model.class);
    }

    @Override
    public Optional<Model> getModelById(Long modelId) {
        return baseCrudRepository.optional(
                "FROM Model WHERE id = :fId", Model.class,
                Map.of("fId", modelId)
        );
    }

}