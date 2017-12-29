package per.fyh.springbootdemo.service;

import org.springframework.stereotype.Service;
import per.fyh.springbootdemo.domain.User;

import java.util.List;


public interface UserService {
    List<User> getUserList();

    User findUserById(int id);

    void save(User user);

    void edit(User user);

    void delete(int id);
}
