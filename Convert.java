package start;
import no.acando.xmltordf.Builder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Convert {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        File file = new File("C:/Users/Ankit Ramrakhyani/Desktop/New folder/first/src/main/java/start/input.xml");
        File fie = new File("C:/Users/Ankit Ramrakhyani/Desktop/New folder/first/src/main/java/start/output.ttl");

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fie));

        Builder.getAdvancedBuilderStream().build().convertToStream(in, out);

    }

}
