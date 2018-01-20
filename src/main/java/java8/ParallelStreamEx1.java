package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class ParallelStreamEx1 {
	public static void main(String a[]) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		long start = System.nanoTime();

		Timeit.code(() ->
				integers.parallelStream().filter(e -> e%2 == 0)
				.mapToInt(e -> compute(e))
				.forEach(System.out::println)
				);

	}
	
	public static int compute(int number) {
		try { Thread.sleep(1000); } catch(Exception e) {}
		return number * 2;
	}
	public static void execute(Runnable runnable) {
		runnable.run();
	}
	
}
