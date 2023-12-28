package Application.ApplicationManager;

import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Notifications.Model.NotificationFactory;
import Application.APIS.Notifications.NotificationsRepository;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Orders.OrderRepository;
import Application.APIS.Products.Model.Product;
import Application.APIS.Products.ProductRepository;
import Application.APIS.Users.Model.User;
import Application.APIS.Users.UserRepository;
import Application.Utilities.Template.ITemplate;
import Application.Utilities.Template.TemplateFactory;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class ApplicationManager {
    double OrderFees = 120;
    static UserRepository userRepository = new UserRepository();
    static ProductRepository productRepository = new ProductRepository();
    static NotificationsRepository notificationsRepository = new NotificationsRepository();
    static OrderRepository orderRepository = new OrderRepository();
    protected final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void ProcessManager(User user, OrderState status, IOrder newOrder, boolean isCompound)  {
        if (Objects.equals(status, OrderState.Cancelled)) {
            CancelHandler(newOrder,isCompound);
        } else {
            Process(newOrder, isCompound, user);
        }
    }

    public void ManageOrder(IOrder newOrder , boolean isCompound, OrderState status){
        if(newOrder.getStatus() != OrderState.Placed){ return; }
        List<Product> products = getProducts(newOrder.getProducts() , status);
        try{
            User user = userRepository.findById(newOrder.getUserId());
            ProcessManager(user , status , newOrder , isCompound);
            for(int i = 0 ; i < newOrder.getProducts().size() ; i++){
                Product product1 = products.get(i);
                if (Objects.equals(status, OrderState.Cancelled)) {
                    product1.setQuantity(product1.getQuantity() + newOrder.getProducts().get(i).getQuantity());
                } else {
                    product1.setQuantity(product1.getQuantity() - newOrder.getProducts().get(i).getQuantity());
                }
                products.set(i , product1);
                productRepository.update(product1);
            }
            createOrderNotification(status, products , user);
        }catch (Exception e){
            throw new IllegalStateException(e.getMessage());
        }
    }

    public abstract void VerifyOrder(IOrder order, User user);

    public static List<Product> getProducts(List<ShoppingCartItem> ShoppingCartItems , OrderState status){
        List<Product> products = new LinkedList<>();
        for(ShoppingCartItem product : ShoppingCartItems){
            products.add(productRepository.findById(product.getProductId()));
            if(!Objects.equals(status, OrderState.Cancelled) && !Objects.equals(status , OrderState.Placement) && products.get(products.size() - 1).getQuantity() < product.getQuantity()){
                throw new IllegalStateException("Not enough quantity for product " + products.get(products.size() - 1).getName());
            }
        }
        return products;
    }


    public abstract void CancelHandler(IOrder order, boolean isCompound);
    public abstract void Process(IOrder order , boolean isCompound, User user);
    public static void createOrderNotification(OrderState Type, List<Product> products, User user) {
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
            throw new IllegalStateException(e.getMessage());
        }
    }
    public static void shipOrder(IOrder order) {
        if(!orderRepository.existsById(order.getId())) {
            throw new IllegalStateException("Order with id " + order.getId() + " does not exist");
        }
        if(!order.getStatus().equals(OrderState.Cancelled)) {
            order.setStatus(OrderState.Placement);
            createOrderNotification(OrderState.Placement, getProducts(order.getProducts() , order.getStatus()) , userRepository.findById(order.getUserId()));
        }
    }
}
