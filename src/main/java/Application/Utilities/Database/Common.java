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
            new User(1, new UserCredentials("Abdelrhman", "admin", "0123456789",  "Egypt" , "Cairo" , "Mokattam" , "Example1@gmail.com") , new DummyWallet(1000),"AR" , "SMS") , // 90
            new User(2, new UserCredentials("Atef", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example2@gmail.com") , new DummyWallet(2000),"EN" , "EMAIL"), // 190
            new User(3, new UserCredentials("Ahmed", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example3@gmail.com") , new DummyWallet(3000),"AR" , "EMAIL"), // 190
            new User(4, new UserCredentials("Mohamed", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example4@gmail.com") , new DummyWallet(4000),"AR" , "SMS") // 190
        )
    );
    public static List<Product> products = new LinkedList<Product>(
       List.of(
            new Product( "Product 1", "Vendor","category 1", 100, 10),
            new Product( "Product 2", "Vendor","category 1", 200, 20),
            new Product( "Product 3", "Vendor","category 1", 300, 30),
            new Product( "Product 4", "Vendor","category 2", 400, 40),
            new Product( "Product 5", "Vendor","category 1", 500, 50),
            new Product( "Product 6", "Vendor","category 3", 600, 60),
            new Product( "Product 7", "Vendor","category 1", 700, 70),
            new Product("Product 8", "Vendor","category 1", 800, 80),
            new Product( "Product 9", "Vendor","category 4", 900, 90),
            new Product( "Product 10", "Vendor","category 1", 1000, 100),
            new Product( "Product 11", "Vendor","category 5", 1100, 110)
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
    public static List<Notification> notificationsQueue = new LinkedList<Notification>();

}
