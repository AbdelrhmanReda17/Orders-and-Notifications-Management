package Application.Utilities.Template.EmailTemplate.Languages;

import Application.Utilities.Template.EmailTemplate.EmailTemplate;

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
