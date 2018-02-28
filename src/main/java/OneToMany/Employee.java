package OneToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="EMP_ID",nullable=false)
	    private int empId;
	    
	    @Column(name="NAME")
	    private String empName;

	    @OneToMany(fetch = FetchType.EAGER,mappedBy="employee",cascade = CascadeType.ALL)
	    private Set<Employee_Address> employeeAddress;

	    public Employee()
	    {
	        super();
	    }

	    public Employee(int empId, String empName, Set<Employee_Address> employeeAddress)
	    {
	        super();
	        this.empId = empId;
	        this.empName = empName;
	        this.employeeAddress = employeeAddress;
	    }

	    public int getEmpId()
	    {
	        return empId;
	    }

	    public void setEmpId(int empId)
	    {
	        this.empId = empId;
	    }

	    public String getEmpName()
	    {
	        return empName;
	    }

	    public void setEmpName(String empName)
	    {
	        this.empName = empName;
	    }

	    public Set<Employee_Address> getEmployeeAddress()
	    {
	        return employeeAddress;
	    }

	    public void setEmployeeAddress(Set<Employee_Address> employeeAddress)
	    {
	        this.employeeAddress = employeeAddress;
	    }

	    @Override
	    public String toString()
	    {
	        return "Employee [empId=" + empId + ", empName=" + empName + "]";
	    }
}
