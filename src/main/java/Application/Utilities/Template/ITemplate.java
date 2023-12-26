package Application.Utilities.Template;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;

public interface ITemplate {
    public String getWelcomeMessage(String name , boolean isTemp);
    public String getExitMessage(String name , boolean isTemp);
    public String OrderMessage(String name, IOrder order , boolean isTemp);
    public String FinishOrderMessage(String name, IOrder order , boolean isTemp);
    public String getErrorMessage(String name , boolean isTemp);
    public String CancelOrderMessage (String name, IOrder order , boolean isTemp);

    public String getType();
}
