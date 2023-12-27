package Application.Utilities.Template;

import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Products.Model.Product;
import Application.Utilities.Template.EmailTemplate.Languages.EmailTemplateFactory;
import Application.Utilities.Template.PhoneTemplate.Languages.PhoneTemplateFactory;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class TemplateFactory {
    public static ITemplate createTemplate(String templateType, String language){
        return switch (templateType) {
            case "SMS" -> PhoneTemplateFactory.getLanguageTemplate(language);
            case "EMAIL" -> EmailTemplateFactory.getLanguageTemplate(language);
            default -> null;
        };
    }

    public static Map.Entry<String, String> createOrderNotification(OrderState state, ITemplate template, String name, List<Product> order)  {
        switch (state) {
            case Placed -> {
                return new AbstractMap.SimpleEntry<>(template.PlaceOrderMessage(name, order, false), template.PlaceOrderMessage(name, order, true));
            }
            case Cancelled -> {
                return new AbstractMap.SimpleEntry<>(template.CancelOrderMessage(name, order, false), template.PlaceOrderMessage(name, order, true));
            }
            case Placement -> {
                return new AbstractMap.SimpleEntry<>(template.PlacementOrderMessage(name, order, false), template.PlacementOrderMessage(name, order, true));
            }
            default -> {
                return null;
            }
        }
    }
}
