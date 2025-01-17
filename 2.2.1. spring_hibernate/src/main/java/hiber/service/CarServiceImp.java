package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {
    private final CarDao carDao;

    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }


    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);

    }

    @Transactional
    @Override
    public void findUserCar(String carModel, int carSeries) {
        carDao.findUserCar(carModel, carSeries);
    }

    @Transactional
    @Override
    public List<Car> listUsers() {
        return carDao.listUsers();
    }
}
