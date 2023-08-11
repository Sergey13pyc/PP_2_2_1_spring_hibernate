package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
@OneToOne (cascade = CascadeType.ALL)
@JoinColumn(name ="car_series", referencedColumnName = "series")
   private Car userCar;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getUserCar() {
      return userCar;
   }

   public void setUserCar(Car userCar) {
      this.userCar = userCar;
   }

   @Override
   public String toString() {
      return "Результат поиска по " +
              "Автомобилю (" + userCar + "):\n" +
              " ID =" + id + "\n" +
              " First Name ='" + firstName + '\'' + "\n" +
              " Last Name ='" + lastName + '\'' + "\n" +
              " @mail ='" + email + '\''
              ;
   }
}
