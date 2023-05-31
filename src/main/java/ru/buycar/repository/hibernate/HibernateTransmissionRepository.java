package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Transmission;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.TransmissionRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateTransmissionRepository implements TransmissionRepository {

    private final BaseCrudRepository baseCrudRepository;

    @Override
    public List<Transmission> findAllTransmissions() {
        return baseCrudRepository.query("FROM Transmission", Transmission.class);
    }

    @Override
    public Optional<Transmission> findTransmissionById(Long transmissionId) {
        return baseCrudRepository.optional(
                "FROM Transmission WHERE id = :fId", Transmission.class,
                Map.of("fId", transmissionId)
        );
    }

}