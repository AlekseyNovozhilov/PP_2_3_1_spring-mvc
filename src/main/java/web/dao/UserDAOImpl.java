package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements Dao {
    @PersistenceContext()
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public User getUserBiId(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void removeUserBiId(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
