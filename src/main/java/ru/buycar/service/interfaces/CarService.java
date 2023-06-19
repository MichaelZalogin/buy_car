package ru.buycar.service.interfaces;

import ru.buycar.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car addCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long carId);

    Optional<Car> findCarById(Long carId);

    List<Car> findAllCars();

    List<Car> findAllCarsByOwnerId(Long ownerId);

}