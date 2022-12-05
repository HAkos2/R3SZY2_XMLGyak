package r3szy2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import org.json.simple.*;

public class ObjectR3SZY2 {
        public static Dictionary parse(File xmlFile) throws ParserConfigurationException,
                                           IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Dictionary dict = new Hashtable();

        Document document = builder.parse(xmlFile);

        NodeList nodeList = document.getElementsByTagName("student");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                Node node1 = elem.getElementsByTagName("nev").item(0);
                String nev = node1.getTextContent();
                Node node2 = elem.getElementsByTagName("neptunkod").item(0);
                String neptunkod = node2.getTextContent();
                Node node3 = elem.getElementsByTagName("szak").item(0);
                String szak = node3.getTextContent();

                dict.put("nev", nev);
                dict.put("szak", szak);
                dict.put("neptunkod", neptunkod);
            }
        }

        return dict;
    }

    public static void toJSON(Dictionary dict)
    {
        System.out.print("{");
        for (Enumeration enm = dict.keys(); enm.hasMoreElements();) {
            Object o = enm.nextElement();
            System.out.print('"' + o.toString() + "\": ");
            System.out.print('"' + dict.get(o).toString() + "\", ");
        }
        System.out.println("}");
    }

    public static void xmlToJSON(String filename) throws XPathExpressionException,
                         ParserConfigurationException, IOException, SAXException {

        XPath xpath = XPathFactory.newInstance().newXPath();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();


        Document document = builder.parse(filename);

        NodeList nodeList = (NodeList)
                            xpath.compile("//*")
                            .evaluate(document, XPathConstants.NODESET);

        JSONObject jsonobj = new JSONObject();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                jsonobj.put(node.getNodeName(), node.getTextContent());
            }
        }
        System.out.println(jsonobj.toJSONString());
    }

}
