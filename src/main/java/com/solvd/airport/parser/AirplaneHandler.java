package com.solvd.airport.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class AirplaneHandler extends DefaultHandler {
    public static void main(String[] args) throws Exception{
        String file = "C:\\Users\\ПК\\IdeaProjects\\Airport\\src\\main\\resources\\parserFiles\\airplane.xml";
        File input = new File(file);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        AirplaneHandler handler = new AirplaneHandler();
        saxParser.parse(input, handler);
    }

    boolean capacity = false;
    boolean airline = false;


    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes){
        if(qName.equalsIgnoreCase("Airplane")){
            String id = attributes.getValue("id");
            System.out.println("id " + id);
        } else if (qName.equalsIgnoreCase("Capacity")) {
            capacity = true;
        } else if (qName.equalsIgnoreCase("Airline")) {
            airline = true;
        }
    }

    @Override
    public void characters(char ch[],
                           int start,
                           int length){
        if(capacity){
            System.out.println("Airplane's capacity is " + new String (ch, start, length));
            capacity = false;
        } else if (airline){
            System.out.println("Airplane's Airline is " + new String (ch, start,length));
            airline = false;
        }
    }
}
