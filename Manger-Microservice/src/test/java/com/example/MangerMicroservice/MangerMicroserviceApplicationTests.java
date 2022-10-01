package com.example.MangerMicroservice;

import com.example.MangerMicroservice.entity.Employee;
import com.example.MangerMicroservice.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest

class MangerMicroserviceApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;




    @Test
	public  void saveEmployee(){
		Employee employee=Employee.builder()
				.id(15)
				.Emp_Name("Employee")
				.Emp_Address("Bangaluru")
				.email("employee@gmail.com")
				.salary(50000)
				.Occupation("staff")
				.build();
		employeeRepository.save(employee);

		Assertions.assertThat(employee.getId()).isGreaterThan(0);

	}

	@Test
	public  void updateEmployee(){
		Employee employee=employeeRepository.findById(15L).get();
		employee.setEmp_Name("Sriram");
		employee.setEmail("sriram@gmail.com");
		 Employee employeeupdated=employeeRepository.save(employee);
		Assertions.assertThat(employeeupdated.getEmp_Name()).isEqualTo("Sriram");
		Assertions.assertThat(employeeupdated.getEmail()).isEqualTo("sriram@gmail.com");


	}
	@Test
	public  void getListEmployees(){
		List<Employee> employees=employeeRepository.findAll();
		Assertions.assertThat(employees.size()).isGreaterThan(0);


	}
	@Test
	public  void getEmployeeById(){
		Employee employee=employeeRepository.findById(3L).get();
		Assertions.assertThat(employee.getId()).isEqualTo(3);


	}

	@Test
	public void deleteEmployee(){
		Employee employee=employeeRepository.findById(15l).get();
		employeeRepository.delete(employee);

		Employee employee1=null;

		Optional<Employee>optionalEmployee=employeeRepository.findById(15L);

		if(optionalEmployee.isPresent()){
			employee1=optionalEmployee.get();


		}
		Assertions.assertThat(employee1).isNull();

	}

}
