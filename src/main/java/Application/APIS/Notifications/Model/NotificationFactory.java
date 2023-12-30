package Application.APIS.Notifications.Model;

import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Products.Model.Product;
import Application.APIS.Users.Model.User;
import Application.Utilities.Template.ITemplate;
import Application.Utilities.Template.TemplateFactory;

import java.util.List;
import java.util.Objects;

public class NotificationFactory {
    public static Notification CreateNotification(OrderState type ,List<Product> newOrder, User user) {
        ITemplate template = TemplateFactory.createTemplate(user.getTemplate() , user.getLanguage());
        return new Notification(
                    Objects.requireNonNull(TemplateFactory.createOrderNotification(type, template, user.getUserCredentials().getUsername(), newOrder)).getKey(),
                    Objects.requireNonNull(TemplateFactory.createOrderNotification(type, template, user.getUserCredentials().getUsername(), newOrder)).getValue());
    }
}
