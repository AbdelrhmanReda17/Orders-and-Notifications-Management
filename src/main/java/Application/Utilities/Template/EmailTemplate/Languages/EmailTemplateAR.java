package Application.Utilities.Template.EmailTemplate.Languages;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.EmailTemplate.EmailTemplate;

public class EmailTemplateAR implements EmailTemplate {

    @Override
    public String PlaceOrderMessage(String name, IOrder order , boolean isTemp) {
        if(isTemp)
            return "الموضوع: تأكيد الطلب - رقم الطلب: {ص}" +
                    "\n\nعزيزي {س}،\n\n" +
                    "تم تأكيد طلبك. رقم الطلب: {ص}" +
                    "\nشكرًا لتسوقك معنا!";
        else
            return "الموضوع: تأكيد الطلب - رقم الطلب: " + order.getId() +
                    "\n\nعزيزي " + name + "،\n\n" +
                    "تم تأكيد طلبك. رقم الطلب: " + order.getId() +
                    "\nشكرًا لتسوقك معنا!";
    }


    @Override
    public String PlacementOrderMessage(String name, IOrder order , boolean isTemp) {
      if (isTemp)
            return "الموضوع: إكمال الطلب - رقم الطلب: {ص}" +
                    "\n\nعزيزي {س}،\n\n" +
                    "تم إكمال طلبك (الرقم: {ص}) بنجاح. شكرًا لاختيارك لنا!";
        else
            return "الموضوع: إكمال الطلب - رقم الطلب: " + order.getId() +
                    "\n\nعزيزي " + name + "،\n\n" +
                    "تم إكمال طلبك (الرقم: " + order.getId() + ") بنجاح. شكرًا لاختيارك لنا!";
    }


    @Override
    public String CancelOrderMessage(String name, IOrder order , boolean isTemp) {
        if (isTemp)
            return "الموضوع: إلغاء الطلب - رقم الطلب: {ص}" +
                    "\n\nعزيزي {س}،\n\n" +
                    "تم إلغاء طلبك (الرقم: {ص}) بنجاح. شكرًا لاختيارك لنا!";
        else
            return "الموضوع: إلغاء الطلب - رقم الطلب: " + order.getId() +
                    "\n\nعزيزي " + name + "،\n\n" +
                    "تم إلغاء طلبك (الرقم: " + order.getId() + ") بنجاح. شكرًا لاختيارك لنا!";
    }
}
