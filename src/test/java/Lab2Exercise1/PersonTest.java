package Lab2Exercise1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setName_incorrectFormat_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = new Person(1, "Zindy", 27, "SD");
        });
    }
    @Test
    void setName_changeName_newName() {
        Person person = new Person(1, "Zindy Lucio", 27, "SD");
        String nameChange = "Karla Olivar";
        person.setName(nameChange);
        assertEquals(nameChange, person.getName());
    }

    @Test
    void setAge_negativeInt_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Person person = new Person(1, "Zindy", -27, "SD");
        });
    }

    @Test
    void setAge_positiveInt_newAge() {
        Person person = new Person(1, "Zindy Lucio", 25, "SD");
        person.setAge(30);
        assertEquals(30, person.getAge());
    }

    @Test
    void clone_differentPerson_areEquals() {
        Person person1 = new Person(1, "John Smith", 30, "Developer");
        Person person2 = new Person(2, "John Smith", 30, "Developer");

        assertEquals(person1, person2);
    }

}