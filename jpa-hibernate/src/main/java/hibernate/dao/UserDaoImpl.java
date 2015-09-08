package hibernate.dao;

import hibernate.models.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Ufuk on 08-09-15.
 */
@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

    public void save(User user) {
        super.persist(user);
    }

    public void delete(User user) {
        super.delete(user);
    }

    public void update(User user) {
        super.update(user);
    }
}
