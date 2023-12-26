package Application.ApplicationManager;

import Application.APIS.Notifications.Controller.NotificationsController;
import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Notifications.Model.NotificationFactory;
import Application.APIS.Notifications.NotificationsRepository;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Products.Model.Product;
import Application.APIS.Products.ProductRepository;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;
import Application.Utilities.Template.ITemplate;
import Application.Utilities.Template.TemplateFactory;
import org.springframework.core.annotation.Order;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public abstract class ApplicationManager {
    double OrderFees = 120;
    static UserRepository userRepository = new UserRepository();
    static ProductRepository productRepository = new ProductRepository();
    static NotificationsRepository notificationsRepository = new NotificationsRepository();

    public void placeOrder(IOrder newOrder , boolean isCompound){
        List<Product> products = new LinkedList<>();
        for(ShoppingCartItem product : newOrder.getProducts()){
            products.add(productRepository.findById(product.getProductId()));
            if(products.get(products.size() - 1).getQuantity() < product.getQuantity()){
                throw new IllegalStateException("Not enough quantity for product " + products.get(products.size() - 1).getName());
            }
        }
        try{
            Process(newOrder , isCompound);
            for(int i = 0 ; i < newOrder.getProducts().size() ; i++){
                Product product1 = products.get(i);
                product1.setQuantity(product1.getQuantity() - newOrder.getProducts().get(i).getQuantity());
                products.set(i , product1);
                productRepository.update(product1);
            }
            createOrderNotification(OrderState.Placed, products , userRepository.findById(newOrder.getUserId()));
        }catch (Exception e){
            throw new IllegalStateException(e.getMessage());
        }
    }
    public abstract void Process(IOrder order , boolean isCompound);
    public static void createOrderNotification(OrderState Type, List<Product> products, User user) throws FileNotFoundException {
        ITemplate template = TemplateFactory.createTemplate(user.getTemplate() , user.getLanguage());
        Notification notification = NotificationFactory.CreateNotification(Type , template , products , user.getUserCredentials().getUsername() );
        user.addNotification(notification.getId());
        ApplicationManager.addNotification(notification);
    }

    public static void addNotification(Notification notification) {
        notificationsRepository.save(notification);
    }
    public static void AppendToFile(Notification notification) {
        try {
            FileWriter fw = new FileWriter("notifications.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(notification.notificationMessage);
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
