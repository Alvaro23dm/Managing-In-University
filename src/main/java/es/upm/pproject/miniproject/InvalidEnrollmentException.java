package es.upm.pproject.miniproject;

public class InvalidEnrollmentException extends Exception {
    public InvalidEnrollmentException (){
        super("Error while enrolling a student in a course");
    }
}