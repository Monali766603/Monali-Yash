package com.practice.Examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Yash", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Employee employee2 = new Employee("Ram", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Employee employee3 = new Employee("Sita", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

		// Get employee with exact match name "Yash", if not found print "Not
		// found".

		Optional<Employee> matchingName = employees.stream().filter(p -> p.getName().equals("Yash")).findAny();
		if (matchingName.isPresent()) {
			System.out.println("Employee with matched name=" + matchingName.get().getName());
		} else {
			System.out.println("Employee Not Found");
		}

		// Get employee with matching address "1235"
		System.out.println();
		Optional<Employee> matchingAddress = employees.stream().filter(p -> p.getAddress().getZipcode().equals("1235"))
				.findAny();
		if (matchingAddress.isPresent()) {
			System.out.println("Employee name with matching address is" + matchingAddress.get().getName());
		} else {
			System.out.println("Not Found");
		}

		// Get all employee having mobile numbers 3333.
		System.out.println();
		List<Employee> empList = employees.stream()
				.filter(e -> e.getMobileNumbers().stream().anyMatch(x -> x.getNumber().equals("3333")))
				.collect(Collectors.toList());
		

		String result1 = empList.stream().map(m -> m.getName()).collect(Collectors.joining(",", "[", "]"));
		System.out.println("List of employees having mobile number 3333:" + result1);

		// Convert List<Employee> to List<String> of employee name
		System.out.println();
		List<String> listOfString = employees.stream().map(e -> e.getName()).collect(Collectors.toList());
		System.out.println("Converting list of employee to list of string=" + listOfString);

		// Collect all the names of employees in a string separated by ||
		System.out.println();
		String stringWithSeparatedBy = employees.stream().map(e -> e.getName()).collect(Collectors.joining("||"));
		System.out.println("List of string with separated by || is:" + stringWithSeparatedBy);

		// Change the case of List<String>
		System.out.println();
		List<String> uppercaseString = employees.stream().map(e -> e.getName().toUpperCase())
				.collect(Collectors.toList());
		System.out.println("Case Changed list of string:" + uppercaseString);

		// Sort List<String>
		System.out.println();
		List<String> sortedList = employees.stream().map(e -> e.getName()).sorted().collect(Collectors.toList());
		System.out.println("Sorted names of employees:" + sortedList);

		// sort List<Employee> based on name
		System.out.println();
		System.out.println("List of employees sorted by name:");
		Comparator<Employee> listOfEmployee = Comparator.comparing(Employee::getName, (s1, s2) -> {
			return s1.compareTo(s2);

		});

		Collections.sort(employees, listOfEmployee);
		for (Employee emp : employees) {
			System.out.println(emp);
		}

	}
}
