package ru.buycar.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.buycar.entity.Car;
import ru.buycar.repository.interfaces.CarRepository;
import ru.buycar.service.interfaces.CarService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ThreadSafe
public class CarServiceImp implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.addCar(car);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.updateCar(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteCar(carId);
    }

    @Override
    public Optional<Car> findCarById(Long carId) {
        return carRepository.findCarById(carId);
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAllCars();
    }

    @Override
    public List<Car> findAllCarsByOwnerId(Long ownerId) {
        return carRepository.findAllCarsByOwnerId(ownerId);
    }

}