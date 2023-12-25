package Application.APIS.Database;

import Application.APIS.Orders.Model.Order;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.User;

import java.util.LinkedList;
import java.util.List;


public class Common {
    public static List<User> users = new LinkedList<User>();

    public static List<Product> products = new LinkedList<Product>(
       List.of(
            new Product(1 , "Apple", "Apple Inc.", 1000, 100),
            new Product(2 , "Samsung", "Samsung Inc.", 1000, 100),
            new Product(3 , "Xiaomi", "Xiaomi Inc.", 1000, 100),
            new Product(4 , "Huawei", "Huawei Inc.", 1000, 100),
            new Product(5 , "Oppo", "Oppo Inc.", 1000, 100)
       )
    );

    public static List<Order> orders = new LinkedList<Order>();

}
