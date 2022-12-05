package hu.domparse.r3szy2;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DomReadR3SZY2 domReadR3SZY2 = new DomReadR3SZY2();
        domReadR3SZY2.parse(new File("XMLR3SZY2.xml"));

        DomQueryR3SZY2 domQueryR3SZY2 = new DomQueryR3SZY2();
        domQueryR3SZY2.query(new File("XMLR3SZY2.xml"), "nev");

        DomModifyR3SZY2 domModifyR3SZY2 = new DomModifyR3SZY2();
        domModifyR3SZY2.modify(new File("XMLR3SZY2.xml"));
    }
}