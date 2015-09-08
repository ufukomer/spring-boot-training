package hibernate.dao;

import hibernate.models.User;

/**
 * Created by Ufuk on 08-09-15.
 */
public interface UserDao {

    void save(User user);

    void delete(User user);

    void update(User user);
}
