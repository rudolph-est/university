package bbd.studentroll;

import java.util.ArrayList;

public class Course 
{
	String name;
	ArrayList<Student> students;
	int capacity;
	int numberOfCourse;
	
	public Course(String name, int cap)
	{
		this.name = name;
		this.capacity = cap;
		this.students = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public int getCap() {
		return capacity;
	}

	public void setCap(int capacity) {
		this.capacity = capacity;
	}

	public int getNumberOfCourse() {
		return numberOfCourse;
	}

	public void setNumberOfCourse(int numberOfCourse) {
		this.numberOfCourse = numberOfCourse;
	}
	
	public boolean enrollStudent(Student s) 
	{
		if(this.students.size() < this.capacity)
		{
			return this.students.add(s);
		}else
		{
			return false;
		}
	}
	
	public boolean unenrollStudent(Student s) 
	{
		return this.students.remove(s);
	}
	
}
