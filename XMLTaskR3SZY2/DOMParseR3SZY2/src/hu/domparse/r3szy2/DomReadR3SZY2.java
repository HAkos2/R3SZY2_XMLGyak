package hu.domparse.r3szy2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomReadR3SZY2 {
    private static String getElement(Element element, String name) {
       return element.getElementsByTagName(name).item(0).getTextContent();
    }
    public void parse(File xmlFile) throws ParserConfigurationException,
                                           IOException, SAXException {

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
                    System.out.println("current element: " + node.getNodeName());

                    switch (node.getNodeName()) {
                    case "bankszamla":
                        System.out.println("\tbszkod: " +
                                el.getAttribute("bszkod"));
                        System.out.println("\tszamlaszam: " +
                                DomReadR3SZY2.getElement(el, "szamlaszam"));
                        System.out.println("\tegyenleg: " +
                                DomReadR3SZY2.getElement(el, "egyenleg"));
                        break;
                    case "szamlatulajdonos":
                        System.out.println("\tsztkod: " +
                                el.getAttribute("sztkod"));
                        System.out.println("\tnev: " +
                                DomReadR3SZY2.getElement(el, "nev"));
                        Element el1 = (Element) el.getElementsByTagName("lakcim").item(0);
                        System.out.println("\tirsz: " +
                                DomReadR3SZY2.getElement(el1, "irsz"));
                        System.out.println("\tvaros: " +
                                DomReadR3SZY2.getElement(el1, "varos"));
                        System.out.println("\tutca: " +
                                DomReadR3SZY2.getElement(el1, "utca"));
                        System.out.println("\thazszam: " +
                                DomReadR3SZY2.getElement(el1, "hazszam"));
                        break;
                    case "tulajdonos":
                        System.out.println("\tsz_fk: " +
                                el.getAttribute("bsz_fk"));
                        System.out.println("\tszt_fk: " +
                                el.getAttribute("szt_fk"));
                        break;
                    case "bankkartya":
                        System.out.println("\tbkkod: " +
                                el.getAttribute("bkkod"));
                        System.out.println("\tkartyaszam: " +
                                DomReadR3SZY2.getElement(el, "kartyaszam"));
                        System.out.println("\tlejarati_datum: " +
                                DomReadR3SZY2.getElement(el, "lejarati_datum"));
                        System.out.println("\tcvv: " +
                                DomReadR3SZY2.getElement(el, "cvv"));
                        break;
                    case "tranzakcio":
                        System.out.println("\ttkod: " +
                                el.getAttribute("tkod"));
                        System.out.println("\tbsz_fk: " +
                                el.getAttribute("bsz_fk"));
                        System.out.println("\tkuldo_sz: " +
                                DomReadR3SZY2.getElement(el, "kuldo_sz"));
                        System.out.println("\tfogado_sz: " +
                                DomReadR3SZY2.getElement(el, "fogado_sz"));
                        System.out.println("\tosszeg: " +
                                DomReadR3SZY2.getElement(el, "osszeg"));
                        System.out.println("\tdatum: " +
                                DomReadR3SZY2.getElement(el, "datum"));
                        break;
                    case "bankfiok":
                        System.out.println("\tbfkod: " +
                                el.getAttribute("bfkod"));
                        Element el2 = (Element) el.getElementsByTagName("cim").item(0);
                        System.out.println("\tirsz: " +
                                DomReadR3SZY2.getElement(el2, "irsz"));
                        System.out.println("\tvaros: " +
                                DomReadR3SZY2.getElement(el2, "varos"));
                        System.out.println("\tutca: " +
                                DomReadR3SZY2.getElement(el2, "utca"));
                        System.out.println("\thazszam: " +
                                DomReadR3SZY2.getElement(el2, "hazszam"));
                        break;
                    case "munkavallalo":
                        System.out.println("\tmvkod: " +
                                el.getAttribute("mvkod"));
                        System.out.println("\tbf_fk: " +
                                el.getAttribute("bf_fk"));
                        System.out.println("\tnev: " +
                                DomReadR3SZY2.getElement(el, "nev"));
                        System.out.println("\ttelefonszam: " +
                                DomReadR3SZY2.getElement(el, "telefonszam"));
                        System.out.println("\tfizetes: " +
                                DomReadR3SZY2.getElement(el, "fizetes"));
                        System.out.println("\tpozicio: " +
                                DomReadR3SZY2.getElement(el, "pozicio"));
                        break;
                    }
                }
            }
        }
    }
}