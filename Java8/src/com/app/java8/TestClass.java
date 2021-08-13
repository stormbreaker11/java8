package com.app.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestClass {

	public static void main(String[] args) {
		
		EmployeeList employeeList= new EmployeeList();
		List<Employee> empList = employeeList.empList();
		
		Map<String, Long> collect = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		//grouping by gender
	//	System.out.println(collect);
		
		//print name of all dept
		
		empList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
		empList.stream().filter(year->year.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		
		//counting number of employees in each dept.
		
		empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		
		
		Optional<Employee> findFirst = empList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();	
		
		//Employee employee = findFirst.get();
		
		Map<String, Long> collect2 = empList.stream().filter(e->e.getDepartment().equals("Sales And Marketing")).
		collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
		System.out.print(collect2);
		
		
	}
}
