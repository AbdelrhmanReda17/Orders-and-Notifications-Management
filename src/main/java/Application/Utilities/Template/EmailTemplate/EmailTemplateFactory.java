package Application.Utilities.Template.EmailTemplate;

import Application.Utilities.Template.EmailTemplate.EmailTemplate;
import Application.Utilities.Template.EmailTemplate.EmailTemplateAR;
import Application.Utilities.Template.EmailTemplate.EmailTemplateEN;

import java.io.FileNotFoundException;

public class EmailTemplateFactory {
    public static EmailTemplate getLanguageTemplate(String language) throws FileNotFoundException {
        if (language.equals("EN.txt")) {
            return new EmailTemplateEN("EN.txt");
        } else if (language.equals("AR")) {
            return new EmailTemplateAR();
        } else {
            return null;
        }
    }
}
