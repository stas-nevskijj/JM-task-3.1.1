package ru.nevski.JMtask311.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.nevski.JMtask311.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDAOImpl implements UserDAO {

//    private final SessionFactory sessionFactory;

//    @Autowired
//    public PersonDAO(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void save(User person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public void update(int id, User updatedPerson) {
        User user = entityManager.find(User.class, id);
        user.setAge(updatedPerson.getAge());
        user.setName(updatedPerson.getName());
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
