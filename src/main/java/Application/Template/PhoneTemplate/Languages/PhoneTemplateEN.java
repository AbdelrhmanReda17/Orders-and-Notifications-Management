package Application.Template.PhoneTemplate.Languages;

import Application.APIS.Orders.Model.Order;
import Application.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateEN implements PhoneTemplate {

    @Override
    public String getWelcomeMessage(String name) {
        return "Welcome "+name+", How can we help you";
    }

    @Override
    public String getExitMessage(String name) {
        return "thank you for using our store :)";
    }

    @Override
    public String OrderMessage(String name, Order order) {
        return "your booking of the order ID: "+ order.getId()+"is confirmed.";
    }

    @Override
    public String FinishOrderMessage(String name, Order order) {
        return "Hello " + name + ", your order (ID: " + order.getId() + ") has been successfully completed. Thank you for shopping with us!";
    }

    @Override
    public String getErrorMessage(String name) {
        return name + ", Unable to process the order at the moment.  please check our costumer service.";    }
}
