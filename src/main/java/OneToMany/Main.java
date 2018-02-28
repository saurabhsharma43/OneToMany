package OneToMany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
private static Main main;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public static void main( String[] args )
    {
        //Reading the Configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        
        //Get the Main bean
        main = (Main)context.getBean("main");
        
        main.saveEmployee();
       main.delete(6);
       // main.retrieveEmployee();
       // main.update("rahul",5);
        
        context.close();
        
    }
 

	public void saveEmployee()
    {
        Employee employee = new Employee();
        employee.setEmpName("JIP");
        
        Employee_Address employeeAddress1 = new Employee_Address();
        employeeAddress1.setStreet("Street 1");
        employeeAddress1.setCity("City 1");
        employeeAddress1.setCountry("Country 1");
        employeeAddress1.setState("State 1");
        employeeAddress1.setEmployee(employee);
        
        
        /*Employee_Address employeeAddress2 = new Employee_Address();
        employeeAddress2.setStreet("Street 2");
        employeeAddress2.setCity("City 2");
        employeeAddress2.setCountry("Country 2");
        employeeAddress2.setState("State 2");
        employeeAddress2.setEmployee(employee);*/
        
        Set<Employee_Address> employeeAddressSet = new HashSet();
        employeeAddressSet.add(employeeAddress1);
      /*  employeeAddressSet.add(employeeAddress2);*/
        
        employee.setEmployeeAddress(employeeAddressSet);
        
        employeeRepository.save(employee);
       
      
        System.out.println("Employee and Employee Address saved successfully!!");
    }
	
	public void update(String name, int id)
	{
		employeeRepository.setUserInfoById(name, id);
	}
	public void delete(int id)
	{
		employeeRepository.deleteInBulkById(id);	
	}
	
    
   /* public void retrieveEmployee()
    {
        // Get list of all Employee & Employee Address
        List<Employee> employeeList = employeeRepository.findAll();

        // Displaying the Employee details
        for (Employee employee : employeeList)
        {
            System.out.println("*** Employee Details ***");

            System.out.println("Employee Id   : " + employee.getEmpId());
            System.out.println("Employee Name : " + employee.getEmpName());

            System.out.println("*** Employee Address Details ***");
            Set<Employee_Address> empAddressSet = employee.getEmployeeAddress();
            for (Employee_Address employeeAddress : empAddressSet)
            {
                System.out.println("Street  : " + employeeAddress.getStreet());
                System.out.println("City    : " + employeeAddress.getCity());
                System.out.println("State   : " + employeeAddress.getState());
                System.out.println("Country : " + employeeAddress.getCountry());
            }
        }
    }*/
    
   
    
    
}


