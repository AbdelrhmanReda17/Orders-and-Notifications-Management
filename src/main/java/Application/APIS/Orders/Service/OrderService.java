package Application.APIS.Orders.Service;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderProcessors.OrderProcessorFactory;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Orders.OrderRepository;
import Application.APIS.Orders.Model.OrderProcessors.IOrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
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

    public void addOrder(IOrder newOrder) {
        try {
            if(orderRepository.existsById(newOrder.getId())) {
                throw new IllegalStateException("Order with id " + newOrder.getId() + " already exists");
            }
            IOrderProcessor orderProcessor = OrderProcessorFactory.CreateOrderProcessor(newOrder);
            orderProcessor.Process(newOrder , false);
            orderRepository.save(newOrder);
            executorService.schedule(()->shipOrder(newOrder), 10, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
    public void cancelOrder(int id) {
        if(!orderRepository.existsById(id)) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        IOrder order = orderRepository.findById(id);
        if (!order.getStatus().equals(OrderState.Shipped)) {
            orderRepository.deleteById(id);
            return;
        }
        throw new IllegalStateException("Order with id " + id + " is already shipped and Cannot be cancelled");
    }
    public void shipOrder(IOrder order) {
        if(!orderRepository.existsById(order.getId())) {
            throw new IllegalStateException("Order with id " + order.getId() + " does not exist");
        }
        order.setStatus(OrderState.Shipped);
    }
}
