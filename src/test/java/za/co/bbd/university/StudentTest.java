package za.co.bbd.university;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student rudolph;

    @BeforeAll
    public void setUpFakeStudents() {
        try {
            rudolph = new Student("Rudolph", "12345", new Date());
        } catch (StudentNumberDuplicateException snde) {
            // ignore
        }
    }

    @Test
    public void whenStudentNumberIsDuplicatedExpectAnException() {
        Exception e = assertThrows(StudentNumberDuplicateException.class, () -> new Student("Rudolph", "12345", new Date()));
        String expectedException = String.format(StudentNumberDuplicateException.getMessageFormat(), "12345");
        assertEquals(expectedException, e.getMessage());
    }

    @Test
    public void toStringTest() throws StudentNumberDuplicateException {
        Student testObject = new Student("Rudolph", "12345", new Date());
        String expected = "Rudolph (12345)";
        assertEquals(expected, testObject.toString());
    }
}