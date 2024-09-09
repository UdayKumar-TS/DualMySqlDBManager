package Configurating2Database.MySqlConfiguration.repository.secondary;


import Configurating2Database.MySqlConfiguration.model.secondary.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
