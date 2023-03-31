package es.upm.pproject.miniproject;

import java.util.List;
import java.util.ArrayList;

public class Course{
    
    private int code;
    private String name;
    private String coordinator;
    private List<Student> studentsList;

    public Course(int code, String name, String coordinator) throws UnivSystemException{
        this.code = code;
        this.coordinator = coordinator;
        this.name = name;
        studentsList = new ArrayList<Student>();   
    }

    public int getCode(){
        return code;
    }

    public int getNumberStudents(){
        return studentsList.size();
    } 

    public List<Student> getStudentsList(){
        List<Student> copyList = new ArrayList<Student>(studentsList);
        return copyList;
    }

    public boolean isInCourse(Student student){
        return studentsList.contains(student);
    }

    public void enrollStudent(Student student){
        studentsList.add(student);
    }

    public void unEnrollStudent(Student student){
        studentsList.remove(student);
    }

    public void restartCourse(){
        studentsList.clear();
    }
  
}