package crudapp.dao;

import crudapp.models.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class JpaUserDaoImpl implements UserDao {
    @PersistenceContext(unitName = "emf")
    EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);

    }

    @Override
    public User getById(long id) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u  where u.id=:id", User.class);
        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    public User getByUsername(String username) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u  where u.username=:username", User.class);
        q.setParameter("username", username);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void update(long id, User updateUser) {
        User userToBeUpdater = getById(id);
        userToBeUpdater.setName(updateUser.getName());
        userToBeUpdater.setLastName(updateUser.getLastName());
        userToBeUpdater.setEmail(updateUser.getEmail());

    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
