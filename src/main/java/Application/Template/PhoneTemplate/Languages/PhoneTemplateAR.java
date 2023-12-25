package Application.Template.PhoneTemplate.Languages;

import Application.APIS.Orders.Model.Order;
import Application.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateAR implements PhoneTemplate {

    @Override
    public String getWelcomeMessage(String name) {
        return null;
    }

    @Override
    public String getExitMessage(String name) {
        return null;
    }

    @Override
    public String OrderMessage(String name, Order order) {
        return null;
    }

    @Override
    public String FinishOrderMessage(String name, Order order) {
        return null;
    }

    @Override
    public String getErrorMessage(String name) {
        return null;
    }
}
