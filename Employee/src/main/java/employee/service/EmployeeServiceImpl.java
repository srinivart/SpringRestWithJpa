package employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import employee.dao.EmployeeRepository;
import employee.entity.Employee;

@Configuration
public class EmployeeServiceImpl implements EmployeeService{
 
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}

	
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}


	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;
		 if(result.isPresent())
		 {
			 employee = result.get();
			 System.out.println("**** -->"+ employee);
		 }
		 else
		 {
			 throw new RuntimeException("Employee Id not found: " + id);
		 }
		 return employee;
	}


	public void save(Employee employee) {
		
		employeeRepository.save(employee);
		
	}


	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee save(int employeeId, Employee newEmployee) {
		
		Optional<Employee> result = employeeRepository.findById(employeeId);
		  result.get().setFirstName(newEmployee.getFirstName());
		  
		  Employee newEmp = employeeRepository.findById(employeeId).get();
		    employeeRepository.save(newEmp);
			return newEmp;
			

		}  

		
			
	
}
