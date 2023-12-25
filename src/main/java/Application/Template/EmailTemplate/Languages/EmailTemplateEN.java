package Application.Template.EmailTemplate.Languages;

import Application.APIS.Orders.Model.Order;
import Application.Template.EmailTemplate.EmailTemplate;

public class EmailTemplateEN implements EmailTemplate {
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
