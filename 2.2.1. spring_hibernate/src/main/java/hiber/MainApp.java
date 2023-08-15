package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;

import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);


      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 =new User("User2", "Lastname2", "user2@mail.ru");
      User user3 =new User("User3", "Lastname3", "user3@mail.ru");
      User user4 =new User("User4", "Lastname4", "user4@mail.ru");


      Car mazda = new Car(user1,"Mazda", 666 );
      Car honda = new Car(user2, "Honda", 333 );
      Car toyota = new Car(user3, "Toyota", 777 );
      Car nissan = new Car(user4,"Nissan", 111 );
//
//      user1.setUserCar(mazda);
//      user2.setUserCar(honda);
//      user3.setUserCar(toyota);
//      user4.setUserCar(nissan);

      carService.add(mazda);
      carService.add(honda);
      carService.add(toyota);
      carService.add(nissan);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("@mail = "+ user.getEmail());
         System.out.println();
      }



//      userService.getUserAndCarByModelCarAndSeriesCar("Mazda", 666);
//      userService.getUserAndCarByModelCarAndSeriesCar("Honda", 333);
//      userService.getUserAndCarByModelCarAndSeriesCar("Toyota", 777);
//      userService.getUserAndCarByModelCarAndSeriesCar("Nissan", 111);

      carService.findUserCar("Mazda", 666);
      carService.findUserCar("Honda", 333);
      carService.findUserCar("Toyota", 777);
      carService.findUserCar("Nissan", 111);

      context.close();
   }
}
