package java8;

public class Test {
	public static void main(String args[]) {
		System.out.println("asfadsfsf");
		int target = -5;
		int num = 3;

		//target =-num; // Noncompliant; target = -3. Is that really what's meant?
		//target =+ num; // Noncompliant; target = 3
		//target = -num; // Compliant; intent to assign inverse value of num is clear
		target += num;
		System.out.println(target);
	}
}
