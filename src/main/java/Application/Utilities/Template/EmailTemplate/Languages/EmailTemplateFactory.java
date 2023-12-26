package Application.Utilities.Template.EmailTemplate.Languages;

import Application.Utilities.Template.EmailTemplate.EmailTemplate;
import Application.Utilities.Template.EmailTemplate.Languages.EmailTemplateEN;

import java.io.FileNotFoundException;

public class EmailTemplateFactory {
    public static EmailTemplate getLanguageTemplate(String language) throws FileNotFoundException {
        if (language.equals("EN.txt")) {
            return new EmailTemplateEN();
        } else if (language.equals("AR")) {
            return new EmailTemplateEN();
        } else {
            return null;
        }
    }
}
