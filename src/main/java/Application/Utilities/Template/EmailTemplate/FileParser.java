package Application.Utilities.Template.EmailTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {

    public static String parse(String msg ,File lang) throws FileNotFoundException {
        Scanner myReader = new Scanner(lang);
        String data="";
        while (myReader.hasNextLine()) {
         data = myReader.nextLine();
            if(data==msg){
                data = myReader.nextLine();
                break;
            }

        }
        myReader.close();
        return data;
    }

}
