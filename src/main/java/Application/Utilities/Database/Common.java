package Application.Utilities.Database;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.Payment.DummyWallet;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.Model.UserCredentials;
import Application.APIS.Notifications.Model.Notification;

import java.util.*;


public class Common {
    public static List<User> users = new LinkedList<User>(
        List.of(
            new User(1, new UserCredentials("Abdelrhman", "admin", "0123456789",  "Egypt" , "Cairo" , "Mokattam" , "Example1@gmail.com") , new DummyWallet(100),"AR" , "SMS") , // 90
            new User(2, new UserCredentials("Atef", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example2@gmail.com") , new DummyWallet(200),"EN" , "EMAIL"), // 190
            new User(3, new UserCredentials("Ahmed", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example3@gmail.com") , new DummyWallet(200),"AR" , "EMAIL"), // 190
            new User(4, new UserCredentials("Mohamed", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example4@gmail.com") , new DummyWallet(200),"AR" , "SMS") // 190
        )
    );
    public static List<Product> products = new LinkedList<Product>(
       List.of(
            new Product(1, "Product 1", "Vendor", 100, 10),
            new Product(2, "Product 2", "Vendor", 200, 20),
            new Product(3, "Product 3", "Vendor", 300, 30),
            new Product(4, "Product 4", "Vendor", 400, 40),
            new Product(5, "Product 5", "Vendor", 500, 50),
            new Product(6, "Product 6", "Vendor", 600, 60),
            new Product(7, "Product 7", "Vendor", 700, 70),
            new Product(8, "Product 8", "Vendor", 800, 80),
            new Product(9, "Product 9", "Vendor", 900, 90),
            new Product(10, "Product 10", "Vendor", 1000, 100),
            new Product(11, "Product 11", "Vendor", 1100, 110)
       )
    );
    public static List<IOrder> orders = new LinkedList<IOrder>(
        List.of(
            new SimpleOrder(0, 900,  1 , List.of(
                new ShoppingCartItem(1, 1),
                new ShoppingCartItem(2, 4)
            )),
            new SimpleOrder(1, 5300,  2 , List.of(
                new ShoppingCartItem(10, 2),
                new ShoppingCartItem(11, 3)
            )),
            new SimpleOrder(2, 1600,  3 , List.of(
                new ShoppingCartItem(1, 6),
                new ShoppingCartItem(2, 5)
            )),
            new CompoundOrder(
                    3,
                900,
                1,
                List.of(
                    new ShoppingCartItem(1, 1),
                    new ShoppingCartItem(2, 4)
                ),
                List.of(
                    new SimpleOrder(3,500,  3 , List.of(
                        new ShoppingCartItem(1, 1),
                        new ShoppingCartItem(2, 2)
                    )),
                    new SimpleOrder(3,800,  4 , List.of(
                        new ShoppingCartItem(8, 1)
                    )),
                    new SimpleOrder( 3,1000, 2 , List.of(
                        new ShoppingCartItem(5, 2)
                    ))
                )
            )
        )
    );
    public static List<Notification> notificationsSent = new LinkedList<Notification>();
    public static List<Integer> notificationsCounter = new LinkedList<Integer>();
    public static List<Notification> notificationsQueue = new LinkedList<Notification>();

}
