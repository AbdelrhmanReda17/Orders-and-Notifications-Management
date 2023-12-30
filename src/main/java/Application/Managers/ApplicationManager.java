package Application.Managers;

import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Products.Model.Product;
import Application.APIS.Products.ProductRepository;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;
import Application.Managers.NotificationManager.NotificationManager;
import Application.Managers.OrderManager.Factory.OrderManagerFactory;
import Application.Managers.OrderManager.OrderManager;
import Application.Managers.ProductManager.ProductManager;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public abstract class ApplicationManager {
    static UserRepository userRepository = new UserRepository();
    public static int numberOfOrders = 1;
    public static void ManageOrder(IOrder newOrder , OrderState status){
        try{
            User user = userRepository.findById(newOrder.getUserId());
            List<Product> products = ProductManager.getProducts(newOrder.getProducts());
            OrderManager orderManager = OrderManagerFactory.CreateOrderProcessor(newOrder , numberOfOrders);
            OrderManagerFactory.CreateCommand(status).execute(orderManager , newOrder  , user);
            NotificationManager.createOrderNotification(status, products , user);
        }catch (Exception e){
            throw new IllegalStateException(e.getMessage());
        }
    }
    public static void AppendToFile(Notification notification) {
        try {
            FileWriter fw = new FileWriter("notifications.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(notification.notificationMessage);
            pw.close();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

}
