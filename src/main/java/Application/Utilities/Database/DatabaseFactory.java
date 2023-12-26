package Application.Utilities.Database;

import java.util.List;
import java.util.Map;

public class DatabaseFactory<T> {

    public List createDatabase(Class<T> clazz) {
        return switch (clazz.getName()) {
            case "Application.APIS.Users.Model.User" -> (List) Common.users;
            case "Application.APIS.Products.Model.Product" -> (List) Common.products;
            case "Application.APIS.Orders.Model.IOrder" -> (List) Common.orders;
            case "Application.APIS.Notifications.Model.Notification" -> (List) Common.notificationsQueue;
            default -> throw new IllegalArgumentException("Unsupported class: " + clazz.getName());
        };
    }
}