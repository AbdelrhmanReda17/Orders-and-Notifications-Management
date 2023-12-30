package Application.Utilities.Template.EmailTemplate.Languages;

import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.EmailTemplate.EmailTemplate;

import java.util.List;

public class EmailTemplateAR extends EmailTemplate {
    @Override
    public String PlaceOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp) {
            return "عزيزي {س} ،نود إعلامك تم تأكيد حجز الطلب الذي يحتوي على المنتج {ص}. شكرًا لتسوقك معنا!";
        } else {
            return "عزيزي " + name + "، نود إعلامك تم تأكيد حجز الطلب الذي يحتوي على المنتج" + (products.size() == 1 ? "" : "ات") +
                    " " + productsString + ".";
        }
    }

    @Override
    public String ShippingOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp) {
            return "عزيزي {س}، نود إعلامك أنه سيتم شحن طلبك للمنتج {ص} في أسرع وقت وسنقوم بإعلامك. شكرًا لتسوقك معنا!";
        } else {
            return "عزيزي " + name + "، نود إعلامك أنه تم إكمال طلبك الذي يحتوي على المنتج" + (products.size() == 1 ? "" : "ات") +
                    " " + productsString + " بنجاح في أسرع وقت. شكرًا لتسوقك معنا!";
        }
    }

    @Override
    public String CancelOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp) {
            return "عزيزي {س} ، نأسف لإبلاغك بأن طلبك الذي يحتوي على المنتج {ص} تم إلغاؤه. إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";
        } else {
            return "عزيزي " + name + "، نأسف لإبلاغك بأن طلبك الذي يحتوي على المنتج" + (products.size() == 1 ? "" : "ات") +
                    " " + productsString + " تم إلغاؤه. إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";
        }
    }

    @Override
    public String CancelShippingOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp) {
            return "عزيزي {س} ، نود إعلامك أنك قمت بإلغاء عملية الشحن لطلبك الذي يحتوي على المنتج {ص}. شكرًا لاختيارك لنا!";
        } else {
            return "عزيزي " + name + "، نود إعلامك أنك قمت بإلغاء عملية الشحن لطلبك الذي يحتوي على المنتج" +
                    (products.size() == 1 ? "" : "ات") + " " + productsString + ". شكرًا لاختيارك لنا!";
        }
    }

    @Override
    public String ShippedOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp) {
            return "عزيزي {س} ، نود إعلامك أن طلبك الذي يحتوي على المنتج {ص} تم شحنه. شكرًا لاختيارك لنا!";
        } else {
            return "عزيزي " + name + "، نود إعلامك أن طلبك الذي يحتوي على المنتج" + (products.size() == 1 ? "" : "ات") +
                    " " + productsString + " تم شحنه. شكرًا لاختيارك لنا!";
        }
    }
}
