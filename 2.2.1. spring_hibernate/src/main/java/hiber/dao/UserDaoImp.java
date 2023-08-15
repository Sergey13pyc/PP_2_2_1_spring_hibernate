package hiber.dao;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {



   private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



//    @Override
//    public void getUserAndCarByModelCarAndSeriesCar(String carModel, int carSeries) {
//        String HQL = "from User as user where user.userCar.series = :carSeries AND user.userCar.model = :carModel";
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(HQL, User.class);
//        query.setParameter("carSeries", carSeries);
//        query.setParameter("carModel", carModel);
//        User user = query.getSingleResult();
//        System.out.println(user.toString());
//        System.out.println();
//    }





   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
