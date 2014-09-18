package ku.ws.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ku.ws.pojo.Employee;

/*
 * 소스참조: http://examples.javacodegeeks.com/core-java/xml/java-xml-parser-tutorial/
 */

public class StAXParserPractice {

    public static void parseXML(String filePath) 
    		throws FileNotFoundException, XMLStreamException {

         List<Employee> employees = null;
         Employee empl = null;
         String text = null;

         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(
                                                 new File(filePath)));

         while (reader.hasNext()) {
              int Event = reader.next();

              switch (Event) {
                   case XMLStreamConstants.START_ELEMENT: {
                        if ("employee".equals(reader.getLocalName())) {
                             empl = new Employee();
                             empl.setID(reader.getAttributeValue(0));
                        }
                        if ("employees".equals(reader.getLocalName()))
                             employees = new ArrayList<>();

                        break;
                   }
                   case XMLStreamConstants.CHARACTERS: {
                        text = reader.getText().trim();
                        break;
                   }
                   case XMLStreamConstants.END_ELEMENT: {
                        switch (reader.getLocalName()) {
                             case "employee": {
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
                        break;
                   }
              }
         }

         // Print all employees.
         for (Employee employee : employees)
              System.out.println(employee.toString());
    }
}
