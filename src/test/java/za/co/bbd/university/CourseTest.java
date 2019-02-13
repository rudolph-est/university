package za.co.bbd.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CourseTest {

    private Course course;

    @BeforeEach
    public void setupCourse() {
        course = new Course("COP3502", 10);
    }

    private Student createFakeStudent() {
        return  mock(Student.class);
    }


    @Test
    public void whenEnrollingNewStudentExpectTrue() throws StudentAlreadyEnrolledException {
        Student student = createFakeStudent();
        boolean result = course.enrollStudent(student);
        assertTrue(result);
    }

    @Test
    public void whenEnrollingExistingStudentExpectException() throws StudentAlreadyEnrolledException {
        Student student = createFakeStudent();
        boolean result = course.enrollStudent(student);
        assertThrows(StudentAlreadyEnrolledException.class, () -> course.enrollStudent(student));
    }

    @Test
    public void whenUnenrollingAnUnenrolledStudentExpectFalse() {
        Student student = createFakeStudent();
        boolean result = course.unenrollStudent(student);
        assertFalse(result);
    }

    @Test
    void whenPrintingCourseDetailsExpectFormat() throws StudentAlreadyEnrolledException, StudentNumberDuplicateException {
        Student student1 = createFakeStudent();// new Student("rudolph", "12345", new Date());
        Student student2 = createFakeStudent();// new Student("rudolph1", "12346", new Date());;
        Student student3 = createFakeStudent();// new Student("rudolph2", "12347", new Date());;
        course.enrollStudent(student1);
        course.enrollStudent(student2);
        course.enrollStudent(student3);
        String coursePrintOut = course.toString();
        System.out.println(coursePrintOut);
        //TODO - RE: asserts???
        //asdkjahsdkjashkd
    }

    @Test
    public void whenCapacityIsReachedExpectException() {
        //TODO: should this have been specified in the requirements
    }
}
