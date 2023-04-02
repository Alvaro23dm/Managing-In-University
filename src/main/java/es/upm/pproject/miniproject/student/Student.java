package es.upm.pproject.miniproject.student;

public class Student implements IStudent{
    private int id;
    private String name;
    private String email;

    public Student (int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String toString(){
        return "(ID: " + id + ", Name: " + name + ", E-mail: " + email + ")";
    }
}
