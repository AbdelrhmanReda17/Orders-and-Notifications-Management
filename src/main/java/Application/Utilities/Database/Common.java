package Application.Utilities.Database;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.DummyWallet;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.Model.UserCredentials;
import Application.Utilities.Notification.Notification;

import java.util.*;


public class Common {
    public static List<User> users = new LinkedList<User>(
        List.of(
            new User(1, new UserCredentials("Abdelrhman", "admin", "0123456789",  "Egypt" , "Cairo" , "Mokattam" , "Example1@gmail.com") , new DummyWallet(100),"AR" , "SMS") ,
            new User(2, new UserCredentials("Atef", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example2@gmail.com") , new DummyWallet(200),"EN" , "EMAIL"),
            new User(3, new UserCredentials("Ahmed", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example3@gmail.com") , new DummyWallet(200),"EN" , "EMAIL"),
            new User(4, new UserCredentials("Mohamed", "user", "0123456789", "Egypt" , "Cairo" , "Madint Nasr"  , "Example4@gmail.com") , new DummyWallet(200),"EN" , "SMS")
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
    public static List<IOrder> orders = new LinkedList<IOrder>(
        List.of(
            new SimpleOrder(1, 1, new Date(), "Pending" , 1 , List.of(
                new ShoppingCartItem(1, 1),
                new ShoppingCartItem(2, 1),
                new ShoppingCartItem(3, 1),
                new ShoppingCartItem(4, 1),
                new ShoppingCartItem(5, 1)
            )),
            new SimpleOrder(2, 2, new Date(), "Pending" , 2 , List.of(
                new ShoppingCartItem(1, 1),
                new ShoppingCartItem(2, 1),
                new ShoppingCartItem(3, 1),
                new ShoppingCartItem(4, 1),
                new ShoppingCartItem(5, 1)
            )),
            new SimpleOrder(3, 1, new Date(), "Pending" , 1 , List.of(
                new ShoppingCartItem(1, 1),
                new ShoppingCartItem(2, 1),
                new ShoppingCartItem(3, 1),
                new ShoppingCartItem(4, 1),
                new ShoppingCartItem(5, 1)
            )),
            new CompoundOrder(
                4,
                1,
                new Date(),
                "Pending",
                3,
                List.of(
                    new ShoppingCartItem(1, 1),
                    new ShoppingCartItem(2, 1),
                    new ShoppingCartItem(3, 1),
                    new ShoppingCartItem(4, 1),
                    new ShoppingCartItem(5, 1)
                ),
                List.of(
                    new SimpleOrder(5, 1, new Date(), "Pending" , 1 , List.of(
                        new ShoppingCartItem(1, 1),
                        new ShoppingCartItem(2, 2),
                        new ShoppingCartItem(3, 3),
                        new ShoppingCartItem(4, 5),
                        new ShoppingCartItem(5, 4)
                    )),
                    new SimpleOrder(6, 2, new Date(), "Pending" , 2 , List.of(
                        new ShoppingCartItem(1, 1),
                        new ShoppingCartItem(2, 1),
                        new ShoppingCartItem(3, 1),
                        new ShoppingCartItem(4, 1),
                        new ShoppingCartItem(5, 1)
                    )),
                    new SimpleOrder(7, 1, new Date(), "Pending" , 4 , List.of(
                        new ShoppingCartItem(1, 1),
                        new ShoppingCartItem(2, 1),
                        new ShoppingCartItem(3, 1),
                        new ShoppingCartItem(4, 1),
                        new ShoppingCartItem(5, 1)
                    ))
                )
            )
        )
    );

    public static PriorityQueue<Notification> notificationsQueue = new PriorityQueue<Notification>(
        Comparator.comparing(Notification::getNotificationCounter)
    );

}
