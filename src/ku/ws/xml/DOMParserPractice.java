package ku.ws.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ku.ws.pojo.Employee;


/*
 * 소스참조: http://examples.javacodegeeks.com/core-java/xml/java-xml-parser-tutorial/
 */

public class DOMParserPractice {
	public static void parseXML(String filePath) 
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load the input XML document, parse it and return an instance of the Document class.
		Document document = builder.parse(new File(filePath));

		// Root Element의 자식 노드를 List로 받아오기
		NodeList nodeList = document.getDocumentElement().getChildNodes();
//		System.out.println("Number of NodeList: "+ nodeList.getLength());
		
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
//			System.out.println("Node Type: " + node.getNodeType());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;

				// Get the value of the ID attribute.
				String ID = node.getAttributes().getNamedItem("id").getNodeValue();

				// Get the value of all sub-elements.
				String firstname = elem.getElementsByTagName("firstname")
						.item(0).getChildNodes().item(0).getNodeValue();

				String lastname = elem.getElementsByTagName("lastname").item(0)
						.getChildNodes().item(0).getNodeValue();

				Integer age = Integer.parseInt(elem.getElementsByTagName("age")
						.item(0).getChildNodes().item(0).getNodeValue());

				Double salary = Double.parseDouble(elem.getElementsByTagName("salary")
						.item(0).getChildNodes().item(0).getNodeValue());

				employees.add(new Employee(ID, firstname, lastname, age, salary));
			}
		}

		// Print all employees.
		for (Employee empl : employees)
			System.out.println(empl.toString());
	}

}
