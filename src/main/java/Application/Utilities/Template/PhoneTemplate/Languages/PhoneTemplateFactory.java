package Application.Utilities.Template.PhoneTemplate.Languages;
import Application.Utilities.Template.PhoneTemplate.PhoneTemplate;

public class PhoneTemplateFactory {
    public static PhoneTemplate getLanguageTemplate(String language) {
        if (language.equals("EN.txt")) {
            return new PhoneTemplateEN();
        } else if (language.equals("AR")) {
            return new PhoneTemplateAR();
        } else {
            return null;
        }
    }
}
