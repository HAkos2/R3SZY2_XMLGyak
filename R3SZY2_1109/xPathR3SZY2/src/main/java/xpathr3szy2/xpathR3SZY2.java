package xpathr3szy2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.IOException;

public class xpathR3SZY2 {
    private String path;
    private Document document;
    public xpathR3SZY2(String path) throws ParserConfigurationException, IOException, SAXException {

        this.path = path;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();


        this.document = builder.parse(this.path);

        this.document.getDocumentElement().normalize();
    }
    public void parse(String expression) throws XPathExpressionException {

        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nodeList = (NodeList)
                            xpath.compile(expression)
                            .evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            //System.out.println("Aktualis elem: " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
                Element el = (Element) node;

                System.out.println("Hallgato id: " + el.getAttribute("id"));

                System.out.println("Keresztnev: " +
                                   el.getElementsByTagName("firstname").item(0).getTextContent());

                System.out.println("Vezeteknev: " +
                                   el.getElementsByTagName("lastname").item(0).getTextContent());

                System.out.println("Becenev: " +
                        el.getElementsByTagName("nickname").item(0).getTextContent());

                System.out.println("Kor: " +
                        el.getElementsByTagName("age").item(0).getTextContent());
            }
        }
    }
}
