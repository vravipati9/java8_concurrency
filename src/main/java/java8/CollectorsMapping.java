package java8;

import pojos.Employee;
import pojos.Gender;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;


public class CollectorsMapping {
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

		// Want to group students by the marks. Then I want to further group those sets into same name students together
		// Map<Integer, Map<String, List<Student>>> grouping = students.stream().collect(Collectors.groupingBy(Student::getMarks,
		//                Collectors.groupingBy(Student::getName)));
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