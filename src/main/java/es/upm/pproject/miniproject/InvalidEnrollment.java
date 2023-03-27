package es.upm.pproject.miniproject;

public class InvalidEnrollment extends Exception {
    public InvalidEnrollment (){
        super("Error while enrolling a student in a course");
    }
}
