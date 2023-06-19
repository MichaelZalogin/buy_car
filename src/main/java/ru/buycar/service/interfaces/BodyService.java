package ru.buycar.service.interfaces;

import ru.buycar.entity.Body;

import java.util.List;
import java.util.Optional;

public interface BodyService {

    List<Body> findAllBodies();

    Optional<Body> findBodyById(Long bodyId);

}