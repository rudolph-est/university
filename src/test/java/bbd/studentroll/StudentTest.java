package bbd.studentroll;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bbd.studentroll.Course;
import bbd.studentroll.Student;


public class StudentTest {
	
	
	Student s1 = null;
	Student s2 = null;
	Student s3 = null;
	Student s4 = null;
	Course c   = null;
	
	@Before
	public void setUp()
	{
		s1 = new Student("Werner", 12, "19930723");
		s2 = new Student("Nelmari", 11, "19931809");
		s3 = new Student("melta", 12, "19951002");
		s4 = new Student("Matt", 13, "19231212");
		c  = new Course("Java", 2);
	}
	
	@Test
	public void testStudent() {
		
		assertEquals("Werner", s1.getName());
		assertEquals(12, s1.getUFID());
		assertEquals("19930723", s1.getDob());
		
		assertEquals("Nelmari", s2.getName());
		assertEquals(11, s2.getUFID());
		assertEquals("19931809", s2.getDob());
		
		assertEquals("melta", s3.getName());
		assertEquals(12, s3.getUFID());
		assertEquals("19951002", s3.getDob());
	}
	
	@Test
	public void testCourse(){
		
		Course cr =  Mockito.mock(Course.class);
		Mockito.when(cr.getName()).thenReturn("LOL");
		
		assertEquals("LOL", cr.getName());
		
		assertEquals("Java", c.getName());
		assertEquals(2, c.getCap());
		
		assertTrue(c.enrollStudent(s1));
		assertTrue(c.enrollStudent(s2));
		assertFalse(c.enrollStudent(s4));
		
		String student1 = c.getStudents().get(0).getName() + " " + c.getStudents().get(0).getUFID();
		String student2 = c.getStudents().get(1).getName() + " " + c.getStudents().get(1).getUFID();
		
		assertEquals("Werner 12", student1);
		assertEquals("Nelmari 11", student2);
		
		assertFalse(c.unenrollStudent(s3));
		assertTrue(c.unenrollStudent(s1));
		assertTrue(c.unenrollStudent(s2));
		
	}
	
	@After
	public void teardown()
	{
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		c  = null; 
	}

}
