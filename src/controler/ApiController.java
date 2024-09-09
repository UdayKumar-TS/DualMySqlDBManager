package controler;

import model.Order;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DataService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final DataService dataService;

    @Autowired
    public ApiController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return dataService.getAllUsers();
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return dataService.getAllOrders();
    }
}

