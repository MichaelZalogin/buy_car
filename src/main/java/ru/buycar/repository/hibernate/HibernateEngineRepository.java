package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Engine;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.EngineRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateEngineRepository implements EngineRepository {

    private final BaseCrudRepository baseCrudRepository;

    @Override
    public Engine addEngine(Engine engine) {
        baseCrudRepository.run(session -> session.persist(engine));
        return engine;
    }

    @Override
    public void updateEngine(Engine engine) {
        baseCrudRepository.run(session -> session.merge(engine));
    }

    @Override
    public void deleteEngine(Long engineId) {
        baseCrudRepository.run(
                "DELETE FROM Engine WHERE id = :fId",
                Map.of("fId", engineId)
        );
    }

    @Override
    public List<Engine> findAllEngines() {
        return baseCrudRepository.query("FROM Engine", Engine.class);
    }

    @Override
    public Optional<Engine> findEngineById(Long engineId) {
        return baseCrudRepository.optional(
                "FROM Engine WHERE id = :fId", Engine.class,
                Map.of("fId", engineId)
        );
    }

}