package ru.buycar.repository.interfaces;

import ru.buycar.entity.Transmission;

import java.util.List;
import java.util.Optional;

public interface TransmissionRepository {

    List<Transmission> findAllTransmissions();

    Optional<Transmission> findTransmissionById(Long transmissionId);

}