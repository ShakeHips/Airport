package com.solvd.airport.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class LuggageHandler extends DefaultHandler {
    public static void main(String[] args) throws Exception{
        String file = "src/main/resources/parserFiles/luggage.xml";
        File input = new File(file);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        LuggageHandler handler = new LuggageHandler();
        saxParser.parse(input, handler);
    }

    boolean weight = false;
    boolean type = false;


    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes){
        if(qName.equalsIgnoreCase("Luggage")){
            String id = attributes.getValue("id");
            System.out.println("id " + id);
        } else if (qName.equalsIgnoreCase("Weight")) {
            weight = true;
        } else if (qName.equalsIgnoreCase("Type")) {
            type = true;
        }
    }

    @Override
    public void characters(char ch[],
                           int start,
                           int length){
        if(weight){
            System.out.println("Luggage weight is " + new String (ch, start, length));
            weight = false;
        } else if (type){
            System.out.println("Luggage type is " + new String (ch, start,length));
            type = false;
        }
    }
}
