package Application.Template;

import Application.Template.EmailTemplate.Languages.EmailTemplateFactory;
import Application.Template.PhoneTemplate.Languages.PhoneTemplateFactory;

public class TemplateFactory {
    public static ITemplate createTemplate(String templateType , String language){
        return switch (templateType) {
            case "SMS" -> PhoneTemplateFactory.getLanguageTemplate(language);
            case "EMAIL" -> EmailTemplateFactory.getLanguageTemplate(language);
            default -> null;
        };
    }
}
