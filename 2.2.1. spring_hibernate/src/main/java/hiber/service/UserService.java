package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void getUserAndCarByModelCarAndSeriesCar(String carModel, int carSeries);
    void add(User user);
    List<User> listUsers();
}
