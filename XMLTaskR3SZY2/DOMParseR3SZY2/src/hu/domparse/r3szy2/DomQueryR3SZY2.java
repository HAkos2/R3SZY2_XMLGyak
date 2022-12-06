package hu.domparse.r3szy2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DomQueryR3SZY2 {
    private static String getElement(Element element, String name) {
        return element.getElementsByTagName(name).item(0).getTextContent();
    }
    public void query(File xmlFile, String elementName) throws ParserConfigurationException,
            IOException, SAXException {

        boolean found = false;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        ArrayList<NodeList> nodeLists = new ArrayList<NodeList>();
        nodeLists.add(document.getElementsByTagName("bankszamla"));
        nodeLists.add(document.getElementsByTagName("szamlatulajdonos"));
        nodeLists.add(document.getElementsByTagName("tulajdonos"));
        nodeLists.add(document.getElementsByTagName("bankkartya"));
        nodeLists.add(document.getElementsByTagName("tranzakcio"));
        nodeLists.add(document.getElementsByTagName("bankfiok"));
        nodeLists.add(document.getElementsByTagName("munkavallalo"));

        for (int i = 0; i < nodeLists.size(); i++) {
            NodeList nodeList = nodeLists.get(i);

            for (int j = 0; j < nodeList.getLength(); j++) {
                Node node = nodeList.item(j);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    NodeList nodeList1  = el.getElementsByTagName(elementName);
                    if (nodeList1.getLength() > 0) {
                        System.out.println("found element \"" + elementName +
                                "\": " + nodeList1.item(0).getTextContent());
                        found = true;
                    }
                }
            }
        }
        if (!found) {
           System.out.println("did not find element \"" + elementName + "\"");
        }
    }
}
