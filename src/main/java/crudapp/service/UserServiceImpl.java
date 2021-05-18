package crudapp.service;

import crudapp.dao.UserDao;
import crudapp.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    final
    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User get(long id) {
        return userDao.get(id);
    }


    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void add(User user) {
        userDao.add(user);

    }

    @Override
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
