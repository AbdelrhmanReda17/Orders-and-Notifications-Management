package Application.Utilities.Template;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;

import java.io.FileNotFoundException;

public interface ITemplate {
    public String getWelcomeMessage(String name , boolean isTemp) throws FileNotFoundException;
    public String getExitMessage(String name , boolean isTemp) throws FileNotFoundException;
    public String OrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException;
    public String FinishOrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException;
    public String getErrorMessage(String name , boolean isTemp) throws FileNotFoundException;
    public String CancelOrderMessage (String name, IOrder order , boolean isTemp) throws FileNotFoundException;

    public String getType();
}
