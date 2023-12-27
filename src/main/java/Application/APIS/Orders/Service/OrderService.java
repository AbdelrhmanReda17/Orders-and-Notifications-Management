package Application.APIS.Orders.Service;

import Application.APIS.Orders.Model.IOrder;
import Application.ApplicationManager.OrderProcessorFactory;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Orders.OrderRepository;
import Application.ApplicationManager.ApplicationManager;
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
    public void addOrder(IOrder newOrder) {
        try {
            if(orderRepository.existsById(newOrder.getId())) {
                throw new IllegalStateException("Order with id " + newOrder.getId() + " already exists");
            }
            ApplicationManager orderProcessor = OrderProcessorFactory.CreateOrderProcessor(newOrder);
            orderProcessor.ManageOrder(newOrder , false,OrderState.Placed);
            orderRepository.save(newOrder);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
    public void cancelOrder(int id) {
        if(!orderRepository.existsById(id)) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        IOrder order = orderRepository.findById(id);
        if (!order.getStatus().equals(OrderState.Placement)) {
            ApplicationManager orderProcessor = OrderProcessorFactory.CreateOrderProcessor(order);
            orderProcessor.ManageOrder(order,false,OrderState.Cancelled);
            orderRepository.deleteById(id);
            return;
        }
        throw new IllegalStateException("Order with id " + id + " is already shipped and Cannot be cancelled");
    }

}
