package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class SharedMutablility {
	public static void main(String a[]) {

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// Avoid shared mutability (doubleofEven is shared value)
		// double the even values and put that into in List
		List<Integer> doubleOfEven = new ArrayList<>();
		integers.stream()
			.filter(e -> e%2 == 0)
			.map(e -> e*2)
			.forEach(e -> doubleOfEven.add(e));
		
		System.out.println(doubleOfEven);
		
		List<Integer> doubleOfEven1 = integers.stream()
										.filter(e -> e % 2 == 0)
										.map(e -> e * 2)
										.collect(Collectors.toList());
		
		System.out.println(doubleOfEven1);
	}
	
}
