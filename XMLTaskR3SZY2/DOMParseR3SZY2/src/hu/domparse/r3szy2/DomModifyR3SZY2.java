package hu.domparse.r3szy2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class DomModifyR3SZY2 {
    public void modify(File file) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(file);

        NodeList bankszamla = doc.getElementsByTagName("bankszamla");
        Node root = doc.getFirstChild();


        // elso bankszamla elem bszkod attributum modositasa
        NamedNodeMap attr = bankszamla.item(0).getAttributes();
        Node nodeAttr = attr.getNamedItem("bszkod");
        nodeAttr.setTextContent("01");

        NodeList list = bankszamla.item(0).getChildNodes();

        for (int i = 0; i < bankszamla.getLength(); i++) {
            NodeList children = bankszamla.item(i).getChildNodes();
            for (int j = 0; j < children.getLength(); j++) {
               Node node = children.item(j);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;

                    if ("egyenleg".equals(el.getNodeName())) {
                        Element parent = (Element) el.getParentNode();

                    // "2" bszkodu bankszamla egyenlegenek modositasa
                        if ((parent.getAttribute("bszkod").equals("2"))) {
                            el.setTextContent("30000");
                        }
                    // "3" bszkodu bankszamla egyenlegenek modositasa
                        if ((parent.getAttribute("bszkod").equals("3"))) {
                            el.setTextContent("195000");
                        }
                    }
                }
            }
        }

        // elso bankkartya elem kitorlese
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            if ("bankkartya".equals(node.getNodeName())) {
                root.removeChild(node);
                break;
            }
        }

        //kiiras konzolra, fajlba iras
        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer transformer = tfactory.newTransformer();

        DOMSource source = new DOMSource(doc);

        System.out.println("-- Modositott fajl --");
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
        
        FileWriter writer = new FileWriter(new File("out.xml"));
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
    }
}
