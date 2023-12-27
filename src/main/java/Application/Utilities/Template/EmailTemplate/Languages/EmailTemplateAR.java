package Application.Utilities.Template.EmailTemplate.Languages;


import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.EmailTemplate.EmailTemplate;

import java.util.List;

public class EmailTemplateAR extends EmailTemplate{
    @Override
    public String PlaceOrderMessage(String name, List<Product> products , boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp) {
            return "عزيزي {س} ، تم تأكيد حجز  الطلب للمنتج {ص}. شكرًا لتسوقك معنا!";
        } else {
            return "عزيزي" + name + "، تم تأكيد حجز الطلب " + "للمنتج" + (products.size() == 1 ? " " : "ات ")  + productsString  + ".";
        }
    }

    @Override
    public String PlacementOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp) {
            return "عزيزي {س} ، تم أكمال طلبك للمنتج {ص} بنجاح. شكرًا لتسوقك معنا!";
        } else {
            return "عزيزي" + name + "، تم إكمال طلبك " + "للمنتج" + (products.size() == 1 ? " " : "ات ")  + productsString  + " بنجاح. شكرًا لتسوقك معنا!";
        }
    }

    @Override
    public String CancelOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp) {
            return "عزيزي {س} ، نأسف لإبلاغك بأن طلبك للمنتج {ص} تم إلغاؤه. إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";
        } else {
            return "عزيزي" + name + "، نأسف لإبلاغك بأن طلبك " + "للمنتج" + (products.size() == 1 ? " " : "ات ") + productsString + " تم إلغاؤه. إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";
        }
    }
}
