package Application.APIS.Orders;

import Application.APIS.Database.DataRepository;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository extends DataRepository<IOrder, Integer> {
    public OrderRepository() {
        super(IOrder.class);
    }

    public IOrder findByUserId(Integer userId) {
        for (IOrder order : this.data) {
            if (order.getUserId().equals(userId)) {
                return order;
            }
        }
        throw new IllegalStateException("Couldn't find this ID");
    }
}
