package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Imperative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(12, 13, 14, 15, 16);
		
		for (Integer integer : numbers) {
			System.out.println(integer);
		}
		
		numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			};
		});
		
		// with Internal Iterator
		numbers.forEach((Integer t) -> System.out.println(t)); // numbers are of type Integer, 
		
		// type Inference for Lambda expressions
		numbers.forEach(t -> System.out.println(t));


	}

}
