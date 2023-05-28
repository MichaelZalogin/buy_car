package ru.buycar.repository;

import lombok.AllArgsConstructor;
import ru.buycar.entity.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class CarRepository {

    private final CrudRepository crudRepository;

    public Car create(Car car) {
        crudRepository.run(session -> session.persist(car));
        return car;
    }

    public void update(Car car) {
        crudRepository.run(session -> session.merge(car));
    }

    public void delete(Long carId) {
        crudRepository.run(
                "DELETE FROM Car WHERE id = :fId",
                Map.of("fId", carId)
        );
    }

    public List<Car> findAll() {
        return crudRepository.query("FROM Car", Car.class);
    }

    public Optional<Car> findById(Long carId) {
        return crudRepository.optional(
                "FROM Car WHERE id = :fId", Car.class,
                Map.of("fId", carId)
        );
    }

}