package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Color;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.ColorRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateColorRepository implements ColorRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public List<Color> findAllColours() {
        return baseCrudRepository.query("FROM Color", Color.class);
    }

    @Override
    public Optional<Color> findColourById(Long colourId) {
        return baseCrudRepository.optional(
                "FROM Color WHERE id = :fId", Color.class,
                Map.of("fId", colourId)
        );
    }
}
