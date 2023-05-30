package ru.buycar.repository.interfaces;

import ru.buycar.entity.Body;

import java.util.List;
import java.util.Optional;

public interface BodyRepository {

    List<Body> findAllBodies();

    Optional<Body> findBodyById(Long bodyId);

}
