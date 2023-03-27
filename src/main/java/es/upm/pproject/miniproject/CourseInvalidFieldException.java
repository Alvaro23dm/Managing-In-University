package es.upm.pproject.miniproject;

public class CourseInvalidFieldException extends Exception {
    public CourseInvalidFieldException (){
        super("Error in data while registering new course");
    }
}