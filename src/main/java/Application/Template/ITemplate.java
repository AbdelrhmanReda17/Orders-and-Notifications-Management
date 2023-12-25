package Application.Template;

import Application.APIS.Orders.Model.Order;

public interface ITemplate {
    public String getWelcomeMessage(String name);
    public String getExitMessage(String name);
    public String OrderMessage(String name, Order order);
    public String FinishOrderMessage(String name, Order order);
    public String getErrorMessage(String name);

}
