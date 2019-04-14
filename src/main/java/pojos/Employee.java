package pojos;

import pojos.Gender;

public class Employee {
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
