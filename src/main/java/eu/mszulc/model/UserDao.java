package eu.mszulc.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
    List<User> findByEmailStartsWithIgnoreCase(String email);

}