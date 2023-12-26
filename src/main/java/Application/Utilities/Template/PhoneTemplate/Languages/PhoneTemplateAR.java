package Application.Utilities.Template.PhoneTemplate.Languages;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateAR implements PhoneTemplate {

    @Override
    public String getWelcomeMessage(String name , boolean isTemp) {
        if(isTemp)
            return " مرحبًا في متجرنا , {س}";
        else
            return " مرحبًا في متجرنا، " + name;
    }

    @Override
    public String getExitMessage(String name , boolean isTemp) {
        if(isTemp)
            return "شكرًا لزيارة متجرنا , {س}";
        else
            return "شكرًا لزيارة متجرنا، " + name;
    }

    @Override
    public String OrderMessage(String name, IOrder order , boolean isTemp) {
        if(isTemp){
            return "، تم تأكيد حجز الطلب برقم: {س}.";
        }else{
            return "، تم تأكيد حجز الطلب برقم: " + order.getId() + ".";
        }
    }

    @Override
    public String FinishOrderMessage(String name, IOrder order , boolean isTemp) {
        if (isTemp){
            return "، تم إكمال طلبك (الرقم: {ص}) بنجاح. شكرًا لتسوقك معنا!";
        }else{
            return "، تم إكمال طلبك (الرقم: " + order.getId() + ") بنجاح. شكرًا لتسوقك معنا!";
        }
    }

    @Override
    public String getErrorMessage(String name , boolean isTemp) {
        if(isTemp)
            return "، يرجى التحقق من رصيدك. غير قادر على معالجة الطلب في الوقت الحالي.";
        else
            return "، يرجى التحقق من رصيدك. غير قادر على معالجة الطلب في الوقت الحالي.";
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
