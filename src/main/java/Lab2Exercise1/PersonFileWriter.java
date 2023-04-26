package Lab2Exercise1;

import java.io.File;
import java.io.FileWriter;

public class PersonFileWriter {
    public static boolean checkNameFormat(String name){
        String[] nameAndLastName = name.split(" ");
        if (nameAndLastName.length != 2) {
            throw new IllegalArgumentException("Format for name is: 'firstname lastname'");
        }
        return true;
    }
    public static boolean checkAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age must be greater than zero or zero");
        return true;
    }

    public static boolean writePerson(Person person) {
        File file = new File("src/main/resources/PersonDatabase.csv");

        try {
            createFile(person, file);
        } catch (Exception e) {
            System.out.println("Couldn't create file");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private static void createFile(Person person, File dir) throws Exception {
        System.out.println(dir.getPath());
        File file = new File(dir.getPath());
        FileWriter fileWriter = new FileWriter(file);

        file.createNewFile();
        fileWriter.write(person.toString());
        fileWriter.close();
    }
}
