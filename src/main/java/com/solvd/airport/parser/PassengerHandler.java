package com.solvd.airport.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class PassengerHandler extends DefaultHandler {
    public static void main(String[] args) throws Exception{
        String file = "C:\\Users\\ПК\\IdeaProjects\\Airport\\src\\main\\resources\\parserFiles\\passenger.xml";
        File input = new File(file);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        PassengerHandler handler = new PassengerHandler();
        saxParser.parse(input, handler);
    }

    boolean name = false;
    boolean bookingid = false;
    boolean luggageid = false;
    boolean age = false;

    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes){
        if(qName.equalsIgnoreCase("Passenger")){
            String id = attributes.getValue("id");
            System.out.println("id " + id);
        } else if (qName.equalsIgnoreCase("Name")) {
            name = true;
        } else if (qName.equalsIgnoreCase("BookingID")) {
            bookingid = true;
        } else if (qName.equalsIgnoreCase("LuggageID")) {
            luggageid = true;
        }else if (qName.equalsIgnoreCase("Age")) {
            age = true;
        }
    }

    @Override
    public void characters(char ch[],
                           int start,
                           int length){
        if(name){
            System.out.println("Passengers name is " + new String (ch, start, length));
            name = false;
        } else if (bookingid){
            System.out.println("Passengers booking id is " + new String (ch, start,length));
            bookingid = false;
        } else if (luggageid){
            System.out.println("Passengers Luggage id is " + new String (ch, start,length));
            luggageid = false;
        } else if (age){
            System.out.println("Passengers Age is " + new String (ch, start,length));
            age = false;
        }
    }
}
