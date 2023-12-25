package Application.Template.PhoneTemplate.Languages;

import Application.APIS.Orders.Model.Order;
import Application.Template.PhoneTemplate.PhoneTemplate;

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
    public String OrderMessage(String name, Order order) {
        return "، تم تأكيد حجز الطلب برقم: " + order.getId() + ".";
    }

    @Override
    public String FinishOrderMessage(String name, Order order) {
        return "مرحبًا " + name + "، تم إكمال طلبك (الرقم: " + order.getId() + ") بنجاح. شكرًا لتسوقك معنا!";
    }

    @Override
    public String getErrorMessage(String name) {
        return name + "، يرجى التحقق من رصيدك. غير قادر على معالجة الطلب في الوقت الحالي.";
    }
}
