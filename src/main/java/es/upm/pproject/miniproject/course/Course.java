package es.upm.pproject.miniproject.course;

import java.util.List;

import es.upm.pproject.miniproject.student.IStudent;

import java.util.ArrayList;

public class Course implements ICourse{
    
    private int code;
    private String name;
    private String coordinator;
    private List<IStudent> studentsList;

    public Course(int code, String name, String coordinator){
        this.code = code;
        this.coordinator = coordinator;
        this.name = name;
        studentsList = new ArrayList<IStudent>();   
    }

    public int getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public String getCoordinator(){
        return this.coordinator;
    }

    public List<IStudent> getStudentsList(){
        return studentsList;
    }

    public int getNumberStudents(){
        return studentsList.size();
    } 

    public boolean isInCourse(IStudent student){
        return studentsList.contains(student);
    }

    public void enrollStudent(IStudent student){
        studentsList.add(student);
    }

    public void unenrollStudent(IStudent student){
        studentsList.remove(student);
    }

    public void restartCourse(){
        studentsList.clear();
    }

    public String toString(){
        return "(Course ID: " + code + ", Name: " + name + ", Coordinator: " + coordinator + ")";
    }
  
}