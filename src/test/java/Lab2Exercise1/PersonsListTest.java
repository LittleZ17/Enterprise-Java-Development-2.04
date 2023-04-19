package Lab2Exercise1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {
    private PersonsList personsList;


    @Test
    public void findByName_incorrectNameFormatIllegalArgumentException() {
        PersonsList personsList= new PersonsList();
        personsList.add(new Person(1,"Joana Ventura", 25,"Doctor"));
        personsList.add(new Person(2, "Kane West", 29, "Software Developer"));
        personsList.add(new Person(3,"Alicia Lua", 30,"Somelier"));

        assertThrows(IllegalArgumentException.class, () -> {
            String person = personsList.findByName("Joe");
        });
    }


    @Test
    void findByName_correctArgument_findPerson() {
        PersonsList personsList= new PersonsList();
        personsList.add(new Person(1,"Zindy Martinez", 25,"Doctor"));

        assertEquals("Zindy Martinez", personsList.findByName("Zindy Martinez"));
    }

    @Test
    void findByName_nameNotExist_returnNull(){
        PersonsList personsList= new PersonsList();
        personsList.add(new Person(1,"Zindy Martinez", 25,"Doctor"));

        assertNull(personsList.findByName("Zindy Lucio"));
    }
}