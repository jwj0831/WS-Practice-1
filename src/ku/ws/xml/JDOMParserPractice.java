package ku.ws.xml;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import ku.ws.pojo.Employee;
import ku.ws.pojo.FruitBasket;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Element;

/*
 * 소스참조: http://www.mkyong.com/java/how-to-read-xml-file-in-java-jdom-example/
 */

public class JDOMParserPractice {
	
	public static void parseXML(String filePath) {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(filePath);

		try {
			Document document = (Document) builder.build(xmlFile);
			
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren("employee");

			//for (int i = 0; i < list.size(); i++) {
			for(Element node : list) {
				//Element node = (Element) list.get(i);
				
				Employee employee = new Employee(
						node.getAttributeValue("id"),
						node.getChildText("firstname"),
						node.getChildText("lastname"),
						Integer.parseInt(node.getChildText("age")),
						Double.parseDouble(node.getChildText("salary"))
						);
				System.out.println(employee);
//				System.out.println("ID : " + node.getAttributeValue("id"));
//				System.out.println("First Name : " + node.getChildText("firstname"));
//				System.out.println("Last Name : " + node.getChildText("lastname"));
//				System.out.println("Age : " + node.getChildText("age"));
//				System.out.println("Salary : " + node.getChildText("salary"));
			}
			
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		} finally {
			System.out.println("");
		}
	}
	
	public static void createXML(String filePath) {
		
		Element root = new Element("fruits");
		Document document = new Document(root);
		FruitBasket fruitBasket = new FruitBasket();
		for(Map<String, String> fruitItem : fruitBasket.getFruits() ) {
			Element fruit = new Element("fruit");
			fruit.setAttribute("origin", "Korea");
//			fruit.addContent("\n\t\t");
			fruit.addContent(new Element("name").setText(fruitItem.get("name"))); 
//			fruit.addContent("\n\t\t");
			fruit.addContent(new Element("price").setText(fruitItem.get("price")));
//			fruit.addContent("\n\t");
			
//			root.addContent("\n\t");
			root.addContent(fruit);
		}
		
//		root.addContent("\n");
		XMLOutputter output = new XMLOutputter();
		
		try {
			output.output(document, new FileOutputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("XML Employee File Created\n");
		}
		
	}
	
	public static void parseXMLWithString(String xmlStr) {

		try {
			SAXBuilder builder = new SAXBuilder();
			InputStream stream = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
			Document document = (Document) builder.build(stream);
			
			Element rootNode = document.getRootElement();
			Element channelNode = rootNode.getChild("channel");
			System.out.println(channelNode.getChildText("title"));
			System.out.println(channelNode.getChildText("link"));
			System.out.println(channelNode.getChildText("description"));
			System.out.println(channelNode.getChildText("lastBuildDate"));
			System.out.println(channelNode.getChildText("total"));
			
			List<Element> elmts = channelNode.getChildren();
			
			System.out.println("");
			
			for(Element e : elmts) {
				if( e.getName().equals("item") ) {
					System.out.println("News Item");
					System.out.println(e.getChildText("title"));
					System.out.println(e.getChildText("originallink"));
					System.out.println(e.getChildText("link"));
					System.out.println(e.getChildText("description"));
					System.out.println(e.getChildText("pubDate"));
				}
			}
			
			
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		} finally {
			System.out.println("");
		}
	}
}

