package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
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

        BinaryOperator<Person> eldest = new BinaryOperator<Person>() {
            @Override
            public Person apply(Person person1, Person person2) {
                return person1.getAge() > person2.getAge() ? person1 : person2;
            }
        };
        groupedByFirstCharacter.keySet()
                .stream()
                .map(character -> groupedByFirstCharacter.get(character).stream().reduce(eldest))

                .forEach(System.out::println);
    }
}
