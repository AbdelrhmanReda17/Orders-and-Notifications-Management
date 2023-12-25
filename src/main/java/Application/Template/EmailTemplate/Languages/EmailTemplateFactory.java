package Application.Template.EmailTemplate.Languages;

import Application.Template.EmailTemplate.EmailTemplate;
import Application.Template.PhoneTemplate.Languages.PhoneTemplateAR;

public class EmailTemplateFactory {
    public static EmailTemplate getLanguageTemplate(String language) {
        if (language.equals("EN")) {
            return new EmailTemplateEN();
        } else if (language.equals("AR")) {
            return new EmailTemplateAR();
        } else {
            return null;
        }
    }
}
