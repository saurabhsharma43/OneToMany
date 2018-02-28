package OneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;*/
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


	  @Modifying
	  @Query("delete from Employee u where u.empId = ?1")
	  int  deleteInBulkById(Integer empId);

	@Modifying
	 @Query("update Employee u set u.empName = ?1  where u.id = ?2")
	 int setUserInfoById(String empName, Integer userId);
	
	
}
