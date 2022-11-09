package xpathr3szy2;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        xpathR3SZY2 xpath = new xpathR3SZY2("studentR3SZY2.xml");
        xpath.parse("//*");
    }
}