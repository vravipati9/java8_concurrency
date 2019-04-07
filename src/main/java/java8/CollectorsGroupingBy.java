package java8;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java8.Person.getCreatePeople;

// Group persons with their age
public class CollectorsGroupingBy {
    public static void main(String[] args) throws IOException {
        Map<Integer, List<Person>> groupedByAge = new HashMap<>();
        //usingImperitiveStyleToGroupPersonsByAge(groupedByAge);
        usingFunctionalStyleToGroupPersonsByAge(groupedByAge);
    }

    private static void usingImperitiveStyleToGroupPersonsByAge(Map<Integer, List<Person>> groupedByAge) {
        for (Person person: getCreatePeople()) {

            if (!groupedByAge.containsKey(person.getAge()))
                groupedByAge.put(person.getAge(), new ArrayList<>());

            groupedByAge.get(person.getAge()).add(person);
        }
        System.out.println(groupedByAge);
    }

    private static void usingFunctionalStyleToGroupPersonsByAge(Map<Integer, List<Person>> groupedByAge) {
        System.out.println("* * * Using Functional Style * * *");

//        for (Person person: getCreatePeople()) {
//
//            groupedByAge.computeIfAbsent(person.getAge(), integer -> new ArrayList<>());
//
//            groupedByAge.get(person.getAge()).add(person);
//        }
//        System.out.println(groupedByAge);

        System.out.println(getCreatePeople().stream().collect(Collectors.groupingBy(person -> person.getAge())));

        System.out.println("* * * mapping with first name * * *");
        System.out.println(getCreatePeople().stream().collect(Collectors.groupingBy(person -> person.getAge(), Collectors.mapping(Person::getFirstName, Collectors.toList()))));

    }
}
