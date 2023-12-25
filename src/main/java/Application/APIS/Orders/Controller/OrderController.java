package Application.APIS.Orders.Controller;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/orders")
public class OrderController {
    private final OrderService orderService;
    // private final Notification ntf;
    @Autowired
    public OrderController(OrderService orderService ) {
        this.orderService = orderService;
    }
    @GetMapping("/byUser/{userId}")
    public ResponseEntity<Object> getUserOrders(@PathVariable("userId") int userId) {
        try{
            return ResponseEntity.ok(orderService.getUserOrders(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(orderService.getOrder(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/")
    public ResponseEntity<String> addOrder(@RequestBody IOrder order) {
        try {
            orderService.addOrder(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Order added successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") int id) {
        try{
            orderService.deleteOrder(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Order deleted successfully");
    }
}



