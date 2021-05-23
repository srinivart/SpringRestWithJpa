package employee.service;

import java.util.List;


import employee.entity.Employee;

public interface EmployeeService {
   
	public List<Employee> findAll();  
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);

	public Employee save(int employeeId, Employee employee);
}
