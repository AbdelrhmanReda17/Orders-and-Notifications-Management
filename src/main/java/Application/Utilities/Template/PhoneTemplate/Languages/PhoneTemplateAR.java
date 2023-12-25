package Application.Utilities.Template.PhoneTemplate.Languages;

import Application.APIS.Orders.Model.SimpleOrder;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateAR implements PhoneTemplate {

    @Override
    public String getWelcomeMessage(String name) {
        return name + "مرحبا بك في متجرنا. ";
    }

    @Override
    public String getExitMessage(String name) {
        return "شكرًا لاستخدام متجرنا، " + name + "!";
    }

    @Override
    public String OrderMessage(String name, SimpleOrder order) {
        return "، تم تأكيد حجز الطلب برقم: " + order.getId() + ".";
    }

    @Override
    public String FinishOrderMessage(String name, SimpleOrder order) {
        return "مرحبًا " + name + "، تم إكمال طلبك (الرقم: " + order.getId() + ") بنجاح. شكرًا لتسوقك معنا!";
    }

    @Override
    public String getErrorMessage(String name) {
        return name + "، يرجى التحقق من رصيدك. غير قادر على معالجة الطلب في الوقت الحالي.";
    }

    @Override
    public String CancelOrderMessage(String name, SimpleOrder order) {
        return "إلغاء الطلب - رقم الطلب: " + order.getId() +
                "\nعزيزي " + name + "،\n" +
                "نأسف لإبلاغك بأن طلبك (الرقم: " + order.getId() + ") تم إلغاؤه. إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";

    }
}
