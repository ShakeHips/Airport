package com.solvd.airport.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class BookingHandler extends DefaultHandler {
    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\ПК\\IdeaProjects\\Airport\\src\\main\\resources\\parserFiles\\booking.xml";
        File input = new File(file);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        BookingHandler handler = new BookingHandler();
        saxParser.parse(input, handler);
    }

    boolean seat = false;
    boolean price = false;
    boolean bookingid = false;


    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes){
        if(qName.equalsIgnoreCase("Booking")){
            String id = attributes.getValue("id");
            System.out.println("id " + id);
        } else if (qName.equalsIgnoreCase("Seat")) {
            seat = true;
        } else if (qName.equalsIgnoreCase("Price")) {
            price = true;
        } else if (qName.equalsIgnoreCase("BookingID")) {
            bookingid = true;
        }
    }

    @Override
    public void characters(char ch[],
                           int start,
                           int length){
        if(seat){
            System.out.println("Booked seat is " + new String (ch, start, length));
            seat = false;
        } else if (price){
            System.out.println("Booked price is " + new String (ch, start,length));
            price = false;
        } else if (bookingid){
            System.out.println("Id of the order " + new String (ch, start,length));
            bookingid = false;
        }
    }
}
