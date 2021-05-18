package crudapp.dao;

import crudapp.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    public User get(long id);
    List<User> getAll();
    public void update(long id, User user);
    public void delete(long id);
}
