package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

//https://www.youtube.com/watch?v=1OpAgZvYXLQ
//https://www.youtube.com/watch?v=IwJ-SCfXoAU
public class CollectorsToMapAndMapping {
	public static void main(String...strings) {
		List<Employee> employee = createEmployee();
		
		//Create a map with name and age as Key, and the employee as value.
		System.out.println(employee.stream()
				.collect(toMap(t -> t.getName() +"-"+ t.getAge(), t -> t)) //toMap is coming from Collectors static class
		);
		
		//Given a list of people, create a map where their name is the Key and value is all the employee with that name.
		System.out.println(employee.stream()
				.collect(groupingBy(e -> e.getName()))
		);
		
		//Given a list of people, create a map where their name is the Key and value is all the ages of people with that name
		System.out.println(employee.stream()
				.collect(groupingBy(e -> e.getName(),
						mapping(Employee::getAge, toList())
						))
		);
	}
	


	public static List<Employee> createEmployee() {
		return Arrays.asList(
				new Employee("Sara", Gender.FEMALE, "20"),
				new Employee("Sara", Gender.FEMALE, "22"),
				new Employee("Bob", Gender.MALE, "36"),
				new Employee("Jack", Gender.MALE, "33"),
				new Employee("Jack", Gender.MALE, "34")
		);
	}
}

class Employee {
	String name;
	Gender gender;
	String age;
	
	public Employee(String name, Gender gender, String age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public String getAge() {
		return age;
	}
	
}

enum Gender {
	FEMALE,
	MALE;
}