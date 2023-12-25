package Application.APIS.Orders;

import Application.Utilities.Database.DataRepository;
import Application.APIS.Orders.Model.IOrder;
import org.springframework.stereotype.Repository;

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
