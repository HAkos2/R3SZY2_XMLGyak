package domr3szy2;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomWriteR3SZY2 {

    private static Node createUserElement(Document doc, String tagname, String str) {
        Element element = doc.createElement(tagname);
        element.appendChild(doc.createTextNode(str));

        return element;
    }
    private static Node createUser(Document doc, String id, String firstname,
                                   String lastname, String profession) {
        Element user = doc.createElement("user");
        user.setAttribute("id", id);
        user.appendChild(createUserElement(doc, "firstname", firstname));
        user.appendChild(createUserElement(doc, "lastname", lastname));
        user.appendChild(createUserElement(doc, "profession", profession));

        return user;
    }
    public void write(String filename) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.newDocument();
        Element root = doc.createElementNS("DomR3SZY2", "users");

        doc.appendChild(root);

        root.appendChild(createUser(doc, "1", "Akos", "Horvath", "a"));
        root.appendChild(createUser(doc, "2", "Kiss", "Istvan", "b"));
        root.appendChild(createUser(doc, "3", "Nagy", "Bela", "c"));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);

        File file = new File(filename);

        StreamResult stdout = new StreamResult(System.out);
        StreamResult fileResult = new StreamResult(file);

        transformer.transform(source, stdout);
        transformer.transform(source, fileResult);
    }
}
