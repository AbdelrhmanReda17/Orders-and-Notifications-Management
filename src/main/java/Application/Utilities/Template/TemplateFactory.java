package Application.Utilities.Template;

import Application.APIS.Orders.Model.IOrder;
import Application.Utilities.Template.EmailTemplate.Languages.EmailTemplateFactory;
import Application.Utilities.Template.PhoneTemplate.Languages.PhoneTemplateFactory;

import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.Map;

public class TemplateFactory {
    public static ITemplate createTemplate(String templateType, String language) throws FileNotFoundException {
        return switch (templateType) {
            case "SMS" -> PhoneTemplateFactory.getLanguageTemplate(language);
            case "EMAIL" -> EmailTemplateFactory.getLanguageTemplate(language);
            default -> null;
        };
    }

    public static Map.Entry<String, String> createOrderNotification(ITemplate template, String messageType, String name, IOrder order) throws FileNotFoundException {
        switch (messageType) {
            case "Placed" -> {
                return new AbstractMap.SimpleEntry<>(template.PlaceOrderMessage(name, order, false), template.PlaceOrderMessage(name, order, true));
            }
            case "Canceled" -> {
                return new AbstractMap.SimpleEntry<>(template.CancelOrderMessage(name, order, false), template.PlaceOrderMessage(name, order, true));
            }
            case "Placement" -> {
                return new AbstractMap.SimpleEntry<>(template.PlacementOrderMessage(name, order, false), template.PlacementOrderMessage(name, order, true));
            }
            default -> {
                return null;
            }
        }
    }
}
