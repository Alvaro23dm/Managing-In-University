package es.upm.pproject.miniproject;

public class StudentInvalidFieldException extends Exception {
    public StudentInvalidFieldException (){
        super("Error in data while registering student");
    }
}