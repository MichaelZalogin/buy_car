package ru.buycar.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.buycar.entity.Body;
import ru.buycar.repository.interfaces.BodyRepository;
import ru.buycar.service.interfaces.BodyService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ThreadSafe
public class BodyServiceImp implements BodyService {

    private final BodyRepository bodyRepository;

    @Override
    public List<Body> findAllBodies() {
        return bodyRepository.findAllBodies();
    }

    @Override
    public Optional<Body> findBodyById(Long bodyId) {
        return bodyRepository.findBodyById(bodyId);
    }

}