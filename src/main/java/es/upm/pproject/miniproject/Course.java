package es.upm.pproject.miniproject;

import java.util.List;
import java.util.ArrayList;

public class Course{
    
    private int code;
    private String name;
    private String coordinator;
    private List<Student> StudentsList;

    public Course(int code, String name, String coordinator)throws CourseInvalidFieldException{
        this.code = code;
        this.coordinator = coordinator;
        this.name = name;
        StudentsList = new ArrayList<Student>();   
    }

    public int getNumberStudents(){
        return StudentsList.size();
    } 

    public boolean isInCourse(Student student){
        return StudentsList.contains(student);
    }

    public void enrollStudent(Student student){
        StudentsList.add(student);
    }

    




    
}
