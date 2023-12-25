package Application.Database;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.Order;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.DummyWallet;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.Model.UserCredentials;
import Application.Utilities.Notification;

import java.time.LocalDate;
import java.util.*;


public class Common {
    public static List<User> users = new LinkedList<User>(
        List.of(
            new User(1, new UserCredentials("Abdelrhman", "admin", "0123456789", "Mokattam - Cairo" , "Example1@gmail.com") , new DummyWallet(100),"AR" , "SMS") ,
            new User(2, new UserCredentials("Atef", "user", "0123456789", "Madint Nasr - Cairo" , "Example2@gmail.com") , new DummyWallet(200),"EN" , "EMAIL")
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
    public static List<IOrder> orders = new LinkedList<IOrder>();

    public static PriorityQueue<Notification> notificationsQueue = new PriorityQueue<Notification>(
        Comparator.comparing(Notification::getNotificationCounter)
    );

}
