package generics;
import java8.Person;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java8.Person.getAllPersons;

/*
    Group with first Character, Person with same length for name, then select the elder from the two
    Else, person with longer names comes out
 */
public class ReducingMethod {
    public static void main(String... args) {

        Function<Person, Character> firstCharacter = person -> person.getFirstName().charAt(0);
        BinaryOperator<Person> classifier = (person, person2) -> {
            if (person.getFirstName().length() == person2.getFirstName().length()) {
                return person.getAge() > person2.getAge() ? person : person2;
            } else {
                return person.getFirstName().length() > person.getFirstName().length() ? person : person2;
            }
        };

        getAllPersons().stream().
                collect(Collectors.groupingBy(firstCharacter)).forEach((character, personList) -> System.out.println(personList));

        System.out.println("* * * Formatting results based on conditions * * *");
        getAllPersons().stream().
                collect(Collectors.groupingBy(firstCharacter, Collectors.reducing(classifier)))
                        .forEach((integer, personList) -> System.out.println(personList));

    }
}