package za.co.bbd.university;

public class StudentNumberDuplicateException extends Exception {
    private static final String messageFormat =
            "Student number %s already belongs to someone else";

    public static String getMessageFormat() {
        return messageFormat;
    }

    public StudentNumberDuplicateException(String studentNumber) {
        super(String.format(messageFormat, studentNumber));
    }

}
