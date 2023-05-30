package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.DoorCount;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.DoorCountRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateDoorCountRepository implements DoorCountRepository {

    BaseCrudRepository baseCrudRepository;

    @Override
    public List<DoorCount> findAllDoorCounts() {
        return null;
    }

    @Override
    public Optional<DoorCount> findDoorCountById(Long doorCountId) {
        return Optional.empty();
    }

}