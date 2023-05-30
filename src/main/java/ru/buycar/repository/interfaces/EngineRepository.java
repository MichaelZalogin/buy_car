package ru.buycar.repository.interfaces;

import ru.buycar.entity.Engine;

import java.util.List;
import java.util.Optional;

public interface EngineRepository {

    Engine addEngine(Engine engine);

    void updateEngine(Engine engine);

    void deleteEngine(Long engineId);

    Optional<Engine> findEngineById(Long engineId);

    List<Engine> findAllEngines();

}