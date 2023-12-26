package Application.Utilities.Template.PhoneTemplate.Languages;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateAR implements PhoneTemplate {


    @Override
    public String PlaceOrderMessage(String name, IOrder order , boolean isTemp) {
        if(isTemp){
            return "، تم تأكيد حجز الطلب برقم: {س}.";
        }else{
            return "، تم تأكيد حجز الطلب برقم: " + order.getId() + ".";
        }
    }

    @Override
    public String PlacementOrderMessage(String name, IOrder order , boolean isTemp) {
        if (isTemp){
            return "، تم إكمال طلبك (الرقم: {ص}) بنجاح. شكرًا لتسوقك معنا!";
        }else{
            return "، تم إكمال طلبك (الرقم: " + order.getId() + ") بنجاح. شكرًا لتسوقك معنا!";
        }
    }

    @Override
    public String CancelOrderMessage(String name, IOrder order , boolean isTemp) {
        if(isTemp)
            return "إلغاء الطلب - رقم الطلب: {ص}" +
                    "\nعزيزي {س}،\n" +
                    "نأسف لإبلاغك بأن طلبك (الرقم: {ص}) تم إلغاؤه. إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";
        else
            return "إلغاء الطلب - رقم الطلب: " + order.getId() +
                    "\nعزيزي " + name + "،\n" +
                    "نأسف لإبلاغك بأن طلبك (الرقم: " + order.getId() + ") تم إلغاؤه. إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";

    }
}
