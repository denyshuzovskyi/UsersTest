package ua.com.brdo.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.brdo.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
