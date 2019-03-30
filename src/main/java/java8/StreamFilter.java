package java8;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.function.Function;

// Count no of occurrences in a file for a given string
public class StreamFilter {
    public static void main(String[] args) throws IOException {
        String searchString = "host";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("/etc/hosts"));
//        String line = null;
//        long count = 0;
//        while ((line = bufferedReader.readLine()) != null) {
//            if (line.contains(searchString)) {
//                count++;
//            }
//        }
//        System.out.printf("%s found in %d places \n", searchString, count);

        Long countUsingJava8 = Files.lines(Paths.get("/etc/hosts"))
                .filter(l -> l.contains(searchString)).count();

        System.out.printf("%s found in %d places ", searchString, countUsingJava8);

    }
}
