package Application.Utilities.Template.PhoneTemplate.Languages;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateEN implements PhoneTemplate {

    @Override
    public String getWelcomeMessage(String name, boolean isTemp) {
        return "Welcome "+name+", How can we help you";
    }

    @Override
    public String getExitMessage(String name, boolean isTemp) {
        return "thank you for using our store :)";
    }

    @Override
    public String OrderMessage(String name, IOrder order, boolean isTemp) {
        return "your booking of the order ID: "+ order.getId()+"is confirmed.";
    }
    @Override
    public String getType() {
        return "PHONE-EN.txt";
    }
    @Override
    public String FinishOrderMessage(String name, IOrder order , boolean isTemp) {
        return "Hello " + name + ", your order (ID: " + order.getId() + ") has been successfully completed. Thank you for shopping with us!";
    }

    @Override
    public String getErrorMessage(String name , boolean isTemp) {
        return name + ", Unable to process the order at the moment.  please check our costumer service.";    }

    @Override
    public String CancelOrderMessage(String name, IOrder order , boolean isTemp) {
        return "Order Cancellation - Order ID: " + order.getId() +
                "\nDear " + name + ",\n" +
                "We regret to inform you that your order (ID: " + order.getId() + ") has been canceled. If you have questions, please contact support. Thank you.";

    }
}
