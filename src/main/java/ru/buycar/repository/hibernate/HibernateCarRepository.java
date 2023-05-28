package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import ru.buycar.entity.Car;
import ru.buycar.repository.BaseCrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HibernateCarRepository {

    private final BaseCrudRepository baseCrudRepository;

    public Car create(Car car) {
        baseCrudRepository.run(session -> session.persist(car));
        return car;
    }

    public void update(Car car) {
        baseCrudRepository.run(session -> session.merge(car));
    }

    public void delete(Long carId) {
        baseCrudRepository.run(
                "DELETE FROM Car WHERE id = :fId",
                Map.of("fId", carId)
        );
    }

    public List<Car> findAll() {
        return baseCrudRepository.query("FROM Car", Car.class);
    }

    public Optional<Car> findById(Long carId) {
        return baseCrudRepository.optional(
                "FROM Car WHERE id = :fId", Car.class,
                Map.of("fId", carId)
        );
    }

}