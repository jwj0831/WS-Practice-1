package ku.ws.pojo;

public class Employee {
    private String id;
    private String firstname;
    private String lastname;
    private int age;
    private double salary;

    public Employee() {
   }
    
    public Employee(String id, String firstname, String lastname, int age, double salary) {
         this.id = id;
         this.firstname = firstname;
         this.lastname = lastname;
         this.age = age;
         this.salary = salary;
    }
    
    public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
    public String toString() {
         return "<" + id + ", " + firstname + ", " + lastname + ", " + age + ", "
                                  + salary + ">";
    }
    
}