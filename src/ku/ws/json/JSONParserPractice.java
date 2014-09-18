package ku.ws.json;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ku.ws.pojo.Employee;
import ku.ws.pojo.FruitBasket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 소스참조: http://www.leveluplunch.com/java/examples/convert-json-array-to-arraylist-of-objects-jackson/
 */

public class JSONParserPractice {

	public static void parseJSONWithListMapping(String filePath) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			List<Employee> employees = mapper.readValue(new File(filePath), 
					mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
			
			for(Employee employee : employees){
				System.out.println(employee);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void parseJSONWithTree(String filePath) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			JsonNode rootNode = mapper.readTree(new File(filePath));
			JsonNode employeeArrayNode = rootNode.path("employees");
			
//			System.out.println("Employees Node Type : " + employeeArrayNode.getNodeType());
			
			for(JsonNode employeeNode : employeeArrayNode) {
//				System.out.println("Employee Node Type : " + employeeNode.getNodeType());
				Employee employee = new Employee(
						Integer.toString(employeeNode.path("employee").path("id").intValue()),
						employeeNode.path("employee").path("firstname").textValue(),
						employeeNode.path("employee").path("lastname").textValue(),
						employeeNode.path("employee").path("age").intValue(),
						employeeNode.path("employee").path("salary").intValue()
						);
				
				System.out.println(employee);
				
//				System.out.println("ID : " + employeeNode.path("employee").path("id").intValue());
//				System.out.println("FirstName : " + employeeNode.path("employee").path("firstname").textValue());
//				System.out.println("LastName : " + employeeNode.path("employee").path("lastname").textValue());
//				System.out.println("Age : " + employeeNode.path("employee").path("age").intValue());
//				System.out.println("Salary : " + employeeNode.path("employee").path("salary").intValue());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("");
	}
	
	public static void createJSONFile(String filePath) {
		FruitBasket fruitBasket = new FruitBasket();
		ObjectMapper mapper = new ObjectMapper();
		try {
			
//			String jsonStr = mapper.writeValueAsString(fruitBasket.getFruits());
//			System.out.println(jsonStr);
			mapper.writeValue(new File(filePath), fruitBasket.getFruits());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("JSON Fruits File Created\n");
		}
		
	}
}
