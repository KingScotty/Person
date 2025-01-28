import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    public static void main(String[] args) {

    }

    @org.junit.jupiter.api.Test
    void fullName() {Person person = new Person("John", "Doe", "123456", "Mr.", 1985);
        assertEquals("John Doe", person.fullName());
    }

    @org.junit.jupiter.api.Test
    void formalName() { Person person = new Person("John", "Doe", "123456", "Mr.", 1985);
        assertEquals("Mr. John Doe", person.formalName());
    }

    @org.junit.jupiter.api.Test
    void getAge() { Person person = new Person("John", "Doe", "123456", "Mr.", 1985);
        assertEquals(35, person.getAge());
    }

    @org.junit.jupiter.api.Test
    void testGetAge() { Person person = new Person("John", "Doe", "123456", "Mr.", 1985);
        assertEquals(35, person.getAge());
    }

    @org.junit.jupiter.api.Test
    void toCSV() { Person person = new Person("John", "Doe", "123456", "Mr.", 1985);
        assertEquals("123456,John,Doe,Mr.,1985", person.toCSV());
    }
}

