package Finanzas05.Finanzas.user.infrastructure.repositories.jpa;

import Finanzas05.Finanzas.user.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User getUserByUsernameAndPassword(String username, String password);
}
