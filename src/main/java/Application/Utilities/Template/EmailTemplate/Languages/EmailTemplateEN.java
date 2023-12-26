package Application.Utilities.Template.EmailTemplate.Languages;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.EmailTemplate.EmailTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmailTemplateEN implements EmailTemplate {

    @Override
    public String PlaceOrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException {
        if (isTemp)
            return "Subject: Order Confirmation - Order ID: {x}" +
                    "\n\nDear {x},\n\n" +
                    "Your order has been confirmed. Order ID: {x}" +
                    "\nThank you for shopping with us!";
        else{
//            String msg = "Subject: Order Confirmation - Order ID:"+order.getId()+"\n\nDear "+name+",\n\nYour booking of";
//                    for(ShoppingCartItem p :order.getProducts()){
//
//                    }
//
//
//                    " has been confirmed. Order ID: {x}" +
//                    "\nThank you for shopping with us!";
            return "";
        }
    }
    @Override
    public String PlacementOrderMessage(String name, IOrder order , boolean isTemp) throws FileNotFoundException {
        if(isTemp)
            return "Subject: Order Completion - Order ID: {x}" +
                    "\n\nDear {x},\n\n" +
                    "Your order (ID: {x}) has been completed successfully. Thank you for choosing us!";
        else{
            return "Subject: Order Completion - Order ID: "+order.getId()+
                    "\n\nDear"+name+",\n\n" +
                    "Your order (ID: "+order.getId()+") has been completed successfully. Thank you for choosing us!";
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
            return "Subject: Order Cancellation - Order ID: "+order.getId()+
                    "\n\nDear "+name+",\n\n" +
                    "We regret to inform you that your order (ID: "+order .getId()+") has been canceled.\n" +
                    "If you have any questions or concerns, please contact our customer support.\n" +
                    "Thank you for your understanding.";
        }
    }
}
