package Application.APIS.Orders.Service;

import Application.APIS.Orders.Model.Order;
import Application.APIS.Orders.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order getOrder(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order with id " + id + " does not exist"));
    }
    public List<Order> getUserOrders(String userId) {
         try {
                return orderRepository.findByUserId(userId);
            } catch (Exception e) {
                return Collections.emptyList();
         }
    }

    public void addOrder(Order newOrder) {
        try {
            orderRepository.save(newOrder);
        } catch (Exception e) {
            throw new IllegalStateException("Order with id " + newOrder.getUserId() + " already exists");
        }
    }
    public void deleteOrder(String id) {
        if(!orderRepository.existsById(id)) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        orderRepository.deleteById(id);
    }
    public void updateOrder(String id, Order newOrder) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order with id " + id + " does not exist"));
        existingOrder.copy(newOrder);
        orderRepository.save(existingOrder);
    }
}
