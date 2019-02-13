package za.co.bbd.university;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Course {
    private static volatile AtomicInteger numberOfCourses=new AtomicInteger(0);

    private String name;
    private int capacity;
    private List<Student> students;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.students = new ArrayList<>();
        int coursesNow = numberOfCourses.incrementAndGet();
        Logger.getAnonymousLogger().info(
                MessageFormat.format("We now have {0} courses", coursesNow));
    }

    public boolean enrollStudent(Student student) throws StudentAlreadyEnrolledException {
        if(students.contains(student)){
            throw new StudentAlreadyEnrolledException(student.getStudentNumber(), getName());
        }
        return students.add(student);
    }

    public boolean unenrollStudent(Student student){

        return students.remove(student);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Course '").append(name)
                .append("' with ").append(students.size())
                .append(" of ").append(capacity)
                .append(" students");
        for(Student student: students){
            result.append("\n\t").append(student);
        }
        return result.toString();
    }
}
