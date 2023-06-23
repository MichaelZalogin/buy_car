package ru.buycar.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.buycar.entity.DoorCount;
import ru.buycar.service.interfaces.DoorCountService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ThreadSafe
public class DoorCountServiceImp implements DoorCountService {

    private final DoorCountService doorCountService;

    @Override
    public List<DoorCount> findAllDoorCounts() {
        return doorCountService.findAllDoorCounts();
    }

    @Override
    public Optional<DoorCount> findDoorCountById(Long doorCountId) {
        return doorCountService.findDoorCountById(doorCountId);
    }

}