package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import ru.buycar.entity.Car;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.CarRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HibernateCarRepository implements CarRepository {

    private final BaseCrudRepository baseCrudRepository;

    @Override
    public Car addCar(Car car) {
        baseCrudRepository.run(session -> session.persist(car));
        return car;
    }

    @Override
    public void updateCar(Car car) {
        baseCrudRepository.run(session -> session.merge(car));
    }

    @Override
    public void deleteCar(Long carId) {
        baseCrudRepository.run(
                "DELETE FROM Car WHERE id = :fId",
                Map.of("fId", carId)
        );
    }

    @Override
    public List<Car> findAllCars() {
        return baseCrudRepository.query("FROM Car", Car.class);
    }

    @Override
    public List<Car> findAllCarsByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public Optional<Car> findCarById(Long carId) {
        return baseCrudRepository.optional(
                "FROM Car WHERE id = :fId", Car.class,
                Map.of("fId", carId)
        );
    }

}