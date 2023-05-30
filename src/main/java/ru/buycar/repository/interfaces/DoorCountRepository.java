package ru.buycar.repository.interfaces;

import ru.buycar.entity.DoorCount;

import java.util.List;
import java.util.Optional;

public interface DoorCountRepository {

    List<DoorCount> findAllDoorCounts();

    Optional<DoorCount> findDoorCountById(Long doorCountId);

}