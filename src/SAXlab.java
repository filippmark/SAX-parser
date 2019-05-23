import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SAXlab {
    private static ArrayList<User> users = new ArrayList<>();
    public static int amount = 0;
    public static int counter = 0;
    private  static  String pathToSmall = "C:\\Users\\lenovo\\Desktop\\4 сем\\ООП\\ЛР7\\feed-test.xml";
    private  static  String path = "C:\\Users\\lenovo\\Desktop\\4 сем\\ООП\\feed.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("Enter amount of skills please!");
        Scanner in = new Scanner(System.in);
        amount = in.nextInt();


        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler xmlHandler = new XMLHandler();
        parser.parse(new File(pathToSmall), xmlHandler);
        System.out.println(counter);
    }

    private static class XMLHandler extends DefaultHandler {
        ArrayList<String> skills = new ArrayList<String>();
        String UID, name, email;
        String city, address, gender, phone;
        String lastElement;
        String information;

        @Override
        public void startDocument() throws SAXException {

        }

        @Override
        public void endDocument() throws SAXException {

        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equals("skill"))
                skills.add(information);
            if(qName.equals("user")){
                if (email.endsWith(".biz") && (skills.size() > amount)){
                    counter++;
                }
                UID = null;
                name = null;
                email = null;
                city = null;
                address = null;
                gender = null;
                phone = null;
                skills = new ArrayList<String>();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                switch (lastElement){
                    case "name":
                        name = information;
                            break;
                    case "UID":
                        UID = information;
                            break;
                    case "address":
                        address = information;
                            break;
                    case "city":
                        city = information;
                            break;
                    case "email":
                        email = information;
                            break;
                    case "gender":
                        gender = information;
                            break;
                    case "phone":
                        phone = information;
                            break;
                }
            }
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        }
    }
}


