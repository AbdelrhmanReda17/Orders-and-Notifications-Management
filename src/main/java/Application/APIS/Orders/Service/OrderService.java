package Application.APIS.Orders.Service;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderProcessorFactory;
import Application.APIS.Orders.OrderRepository;
import Application.Utilities.OrderProcessors.IOrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public IOrder getOrder(int id) {
        return orderRepository.findById(id);
    }
    public IOrder getUserOrders(int userId) {
         try {
                return orderRepository.findByUserId(userId);
            } catch (Exception e) {
                throw new IllegalStateException("Could not get orders");
         }
    }

    public IOrder addOrder(IOrder newOrder) {
        try {
            IOrderProcessor orderProcessor = OrderProcessorFactory.CreateOrderProcessor(newOrder);
            orderProcessor.Process(newOrder);
            orderRepository.save(newOrder);

        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
        return newOrder;
    }
    public void deleteOrder(int id) {
        if(!orderRepository.existsById(id)) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        orderRepository.deleteById(id);
    }
    public void updateOrder(int id, IOrder newOrder) {
        try{
            IOrder existingOrder = orderRepository.findById(id);
            existingOrder.copy(newOrder);
            orderRepository.save(existingOrder);
        } catch (Exception e) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }

    }
}
