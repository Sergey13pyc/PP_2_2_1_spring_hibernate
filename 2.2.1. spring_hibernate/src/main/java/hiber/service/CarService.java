package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    void add(Car car);

    void findUserCar(String carModel, int carSeries);

    List<Car> listUsers();
}
