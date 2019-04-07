package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java8.Person.getCreatePeople;
/*
Group By first character and find older person in that group
 */
public class ReduceMethodEx {
    public static void main(String... args) {
        Map<Character, List<Person>> groupedByFirstCharacter = getCreatePeople().stream().
                collect(Collectors.groupingBy(o -> o.getFirstName().charAt(0)));
        System.out.println(groupedByFirstCharacter);
        groupedByFirstCharacter.keySet()
                .stream()
                .map(character -> groupedByFirstCharacter.get(character))

                .forEach(System.out::print);
    }
}
