package za.co.bbd.university;

public class StudentAlreadyEnrolledException extends Exception {
    private static final String messageFormat = "%s already enrolled in %s";

    public static String getMessageFormat() {
        return messageFormat;
    }

    public StudentAlreadyEnrolledException(String studentNumber, String course) {
        super(String.format(messageFormat, studentNumber, course));
    }

}
