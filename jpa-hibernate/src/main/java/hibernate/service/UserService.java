package hibernate.service;

import hibernate.dao.UserDao;
import hibernate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ufuk on 08-09-15.
 */
@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}
