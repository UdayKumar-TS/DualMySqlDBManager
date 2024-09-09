package Configurating2Database.MySqlConfiguration.repository.primary;

import Configurating2Database.MySqlConfiguration.model.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
