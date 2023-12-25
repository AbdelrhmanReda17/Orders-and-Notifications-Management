package Application.APIS.Database;

import java.util.List;

public class DatabaseFactory<T> {

    public List<T> createDatabase(Class<T> clazz) {
        return switch (clazz.getName()) {
            case "Application.APIS.Users.Model.User" -> (List<T>) Common.users;
            case "Application.APIS.Products.Model.Product" -> (List<T>) Common.products;
            case "Application.APIS.Orders.Model.Order" -> (List<T>) Common.orders;
            default -> throw new IllegalArgumentException("Unsupported class: " + clazz.getName());
        };
    }
}