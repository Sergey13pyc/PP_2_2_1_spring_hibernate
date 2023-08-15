package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);


      CarService carService = context.getBean(CarService.class);


      Car mazda = new Car(new User("User1", "Lastname1", "user1@mail.ru"),
              "Mazda", 666);
      Car honda = new Car(new User("User2", "Lastname2", "user2@mail.ru"),
              "Honda", 333);
      Car toyota = new Car(new User("User3", "Lastname3", "user3@mail.ru"),
              "Toyota", 777);
      Car nissan = new Car(new User("User4", "Lastname4", "user4@mail.ru"),
              "Nissan", 111);


      carService.add(mazda);
      carService.add(honda);
      carService.add(toyota);
      carService.add(nissan);

      List<Car> users = carService.listUsers();
      for (Car user : users) {
         System.out.println("User: " + "\n" + user.getUser());
         System.out.println("Car:");
         System.out.println(" Model = " + user.getModel() + " Series = " + user.getSeries());
         System.out.println();
      }


      carService.findUserCar("Mazda", 666);
      carService.findUserCar("Honda", 333);
      carService.findUserCar("Toyota", 777);
      carService.findUserCar("Nissan", 111);

      context.close();
   }
}
