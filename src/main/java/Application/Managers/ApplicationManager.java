package Application.Managers;

import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Notifications.Service.NotificationsService;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Products.Model.Product;
import Application.APIS.Products.Service.ProductService;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.Service.UserService;
import Application.Managers.OrderManager.Factory.OrderManagerFactory;
import Application.Managers.OrderManager.OrderCommands.Factory.OrderCommandFactory;
import Application.Managers.OrderManager.OrderManager;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public abstract class ApplicationManager {
    public static int numberOfOrders = 1;
    public static void ManageOrder(IOrder newOrder , OrderState status){
        try{
            User user = UserService.getUser(newOrder);
            List<Product> products = ProductService.getProducts(newOrder.getProducts());
            OrderManager orderManager = OrderManagerFactory.CreateOrderProcessor(newOrder , numberOfOrders);
            OrderCommandFactory.CreateCommand(status).execute(orderManager , newOrder  , user);
            NotificationsService.createOrderNotification(status, products , user);
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
