package Application.APIS.Orders.Model;


import java.util.List;


public class CompoundOrder extends IOrder{
    private double price;
    private final List<ShoppingCartItem> products;
    public List<IOrder> orderList;
    public CompoundOrder(int id, int userId, double price, List<ShoppingCartItem> products , List<IOrder> orderList) {
        super(id, userId);
        this.price = price;
        this.products = products;
        this.orderList = orderList;
    }
    public CompoundOrder(double price ,int userId , List<ShoppingCartItem> products , List<IOrder> orderList) {
        super(userId );
        this.price = price;
        this.products = products;
        this.userId = userId;
        this.orderList = orderList;
    }
    @Override
    public List<ShoppingCartItem> getProducts() {
        return products;
    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setStatus(OrderState status) {
        this.status = status;
        for (IOrder order :orderList) {
            order.setStatus(status);
        }
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
         this.id = id;
         for (IOrder order :orderList) {
                order.setId(id);
         }
    }
    public List<IOrder> getOrderList() {
        return orderList;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public void copy(IOrder newOrder) {
        CompoundOrder complexOrder = (CompoundOrder) newOrder;
        this.id = complexOrder.getId();
        this.userId = complexOrder.getUserId();
        for (IOrder order: orderList) {
            complexOrder.copy(order);
        }
    }

    @Override
    public String toString() {
        return "CompoundOrder : "+
                "id = " + id +
                ", price = " + price +
                ", date = " + getDate() +
                ", status = " + getStatus() +
                ", userId = " + userId +
                ", products = " + products + '\n' +
                "orderList = " + orderList;
    }
}
