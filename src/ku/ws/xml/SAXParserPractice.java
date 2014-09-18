package ku.ws.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ku.ws.pojo.Employee;

/*
 * 소스참조: http://examples.javacodegeeks.com/core-java/xml/java-xml-parser-tutorial/
 */

public class SAXParserPractice extends DefaultHandler {

	private static List<Employee> employees = new ArrayList<Employee>();
	private static Employee empl = null;
	private static String text = null;

	@Override
	// A start tag is encountered.
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {

		switch (qName) {
		// Create a new Employee.
		case "employee": {
			empl = new Employee();
			empl.setID(attributes.getValue("id"));
			break;
		}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "employee": {
			// The end tag of an employee was encountered, so add the employee to the list.
			employees.add(empl);
			break;
		}
		case "firstname": {
			empl.setFirstname(text);
			break;
		}
		case "lastname": {
			empl.setLastname(text);
			break;
		}
		case "age": {
			empl.setAge(Integer.parseInt(text));
			break;
		}
		case "salary": {
			empl.setSalary(Double.parseDouble(text));
			break;
		}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text = String.copyValueOf(ch, start, length).trim();
	}

	public static void parseXML(String filePath)
			throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		SAXParserPractice handler = new SAXParserPractice();

		parser.parse(new File(filePath), handler);

		// Print all employees.
		for (Employee empl : employees)
			System.out.println(empl.toString());
	}
}
