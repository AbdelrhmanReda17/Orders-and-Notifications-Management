package Application.Utilities.Template.EmailTemplate.Languages;

import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.EmailTemplate.EmailTemplate;

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
    public String OrderMessage(String name, SimpleOrder order) {
        return "Subject: Order Confirmation - Order ID: " + order.getId() +
                "\n\nDear " + name + ",\n\n" +
                "Your order has been confirmed. Order ID: " + order.getId() +
                "\nThank you for shopping with us!";
    }
    @Override
    public String FinishOrderMessage(String name, SimpleOrder order) {
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
    @Override
    public String CancelOrderMessage(String name, SimpleOrder order) {
        return "Subject: Order Cancellation - Order ID: " + order.getId() +
                "\n\nDear " + name + ",\n\n" +
                "We regret to inform you that your order (ID: " + order.getId() + ") has been canceled.\n" +
                "If you have any questions or concerns, please contact our customer support.\n" +
                "Thank you for your understanding.";
    }
}
