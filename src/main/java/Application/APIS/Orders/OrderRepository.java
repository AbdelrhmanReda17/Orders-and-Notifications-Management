package Application.APIS.Orders;

import Application.APIS.Database.DataRepository;
import Application.APIS.Orders.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository extends DataRepository<Order, Integer> {
    public OrderRepository() {
        super(Order.class);
    }

    public Order findByUserId(Integer userId) {
        for (Order order : this.data) {
            if (order.getUserId().equals(userId)) {
                return order;
            }
        }
        throw new IllegalStateException("Couldn't find this ID");
    }
}
