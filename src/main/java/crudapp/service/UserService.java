package crudapp.service;

import crudapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    public List<User> getAll();
    public User get(long id);
    public void add(User user);
    public void update(long id, User user);
    public void delete(long id);
}
