package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMaxMethod {
    public static void main(String[] args) {
        findMaxElement();
        findPersonsWithMaxAge();
    }
    private static void findMaxElement() {
        List<Integer> listOfIntegers = Arrays.asList(2, 3, 1, 9, 4, 7);
        Integer max = listOfIntegers.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).get();
        System.out.println("Maximum element::"+max);

    }
    private static void findPersonsWithMaxAge() {
        Person olderPerson = createPeople().stream().max((o1, o2) -> o1.getAge() - o2.getAge()).orElse(null);
        System.out.println("Older Person(s):\n"+olderPerson);

        /*
        https://stackoverflow.com/questions/45256176/using-max-with-stream-on-a-list
        Integer maxSalary;
maxSalary = roster
    .stream()
    .map(Employee :: getSalary)
    .collect(Collectors.reducing(Integer :: max)
    .get();

         */
    }
    private static List<Person> createPeople() {
        List<Person> persons = Arrays.asList(
                new Person("Pat", "John", 40),
                new Person("Will", "Smith", 55),
                new Person("Robert", "Smith", 30),
                new Person("Henry", "Jason", 71),
                new Person("Veera", "Pat", 40),
                new Person("Tom", "Hewkins", 71));
        return persons;
    }
}
