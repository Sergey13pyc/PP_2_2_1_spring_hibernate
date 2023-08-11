package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {

    void getUserAndCarByModelCarAndSeriesCar(String carModel, int carSeries);



      void add(User user);
   List<User> listUsers();
}
