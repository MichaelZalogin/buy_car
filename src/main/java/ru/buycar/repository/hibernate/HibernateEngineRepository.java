package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import ru.buycar.entity.Engine;
import ru.buycar.repository.BaseCrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HibernateEngineRepository {

    private final BaseCrudRepository baseCrudRepository;

    public Engine create(Engine engine) {
        baseCrudRepository.run(session -> session.persist(engine));
        return engine;
    }

    public void update(Engine engine) {
        baseCrudRepository.run(session -> session.merge(engine));
    }

    public void delete(Long engineId) {
        baseCrudRepository.run(
                "DELETE FROM Engine WHERE id = :fId",
                Map.of("fId", engineId)
        );
    }

    public List<Engine> findAll() {
        return baseCrudRepository.query("FROM Engine", Engine.class);
    }

    public Optional<Engine> findById(Long engineId) {
        return baseCrudRepository.optional(
                "FROM Engine WHERE id = :fId", Engine.class,
                Map.of("fId", engineId)
        );
    }

}