package Application.APIS.Notifications.Model;

import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.User;
import Application.Utilities.Template.ITemplate;
import Application.Utilities.Template.TemplateFactory;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public class NotificationFactory {
    public static Notification CreateNotification(OrderState type , ITemplate template , List<Product> newOrder, String username) {
            return new Notification(
                    Objects.requireNonNull(TemplateFactory.createOrderNotification(type, template, username, newOrder)).getKey(),
                    Objects.requireNonNull(TemplateFactory.createOrderNotification(type, template, username, newOrder)).getValue());
    }
}
