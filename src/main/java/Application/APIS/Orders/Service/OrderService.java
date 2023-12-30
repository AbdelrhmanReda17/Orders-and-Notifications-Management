package Application.APIS.Orders.Service;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Orders.OrderRepository;
import Application.Managers.ApplicationManager;
import Application.Utilities.Database.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final DataRepository<IOrder, Integer> orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public IOrder getOrder(int id) {
        return orderRepository.findById(id);
    }
    public IOrder getUserOrders(int userId) {
         try {
                return ((OrderRepository) orderRepository).findByUserId(userId);
            } catch (Exception e) {
                throw new IllegalStateException("Could not get orders");
         }
    }
    public void addOrder(IOrder newOrder) {
        newOrder.setId(((OrderRepository) orderRepository).getNextId());
        ApplicationManager.ManageOrder(newOrder ,OrderState.Placed);
        orderRepository.save(newOrder);
    }
    public IOrder deleteOrder(int id) {
        if(!orderRepository.existsById(id)) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        IOrder order = orderRepository.findById(id);
        ApplicationManager.ManageOrder(order,OrderState.Cancelled);
        orderRepository.deleteById(id);
        return order;
    }

    public IOrder cancelShipmentOrder(int id) {
        if(!orderRepository.existsById(id)) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        IOrder order = orderRepository.findById(id);
        ApplicationManager.ManageOrder(order,OrderState.CancelShipping);
        orderRepository.update(order);
        return order;
    }

    public IOrder placementOrder(int id) {
        if(!orderRepository.existsById(id)) {
            throw new IllegalStateException("Order with id " + id + " does not exist");
        }
        IOrder order = orderRepository.findById(id);
        ApplicationManager.ManageOrder(order,OrderState.Shipping);
        orderRepository.update(order);
        return order;
    }
}
