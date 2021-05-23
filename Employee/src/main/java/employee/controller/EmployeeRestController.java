package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employee.entity.Employee;
import employee.service.EmployeeService;



@RestController
public class EmployeeRestController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findALL()
	{
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/find/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId)
	{
		Employee employee = employeeService.findById(employeeId);
		if(employee==null)
		{
			throw new RuntimeException("Employee id not found " );
		}
		return employee;
	}
	
	@PostMapping("/employees/add")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees/update/{employeeId}")
	public Employee updateEmployee(@PathVariable int employeeId,@RequestBody Employee employee)
	{
		employeeService.save(employeeId,employee);
		return employee;
	}
	
	@DeleteMapping("/employees/delete/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		employeeService.deleteById(employeeId);
		return "Deleted employee with id: " + employeeId;
	}
	
	
	
}
