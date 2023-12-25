package Application.APIS.Orders.Service;

import Application.APIS.Orders.Model.Order;
import Application.APIS.Orders.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order getOrder(int id) {
        return orderRepository.findById(id);
    }
    public Order getUserOrders(int userId) {
         try {
                return orderRepository.findByUserId(userId);
            } catch (Exception e) {
                throw new IllegalStateException("Could not get orders");
         }
    }

    public void addOrder(Order newOrder) {
        try {
            orderRepository.save(newOrder);
        } catch (Exception e) {
            throw new IllegalStateException("Order with id " + newOrder.getUserId() + " already exists");
        }
    }
    public void deleteOrder(int id) {
        if(!orderRepository.existsById(id)) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        orderRepository.deleteById(id);
    }
    public void updateOrder(int id, Order newOrder) {
        try{
            Order existingOrder = orderRepository.findById(id);
            existingOrder.copy(newOrder);
            orderRepository.save(existingOrder);
        } catch (Exception e) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }

    }
}
