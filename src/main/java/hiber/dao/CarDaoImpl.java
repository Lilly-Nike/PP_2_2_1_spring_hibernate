package hiber.dao;

import hiber.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.save(car);
    }

    @Override
    public List<Car> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Car", Car.class).getResultList();
    }
}
