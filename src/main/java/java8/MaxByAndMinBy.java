package generics;
import java8.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java8.Person.getCreatePeople;

/*
Group By first character and find older person in that group
 */
public class MaxByAndMinBy {
    public static void main(String... args) {
        Function<Person, Character> firstLetter = o -> o.getFirstName().charAt(0);

        Comparator<Person> byAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() > o2.getAge() ? 1 : -1;
            }
        };
        Map<Character, Optional<Person>> groupedByFirstCharacter = getCreatePeople().stream().
                collect(Collectors.groupingBy(firstLetter, Collectors.maxBy(byAge)));

        System.out.println(groupedByFirstCharacter);
    }
}