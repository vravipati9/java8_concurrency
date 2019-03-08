package java8;

import java.io.File;
import java.util.Arrays;

public class FileIsPresent {
    public static void main(String... args) {
        String directory = "\\\\OCULUSAPPS\\xgate_testbed\\";
        System.out.println(directory);
        String fileName = directory.concat("128780_hw.doc");
        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()) {
            System.out.println("file exist");
            System.out.println(f.getName());
}
    }
}
