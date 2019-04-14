package java8;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java8.Person.getAllPersons;

// Group persons with their age
public class GroupingBy {
    public static void main(String[] args) throws IOException {
        Map<Integer, List<Person>> groupedByAge = new HashMap<>();
        //usingImperitiveStyleToGroupPersonsByAge(groupedByAge);
        usingFunctionalStyleToGroupPersonsByAge(groupedByAge);
    }

    private static void usingImperitiveStyleToGroupPersonsByAge(Map<Integer, List<Person>> groupedByAge) {
        for (Person person: getAllPersons()) {

            if (!groupedByAge.containsKey(person.getAge()))
                groupedByAge.put(person.getAge(), new ArrayList<>());

            groupedByAge.get(person.getAge()).add(person);
        }
        System.out.println(groupedByAge);
    }

    private static void usingFunctionalStyleToGroupPersonsByAge(Map<Integer, List<Person>> groupedByAge) {
        System.out.println("* * * Using Functional Style * * *");

//        for (Person person: getAllPersons()) {
//
//            groupedByAge.computeIfAbsent(person.getAge(), integer -> new ArrayList<>());
//
//            groupedByAge.get(person.getAge()).add(person);
//        }
//        System.out.println(groupedByAge);

        System.out.println(getAllPersons().stream().collect(Collectors.groupingBy(person -> person.getAge())));

        System.out.println("* * * mapping with first name * * *");
        System.out.println(getAllPersons().stream().collect(Collectors.groupingBy(person -> person.getAge(), Collectors.mapping(Person::getFirstName, Collectors.toList()))));

    }
}
