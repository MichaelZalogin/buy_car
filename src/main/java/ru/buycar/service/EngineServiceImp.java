package ru.buycar.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.buycar.entity.Engine;
import ru.buycar.repository.interfaces.EngineRepository;
import ru.buycar.service.interfaces.EngineService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ThreadSafe
public class EngineServiceImp implements EngineService {

    private final EngineRepository engineRepository;

    @Override
    public Engine addEngine(Engine engine) {
        return engineRepository.addEngine(engine);
    }

    @Override
    public void updateEngine(Engine engine) {
        engineRepository.updateEngine(engine);
    }

    @Override
    public void deleteEngine(Long engineId) {
        engineRepository.deleteEngine(engineId);
    }

    @Override
    public Optional<Engine> findEngineById(Long engineId) {
        return engineRepository.findEngineById(engineId);
    }

    @Override
    public List<Engine> findAllEngines() {
        return engineRepository.findAllEngines();
    }

}