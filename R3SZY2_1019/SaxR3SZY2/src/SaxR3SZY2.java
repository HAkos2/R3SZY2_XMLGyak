package org.example;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.Arrays;
import java.util.Hashtable;

public class SaxR3SZY2 extends DefaultHandler {
    private Hashtable tags;
    @Override
    public void startDocument() throws SAXException {
    }
    private boolean insideTag;

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        insideTag = true;
        if (atts.getLength() == 0) {
            System.out.println(qName + " start");
            return;
        }

        System.out.print(qName + ", {");
        for (int i = 0; i < atts.getLength(); i++) {
            if (i == atts.getLength()-1) {
                System.out.print(atts.getQName(i) + "=" + atts.getValue(i));
            } else {
                System.out.print(atts.getQName(i) + "=" + atts.getValue(i) + ", ");
            }
        }
        System.out.println("} start");
    }

    @Override
    public void endElement(String uri, String localName,
                             String qName) throws SAXException {
        insideTag = false;
        System.out.println("end " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (insideTag) {
            System.out.println(Arrays.copyOfRange(ch, start, start+length));
        }
    }
}
