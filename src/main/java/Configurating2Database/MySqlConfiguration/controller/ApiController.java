package Configurating2Database.MySqlConfiguration.controller;

import Configurating2Database.MySqlConfiguration.model.primary.User;
import Configurating2Database.MySqlConfiguration.model.secondary.Order;
import Configurating2Database.MySqlConfiguration.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final DataService dataService;

    @Autowired
    public ApiController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/users")
    public ResponseEntity<User>AddUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(dataService.addUser(user));
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return dataService.getAllUsers();
    }

    @PostMapping("/orders")
    public ResponseEntity<Order>AddOrder(@RequestBody Order order){
        return ResponseEntity.status(HttpStatus.CREATED).body(dataService.addOrder(order));
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return dataService.getAllOrders();
    }
}
