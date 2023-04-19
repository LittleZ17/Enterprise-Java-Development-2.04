package Lab2Exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void add(Person person) {
        this.persons.add(person);
    }

    public String findByName(String name) {

        String[] names = name.trim().split(" ");
        if (names.length != 2) {
            throw new IllegalArgumentException("Invalid name format. Should be 'firstName lastName'.");
        }

        for (Person person : persons) {
            if (person.getName().equals(name) ) {
                return person.getName();
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonsList that = (PersonsList) o;
        return Objects.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons);
    }
}