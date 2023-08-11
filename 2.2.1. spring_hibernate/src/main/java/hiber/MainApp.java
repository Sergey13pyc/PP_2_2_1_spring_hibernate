package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
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


      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 =new User("User2", "Lastname2", "user2@mail.ru");
      User user3 =new User("User3", "Lastname3", "user3@mail.ru");
      User user4 =new User("User4", "Lastname4", "user4@mail.ru");


      Car mazda = new Car("Mazda", 666 );
      Car honda = new Car("Honda", 333 );
      Car toyota = new Car("Toyota", 777 );
      Car nissan = new Car("Nissan", 111 );

      user1.setUserCar(mazda);
      user2.setUserCar(honda);
      user3.setUserCar(toyota);
      user4.setUserCar(nissan);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("@mail = "+ user.getEmail());
         System.out.println("Car = "+user.getUserCar());
         System.out.println();
      }



      userService.getUserAndCarByModelCarAndSeriesCar("Mazda", 666);
      userService.getUserAndCarByModelCarAndSeriesCar("Honda", 333);
      userService.getUserAndCarByModelCarAndSeriesCar("Toyota", 777);
      userService.getUserAndCarByModelCarAndSeriesCar("Nissan", 111);

      context.close();
   }
}
