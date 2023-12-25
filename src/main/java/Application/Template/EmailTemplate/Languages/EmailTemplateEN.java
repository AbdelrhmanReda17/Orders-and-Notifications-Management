package Application.Template.EmailTemplate.Languages;

import Application.APIS.Orders.Model.Order;
import Application.Template.EmailTemplate.EmailTemplate;

public class EmailTemplateEN implements EmailTemplate {
    @Override
    public String getWelcomeMessage(String name) {
        return "Dear "+name +", Welcome to Our Store. ";
    }

    @Override
    public String getExitMessage(String name) {
        return "Dear "+name +", Thank You for Visiting Our Store";
    }

    @Override
    public String OrderMessage(String name, Order order) {
        return "Subject: Order Confirmation - Order ID: " + order.getId() +
                "\n\nDear " + name + ",\n\n" +
                "Your order has been confirmed. Order ID: " + order.getId() +
                "\nThank you for shopping with us!";
    }

    @Override
    public String FinishOrderMessage(String name, Order order) {
        return "Subject: Order Completed - Order ID: " + order.getId() +
                "\n\nDear " + name + ",\n\n" +
                "Your order (ID: " + order.getId() + ") has been successfully completed. Thank you for choosing us!";
    }

    @Override
    public String getErrorMessage(String name) {
        return "Subject: Order Processing Error - " + name +
                "\n\nDear " + name + ",\n\n" +
                "We apologize, but there was an error processing your order. Please contact customer support for assistance.";

    }
}
