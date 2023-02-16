package com.solvd.airport.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class EmployeeHandler extends DefaultHandler {
    public static void main(String[] args) throws Exception{
        String file = "C:\\Users\\ПК\\IdeaProjects\\Airport\\src\\main\\resources\\parserFiles\\employee.xml";
        File input = new File(file);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        EmployeeHandler handler = new EmployeeHandler();
        saxParser.parse(input, handler);
    }

    boolean position = false;
    boolean name = false;
    boolean airplaneid = false;


    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes){
        if(qName.equalsIgnoreCase("Employee")){
            String id = attributes.getValue("id");
            System.out.println("id " + id);
        } else if (qName.equalsIgnoreCase("Position")) {
            position = true;
        } else if (qName.equalsIgnoreCase("Name")) {
            name = true;
        } else if (qName.equalsIgnoreCase("AirplaneID")) {
            airplaneid = true;
        }
    }

    @Override
    public void characters(char ch[],
                           int start,
                           int length){
        if(position){
            System.out.println("Emp position is " + new String (ch, start, length));
            position = false;
        } else if (name){
            System.out.println("Emp name is " + new String (ch, start,length));
            name = false;
        } else if (name){
            System.out.println("Emp plane id is " + new String (ch, start,length));
            airplaneid = false;
        }
    }
}
