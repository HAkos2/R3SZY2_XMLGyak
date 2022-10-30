package org.example;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "/home/koma/devel/R3SZY2_XMLGyak/R3SZY2_0928/HA_Kurzusfelvetel.xml";
        String path = new File(filename).getAbsolutePath();

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = parserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        XMLReader xmlReader = null;
        try {
            xmlReader = parser.getXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        xmlReader.setContentHandler(new SaxR3SZY2());
        try {
            xmlReader.parse(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}