package r3szy2;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, ParseException, XPathExpressionException {
        Dictionary dict = ObjectR3SZY2.parse(new File("JSONR3SZY2.xml"));
        ObjectR3SZY2.toJSON(dict);

        JSONReadR3SZY2.readJSON("vizsgakR3SZY2.json");
        JSONWriteR3SZY2.writeJSON();

        ObjectR3SZY2.xmlToJSON("JSONR3SZY2.xml");
    }
}