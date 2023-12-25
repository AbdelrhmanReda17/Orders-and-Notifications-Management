package Application.Template.PhoneTemplate.Languages;
import Application.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateFactory {
    public static PhoneTemplate getLanguageTemplate(String language) {
        if (language.equals("EN")) {
            return new PhoneTemplateEN();
        } else if (language.equals("AR")) {
            return new PhoneTemplateAR();
        } else {
            return null;
        }
    }
}
