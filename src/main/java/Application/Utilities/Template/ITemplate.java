package Application.Utilities.Template;

import Application.APIS.Orders.Model.IOrder;

import java.io.FileNotFoundException;

public interface ITemplate {

    public String PlaceOrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException;
    public String PlacementOrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException;
    public String CancelOrderMessage (String name, IOrder order , boolean isTemp) throws FileNotFoundException;

}
