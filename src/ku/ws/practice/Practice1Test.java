package ku.ws.practice;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import ku.ws.xml.*;
import ku.ws.json.*;

public class Practice1Test {
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		
		if(args.length < 1)
		     throw new RuntimeException("The name of the XML file is required!");
		
		// JDOM Test
		System.out.println("JDOM Test");
		JDOMParserPractice.parseXML(args[0]);
		JDOMParserPractice.createXML(args[1]);
		System.out.println("JDOM Test End\n\n");
		
		// DOM Test
		System.out.println("DOM Test");
		DOMParserPractice.parseXML(args[0]);
		System.out.println("DOM Test End\n\n");
		
		// SAX Test
		System.out.println("SAX Test");
		SAXParserPractice.parseXML(args[0]);
		System.out.println("SAX Test End\n\n");
		
		// StAX Test
		System.out.println("StAX Test");
		StAXParserPractice.parseXML(args[0]);
		System.out.println("StAX Test End\n\n");
		
		// JSON Test
		System.out.println("Jackson JSON Test");
		JSONParserPractice.parseJSONWithListMapping(args[2]);
		JSONParserPractice.parseJSONWithTree(args[3]);
		JSONParserPractice.createJSONFile(args[4]);
		System.out.println("Jackson JSON Test End\n\n");
	}
}
