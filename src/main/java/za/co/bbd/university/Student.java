package za.co.bbd.university;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {

    private String name;
    private String studentNumber;
    private Date dob;

    private static final Set<String> alreadyEnrolledStudentNumbers =
            Collections.synchronizedSet(new HashSet<>());

    public Student(String name, String studentNumber, Date dob)
            throws StudentNumberDuplicateException {
        synchronized (alreadyEnrolledStudentNumbers){
            if(alreadyEnrolledStudentNumbers.contains(studentNumber)){
                throw new StudentNumberDuplicateException(studentNumber);
            } else {
                alreadyEnrolledStudentNumbers.add(studentNumber);
            }
        }
        this.name = name;
        this.studentNumber = studentNumber;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return name + " (" + studentNumber + ")";
    }
}
