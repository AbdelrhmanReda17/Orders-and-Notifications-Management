package Application.Utilities.Template.PhoneTemplate.Languages;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateEN implements PhoneTemplate {

    @Override
    public String PlaceOrderMessage(String name, IOrder order, boolean isTemp) {
        return "your booking of the order ID: "+ order.getId()+"is confirmed.";
    }
    @Override
    public String PlacementOrderMessage(String name, IOrder order , boolean isTemp) {
        return "Hello " + name + ", your order (ID: " + order.getId() + ") has been successfully completed. Thank you for shopping with us!";
    }

    @Override
    public String CancelOrderMessage(String name, IOrder order , boolean isTemp) {
        return "Order Cancellation - Order ID: " + order.getId() +
                "\nDear " + name + ",\n" +
                "We regret to inform you that your order (ID: " + order.getId() + ") has been canceled. If you have questions, please contact support. Thank you.";

    }
}
