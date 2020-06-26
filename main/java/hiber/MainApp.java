package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");


      Car car = new Car("BMW",6);
      Car car2 = new Car("Audi",4);
      Car car3 = new Car("Ford",5);
      Car car4 = new Car("Mercedec",4);

      user.setCar(car);
      car.setUser(user);
      user2.setCar(car2);
      car2.setUser(user2);
      user3.setCar(car3);
      car3.setUser(user3);
      user4.setCar(car4);
      car4.setUser(user4);

      userService.add(user);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

//      userService.add(newUser);
//
//      User hgh = userService.getUserByNameAndSeries(car);
//      System.out.println(hgh.getFirstName());
//      System.out.println("------------------------");




      List<User> users = userService.listUsers();
      int count = 0;
      for (User us : users) {

         System.out.println("Id = "+us.getId());
         System.out.println("First Name = "+us.getFirstName());
         System.out.println("Last Name = "+us.getLastName());
         System.out.println("Email = "+us.getEmail());
         System.out.println("Car = "+us.getCar().getName());
      }

      User userTest = userService.getUserByNameAndSeries(car2);
      System.out.println("Audi = " + userTest.getFirstName());

      context.close();
   }
}
