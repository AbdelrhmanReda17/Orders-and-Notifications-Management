package Application.APIS.Database;

import Application.APIS.Orders.Model.Order;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Common {
    public static List<User> users = new LinkedList<User>(
        List.of(
            new User(1, "Abdelrhman", "admin", "0123456789", "Mokattam - Cairo" , "Example1@gmail.com" , "AR" , "SMS") ,
            new User(2, "Atef", "user", "0123456789", "Madint Nasr - Cairo" , "Example2@gmail.com" , "EN" , "EMAIL")
        )
    );

    public static List<Product> products = new LinkedList<Product>(
       List.of(
            new Product(1 , "Apple", "Apple Inc.", 1000, 100),
            new Product(2 , "Samsung", "Samsung Inc.", 1000, 100),
            new Product(3 , "Xiaomi", "Xiaomi Inc.", 1000, 100),
            new Product(4 , "Huawei", "Huawei Inc.", 1000, 100),
            new Product(5 , "Oppo", "Oppo Inc.", 1000, 100)
       )
    );

    public static List<Order> orders = new LinkedList<Order>(
        List.of(
            new Order(1, 1, new Date(), "Waiting", 1,
                    List.of(new ShoppingCartItem(20,1) , new ShoppingCartItem(20,2))
            ),
            new Order(2, 1, new Date(), "Waiting", 2,
                     List.of(new ShoppingCartItem(2,4) , new ShoppingCartItem(3,5))
            )
        )
    );

}
