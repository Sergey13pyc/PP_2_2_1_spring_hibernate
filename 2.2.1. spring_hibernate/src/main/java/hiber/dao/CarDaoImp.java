package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public void findUserCar(String carModel, int carSeries) {
        String HQL = "from Car as car where car.series = :carSeries AND car.model = :carModel";
        Query<Car> query = sessionFactory.getCurrentSession().createQuery(HQL, Car.class);
        query.setParameter("carSeries", carSeries);
        query.setParameter("carModel", carModel);

        Car car = query.uniqueResult();
        System.out.println("Результаты поиска User по автомобилю: ");
        System.out.println(car.toString());
        System.out.println();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listUsers() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car ");
        return query.getResultList();
    }



}
