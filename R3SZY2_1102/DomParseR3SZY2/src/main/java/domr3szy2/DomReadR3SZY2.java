package domr3szy2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomReadR3SZY2 {
    public void parse(File xmlFile) throws ParserConfigurationException,
                                           IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();


        Document document = builder.parse(xmlFile);

        NodeList nodeList = document.getElementsByTagName("user");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                String id = elem.getAttribute("id");

                Node node1 = elem.getElementsByTagName("firstname").item(0);
                String fname = node1.getTextContent();
                Node node2 = elem.getElementsByTagName("lastname").item(0);
                String lname = node1.getTextContent();
                Node node3 = elem.getElementsByTagName("profession").item(0);
                String profession = node1.getTextContent();

                System.out.println();
                System.out.println();
                System.out.println();
            }
        }
    }

}
