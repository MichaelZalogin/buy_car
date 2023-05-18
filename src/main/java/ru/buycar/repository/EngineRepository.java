package ru.buycar.repository;

import lombok.AllArgsConstructor;
import ru.buycar.entity.Engine;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class EngineRepository {

    private final CrudRepository crudRepository;

    public Engine create(Engine engine) {
        crudRepository.run(session -> session.persist(engine));
        return engine;
    }

    public void update(Engine engine) {
        crudRepository.run(session -> session.merge(engine));
    }

    public void delete(Long engineId) {
        crudRepository.run(
                "DELETE FROM Engine WHERE id = :fId",
                Map.of("fId", engineId)
        );
    }

    public List<Engine> findAll() {
        return crudRepository.query("FROM Engine", Engine.class);
    }

    public Optional<Engine> findById(Long engineId) {
        return crudRepository.optional(
                "FROM Engine WHERE id = :fId", Engine.class,
                Map.of("fId", engineId)
        );
    }

}