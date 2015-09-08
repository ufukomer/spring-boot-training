package hibernate.service;

import hibernate.models.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Ufuk on 08-09-15.
 */
public interface UserRepository extends Repository<User, Long> {

    List<User> findAll();
}
