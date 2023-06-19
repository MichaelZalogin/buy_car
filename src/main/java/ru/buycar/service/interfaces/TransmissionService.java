package ru.buycar.service.interfaces;

import ru.buycar.entity.Transmission;

import java.util.List;
import java.util.Optional;

public interface TransmissionService {

    List<Transmission> findAllTransmissions();

    Optional<Transmission> findTransmissionById(Long transmissionId);

}