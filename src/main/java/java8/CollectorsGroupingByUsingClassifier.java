package java8;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java8.Person.getCreatePeople;

// Group persons with their age
public class CollectorsGroupingByUsingClassifier {
    public static void main(String[] args) throws IOException {
        Map<Integer, List<Person>> groupedByAge = new HashMap<>();
        usingFunctionalStyleToGroupPersonsByAge(groupedByAge);
    }

    private static void usingFunctionalStyleToGroupPersonsByAge(Map<Integer, List<Person>> groupedByAge) {
        System.out.println("* * * Using Functional Style * * *");

        //here type is Integer and List<Person>
        Map<Integer, List<Person>> groupingByAge = getCreatePeople().stream().collect(Collectors.groupingBy(person -> person.getAge()));

        //here type is String and List<Person>,
        Map<String, List<Person>> groupingByName = getCreatePeople().stream().collect(Collectors.groupingBy(new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getFirstName();
            }
        }));

        System.out.println(groupingByName);

        //we have to change every time the return type, if we use another classifier in groupingBy. To avoid this, create a GenericType
        System.out.println("* * * Using Generic Type * * *");
        Function<Person, String> byName = person -> person.getFirstName();
        printGrouping(getCreatePeople().stream(), Person::getAge);
        printGrouping(getCreatePeople().stream(), byName);


    }

    private static <T> void printGrouping(Stream<Person> personStream, Function<Person, T> classifier) {
        Map<T, List<Person>> collect = personStream.collect(Collectors.groupingBy(classifier));
        System.out.println(collect);
    }
}
