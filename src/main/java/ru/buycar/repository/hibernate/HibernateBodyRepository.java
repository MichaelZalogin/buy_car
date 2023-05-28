package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Body;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.BodyRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateBodyRepository implements BodyRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public List<Body> findAllBodies() {
        return null;
    }

    @Override
    public Optional<Body> findBodyById(int bodyId) {
        return Optional.empty();
    }
}
