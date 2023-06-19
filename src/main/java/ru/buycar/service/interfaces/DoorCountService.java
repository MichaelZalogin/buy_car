package ru.buycar.service.interfaces;

import ru.buycar.entity.DoorCount;

import java.util.List;
import java.util.Optional;

public interface DoorCountService {

    List<DoorCount> findAllDoorCounts();

    Optional<DoorCount> findDoorCountById(Long doorCountId);

}