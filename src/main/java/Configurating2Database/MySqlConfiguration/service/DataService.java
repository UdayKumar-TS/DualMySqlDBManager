package Configurating2Database.MySqlConfiguration.service;

import Configurating2Database.MySqlConfiguration.model.secondary.Order;
import Configurating2Database.MySqlConfiguration.model.primary.User;
import Configurating2Database.MySqlConfiguration.repository.secondary.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Configurating2Database.MySqlConfiguration.repository.primary.UserRepository;

import java.util.List;

@Service
public class DataService {

    private final UserRepository userRepository;
    private  final OrderRepository orderRepository;

    @Autowired
    public DataService(UserRepository userRepository , OrderRepository orderRepository){
        this.userRepository=userRepository;
        this.orderRepository=orderRepository;
    }


    // Handling primary database (User)
    public User addUser(User user){
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Handling secondary database (Order)

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


}
