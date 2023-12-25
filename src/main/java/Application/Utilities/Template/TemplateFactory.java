package Application.Utilities.Template;

import Application.Utilities.Template.EmailTemplate.Languages.EmailTemplateFactory;
import Application.Utilities.Template.PhoneTemplate.Languages.PhoneTemplateFactory;

public class TemplateFactory {
    public static ITemplate createTemplate(String templateType , String language){
        return switch (templateType) {
            case "SMS" -> PhoneTemplateFactory.getLanguageTemplate(language);
            case "EMAIL" -> EmailTemplateFactory.getLanguageTemplate(language);
            default -> null;
        };
    }
}
