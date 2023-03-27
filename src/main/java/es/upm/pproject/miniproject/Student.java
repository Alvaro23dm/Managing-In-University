package es.upm.pproject.miniproject;

public class Student {
    private int id;
    private String name;
    private String mail;

    public Student (int id, String name, String mail) throws StudentInvalidFieldException{
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

}
