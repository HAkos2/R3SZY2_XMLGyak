package domr3szy2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DOMModifyR3SZY2 {
    public void parse(String path) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        File inputFile = new File(path);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(inputFile);

        Node cars = doc.getFirstChild();
        Node supercar = doc.getElementsByTagName("supercars").item(0);

        NamedNodeMap attr = supercar.getAttributes();
        Node nodeAttr = attr.getNamedItem("company");
        nodeAttr.setTextContent("Lamborghini");

        NodeList list = supercar.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                if ("carname".equals(el.getNodeName())) {
                    if ("Ferrari 01".equals(el.getTextContent())) {
                        el.setTextContent("Lamborghini 01");
                    }
                    if ("Ferrari 02".equals(el.getTextContent())) {
                        el.setTextContent("Lamborghini 02");
                    }
                }
            }
        }
        NodeList childNodes = cars.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            if ("luxurycars".equals(node.getNodeName()))
                cars.removeChild(node);
        }

        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer transformer = tfactory.newTransformer();

        DOMSource source = new DOMSource(doc);

        System.out.println("-- Modositott fajl --");
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);

    }

}
