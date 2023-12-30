package Application.Utilities.Template.PhoneTemplate.Languages;

import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

import java.util.List;

public class PhoneTemplateAR extends PhoneTemplate {
    @Override
    public String PlaceOrderMessage(String name, List<Product> products , boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if(isTemp){
            return "تم تأكيد حجز طلبك للمنتج {ص}, شكرًا لتسوقك معنا!";
        }else{
            return " تم تأكيد حجز الطلب " + "للمنتج" + (products.size() == 1 ? " " : "ات ")  + productsString  + ".";
        }
    }
    @Override
    public String PlacementOrderMessage(String name, List<Product> products , boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if (isTemp){
            return "تم إكمال طلبك للمنتج {ص} بنجاح, شكرًا لتسوقك معنا!";
        }else{
            return "، تم إكمال طلبك " + "للمنتج" + (products.size() == 1 ? " " : "ات ")  + productsString  + " بنجاح. شكرًا لتسوقك معنا!";

        }
    }
    @Override
    public String CancelOrderMessage(String name, List<Product> products, boolean isTemp) {
        StringBuilder productsString = GetProductList(products);
        if(isTemp)
            return "نأسف لإبلاغك بأن طلبك للمنتج {ص} تم إلغاؤه, إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";
        else
            return "نأسف لإبلاغك بأن طلبك " + "للمنتج" + (products.size() == 1 ? " " : "ات ")  + productsString  + "تم إلغاؤه. إذا كانت لديك أسئلة، يرجى التواصل مع الدعم. شكرًا لك.";

    }

    @Override
    public String CancelShippingOrderMessage(String name, List<Product> products, boolean isTemp) {
        return "CancelShippingOrderMessage";
    }
}
