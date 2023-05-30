package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.DoorCount;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.DoorCountRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateDoorCountRepository implements DoorCountRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public List<DoorCount> findAllDoorCounts() {
        return baseCrudRepository.query("FROM DoorCount", DoorCount.class);
    }

    @Override
    public Optional<DoorCount> findDoorCountById(Long doorCountId) {
        return baseCrudRepository.optional(
                "FROM DoorCount WHERE id = :fId", DoorCount.class,
                Map.of("fId", doorCountId)
        );
    }

}