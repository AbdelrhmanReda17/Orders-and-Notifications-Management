package Application.Utilities.Template.EmailTemplate.Languages;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.EmailTemplate.EmailTemplate;

public class EmailTemplateEN implements EmailTemplate {
    @Override
    public String getWelcomeMessage(String name , boolean isTemp) {
        if(isTemp)
            return "Dear {x} , Welcome to Our Store.";
        else
            return "Dear "+name +", Welcome to Our Store. ";
    }
    @Override
    public String getExitMessage(String name , boolean isTemp) {
        if(isTemp)
            return "Dear {x} , Thank you for visiting our store.";
        else
            return "Dear "+name +", Thank you for visiting our store. ";
    }
    @Override
    public String getType() {
        return "EMAIL-EN";
    }
    @Override
    public String OrderMessage(String name, IOrder order , boolean isTemp) {
        if (isTemp)
            return "Subject: Order Confirmation - Order ID: {x}" +
                    "\n\nDear {x},\n\n" +
                    "Your order has been confirmed. Order ID: {x}" +
                    "\nThank you for shopping with us!";
        else
            return "Subject: Order Confirmation - Order ID: " + order.getId() +
                    "\n\nDear " + name + ",\n\n" +
                    "Your order has been confirmed. Order ID: " + order.getId() +
                    "\nThank you for shopping with us!";
    }
    @Override
    public String FinishOrderMessage(String name, IOrder order , boolean isTemp) {
        if(isTemp)
            return "Subject: Order Completion - Order ID: {x}" +
                    "\n\nDear {x},\n\n" +
                    "Your order (ID: {x}) has been completed successfully. Thank you for choosing us!";
        else
            return "Subject: Order Completion - Order ID: " + order.getId() +
                    "\n\nDear " + name + ",\n\n" +
                    "Your order (ID: " + order.getId() + ") has been completed successfully. Thank you for choosing us!";
    }
    @Override
    public String getErrorMessage(String name , boolean isTemp) {
        if (isTemp)
            return "Subject: Order Processing Error - {x}" +
                    "\n\nDear {x},\n\n" +
                    "We apologize, but there was an error processing your order. Please contact customer support for assistance.";
        else
            return "Subject: Order Processing Error - " + name +
                    "\n\nDear " + name + ",\n\n" +
                    "We apologize, but there was an error processing your order. Please contact customer support for assistance.";
    }
    @Override
    public String CancelOrderMessage(String name, IOrder order , boolean isTemp) {
        if (isTemp)
            return "Subject: Order Cancellation - Order ID: {x}" +
                    "\n\nDear {x},\n\n" +
                    "We regret to inform you that your order (ID: {x}) has been canceled.\n" +
                    "If you have any questions or concerns, please contact our customer support.\n" +
                    "Thank you for your understanding.";
        else
            return "Subject: Order Cancellation - Order ID: " + order.getId() +
                    "\n\nDear " + name + ",\n\n" +
                    "We regret to inform you that your order (ID: " + order.getId() + ") has been canceled.\n" +
                    "If you have any questions or concerns, please contact our customer support.\n" +
                    "Thank you for your understanding.";
    }
}
