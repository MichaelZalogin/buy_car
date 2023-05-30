package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Body;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.BodyRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateBodyRepository implements BodyRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public List<Body> findAllBodies() {
        return baseCrudRepository.query("FROM Body", Body.class);
    }

    @Override
    public Optional<Body> findBodyById(Long bodyId) {
        return baseCrudRepository.optional(
                "FROM Body WHERE id = :fId", Body.class,
                Map.of("fId", bodyId)
        );
    }

}