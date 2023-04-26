package Lab2Exercise1;

import java.util.Objects;
import java.util.Random;

public class Person {

    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation){
        this.id = id;
        setName(name);
        setAge(age);
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        String[] nameAndLastName = name.split(" ");
            if (nameAndLastName.length != 2) {
                throw new IllegalArgumentException("Format for name is: 'firstname lastname'");
            }
            this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        try {
            if(age < 0){
                throw new IllegalArgumentException("Age cannot be a negative number");
            }
            this.age = age;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public Person clone() {
        int i = new Random().nextInt();
        return new Person(i, this.name, this.age, this.occupation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(occupation, person.occupation);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age, occupation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
