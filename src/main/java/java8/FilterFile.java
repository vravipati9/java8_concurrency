package java8;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilterFile {
    public static void main(String... args) throws IOException {
        Arrays.stream(new File(".").listFiles()).forEach(file -> file.getName());
        System.out.println(Paths.get(".").getClass());
        System.out.println(Paths.get("."));
        Files.list((Paths.get("."))).forEach(System.out::println);
        String[] fileNames = new File(".").list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.endsWith(".class");
            }
        });
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}
