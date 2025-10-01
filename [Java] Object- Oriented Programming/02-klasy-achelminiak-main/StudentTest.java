package test;

import main.Student;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testStudentCreationAndMethods() {
        // Tworzenie trzech różnych studentów
        Student student1 = new Student(123456, 80, 4);
        Student student2 = new Student("Bartus", "Szablowski", 654321, 30, 3);
        Student student3 = new Student(987654, 45, 5);

        // Sprawdzenie poprawności ustawienia imienia, nazwiska, numeru indeksu i oceny studentów
        assertEquals("Unknown", student1.getFirstName());
        assertEquals("Unknown", student1.getLastName());
        assertEquals(123456, student1.getIndexNumber());
        assertEquals(80, student1.getAttendance(), 0.001);
        assertEquals(4, student1.getGrade());

        assertEquals("Bartus", student2.getFirstName());
        assertEquals("Szablowski", student2.getLastName());
        assertEquals(654321, student2.getIndexNumber());
        assertEquals(30, student2.getAttendance(), 0.001);
        assertEquals(3, student2.getGrade());

        assertEquals("Unknown", student3.getFirstName());
        assertEquals("Unknown", student3.getLastName());
        assertEquals(987654, student3.getIndexNumber());
        assertEquals(45, student3.getAttendance(), 0.001);
        assertEquals(2, student3.getGrade());
    }
}
