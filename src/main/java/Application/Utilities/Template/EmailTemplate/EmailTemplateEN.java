package Application.Utilities.Template.EmailTemplate;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.EmailTemplate.EmailTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmailTemplateEN implements EmailTemplate {
    File language ;

    EmailTemplateEN(String lang) throws FileNotFoundException {
        String dir="/Languages/"+lang;
        language = new File(dir);
    }
    @Override
    public String getWelcomeMessage(String name , boolean isTemp) throws FileNotFoundException {
        if(isTemp)
            return "Dear {x} , Welcome to Our Store.";
        else{
            String msg;
            msg =FileParser.parse("WELCOMEMSG",language);

            return msg.replaceAll("\\{N\\}", name);
        }
    }
    @Override
    public String getExitMessage(String name , boolean isTemp) throws FileNotFoundException {
        if(isTemp)
            return "Dear {x} , Thank you for visiting our store.";
        else{
            String msg;
            msg =FileParser.parse("EXITMSG",language);
            return msg.replaceAll("\\{N\\}", name);
        }}
    @Override
    public String getType() {
        return "EMAIL-EN.txt";
    }
    @Override
    public String OrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException {
        if (isTemp)
            return "Subject: Order Confirmation - Order ID: {x}" +
                    "\n\nDear {x},\n\n" +
                    "Your order has been confirmed. Order ID: {x}" +
                    "\nThank you for shopping with us!";
        else{
            String msg;
            msg =FileParser.parse("ORDERMSG",language);
            msg=msg.replaceAll("\\{I\\}", String.valueOf(order.getId()));
            return msg.replaceAll("\\{N\\}", name);
        }
    }
    @Override
    public String FinishOrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException {
        if(isTemp)
            return "Subject: Order Completion - Order ID: {x}" +
                    "\n\nDear {x},\n\n" +
                    "Your order (ID: {x}) has been completed successfully. Thank you for choosing us!";
        else{
            String msg;
            msg =FileParser.parse("FINISHORDERMSG",language);
            msg=msg.replaceAll("\\{I\\}", String.valueOf(order.getId()));
            return msg.replaceAll("\\{N\\}", name);
        }
    }
    @Override
    public String getErrorMessage(String name , boolean isTemp) throws FileNotFoundException {
        if (isTemp)
            return "Subject: Order Processing Error - {x}" +
                    "\n\nDear {x},\n\n" +
                    "We apologize, but there was an error processing your order. Please contact customer support for assistance.";
        else{
            String msg;
            msg =FileParser.parse("ERRORMSG",language);
            return msg.replaceAll("\\{N\\}", name);
        }
    }
    @Override
    public String CancelOrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException {
        if (isTemp)
            return "Subject: Order Cancellation - Order ID: {x}" +
                    "\n\nDear {x},\n\n" +
                    "We regret to inform you that your order (ID: {x}) has been canceled.\n" +
                    "If you have any questions or concerns, please contact our customer support.\n" +
                    "Thank you for your understanding.";
        else{
            String msg;
            msg =FileParser.parse("CANCELMSG",language);
            msg=msg.replaceAll("\\{I\\}", String.valueOf(order.getId()));
            return msg.replaceAll("\\{N\\}", name);
        }
    }
}
