import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testFullName() {
        Person person = new Person("John", "Doe", "123456", "Mr.", 1985);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("Jane", "Smith", "654321", "Dr.", 1990);
        assertEquals("Dr. Jane Smith", person.formalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("Alice", "Johnson", "789123", "Ms.", 2000);
        assertEquals(23, person.getAge(2023));
    }

    @Test
    public void testToCSV() {
        Person person = new Person("John", "Doe", "123456", "Mr.", 1985);
        assertEquals("123456,John,Doe,Mr.,1985", person.toCSV());
    }
}
