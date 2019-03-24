package java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// flatmap flattens the result of a map, collection to collection transformation, we use flatmap
public class FlatMapEx {
    public static void main(String[] args) {
        //System.out.println(factorsOfImperitiveStyle(Arrays.asList(1, 2, 6, 8))); //[1, 2, 3, 4, 6, 8]
        System.out.println(factorsOfFunctionalStyle(Arrays.asList(1, 2, 6, 8)));
    }

    private static Set<Integer> factorsOfImperitiveStyle(List<Integer> list) {
        Set<Integer> factors = new HashSet<>();
        for (Integer i : list) {
            factors.addAll(factorsOfImperitiveStyle(i));
        }
        return factors;
    }

    private static List<Integer> factorsOfImperitiveStyle(Integer integer) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= integer; i++) {
            if (integer % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private static Set<Integer> factorsOfFunctionalStyle(List<Integer> list) {
        Set<Integer> factors = new HashSet<>();
        list.stream().map(i -> factorsOfFunctionalStyle(i)).forEach(integers -> System.out.println(integers)); // [1] [1, 2] [1, 2, 3, 6] [1, 2, 4, 8][]
        list.stream().flatMap((Function<Integer, Stream<?>>) integer -> factorsOfFunctionalStyle(integer).stream()).forEach(integers -> System.out.print(integers)); // 11212361248[]
        //
        return list.stream().flatMap(integer -> factorsOfFunctionalStyle(integer).stream()).collect(Collectors.toSet());
    }

    private static List<Integer> factorsOfFunctionalStyle(Integer number) {
        return IntStream.rangeClosed(1, number).filter(value -> number % value == 0).boxed().collect(Collectors.toList());
    }
}
