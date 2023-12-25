package Application.Template.EmailTemplate.Languages;

import Application.APIS.Orders.Model.Order;
import Application.Template.EmailTemplate.EmailTemplate;

public class EmailTemplateAR implements EmailTemplate {

    @Override
    public String getWelcomeMessage(String name) {
        return " مرحبًا في متجرنا، " + name;

    }

    @Override
    public String getExitMessage(String name) {
        return " شكرًا لزيارة متجرنا، " + name;
    }

    @Override
    public String OrderMessage(String name, Order order) {
        return "الموضوع: تأكيد الطلب - رقم الطلب: " + order.getId() +
                "\n\nعزيزي " + name + "،\n\n" +
                "تم تأكيد طلبك. رقم الطلب: " + order.getId() +
                "\nشكرًا لتسوقك معنا!";
    }

    @Override
    public String FinishOrderMessage(String name, Order order) {
        return "الموضوع: اكتمال الطلب - رقم الطلب: " + order.getId() +
                "\n\nمرحبًا " + name + "،\n\n" +
                "تم إكمال طلبك (الرقم: " + order.getId() + ") بنجاح. شكرًا لاختيارك لنا!";
    }

    @Override
    public String getErrorMessage(String name) {
        return "الموضوع: خطأ في معالجة الطلب - " + name +
                "\n\nعزيزي " + name + "،\n\n" +
                "نعتذر، ولكن حدث خطأ أثناء معالجة طلبك. يرجى الاتصال بخدمة العملاء للمساعدة.";
    }

    @Override
    public String CancelOrderMessage(String name, Order order) {
        return "الموضوع: إلغاء الطلب - رقم الطلب: " + order.getId() +
                "\n\nعزيزي " + name + "،\n\n" +
                "نأسف لإبلاغك أن طلبك (الرقم: " + order.getId() + ") تم إلغاؤه.\n" +
                "إذا كان لديك أي أسئلة أو استفسارات، يرجى الاتصال بدعم العملاء لدينا.\n" +
                "شكرًا لتفهمك.";
    }
}
