package Application.Utilities.Template;

import Application.APIS.Orders.Model.SimpleOrder;

public interface ITemplate {
    public String getWelcomeMessage(String name);
    public String getExitMessage(String name);
    public String OrderMessage(String name, SimpleOrder order);
    public String FinishOrderMessage(String name, SimpleOrder order);
    public String getErrorMessage(String name);
    public String CancelOrderMessage (String name, SimpleOrder order);

}
