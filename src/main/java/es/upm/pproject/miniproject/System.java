package es.upm.pproject.miniproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class System {
    private Map<Integer, Course> CourseList;
    private Map<Integer, Student> StudentsList;
    
    public System(){
        CourseList = new HashMap<Integer, Course>();
        StudentsList = new HashMap<Integer, Student>();
    }

    public void addStudentToSystem(int id_s, String name, String mail)throws StudentInvalidFieldException{
        if (name.length() == 0 || mail.length() == 0 
            || !(mail.contains("@") && mail.charAt(mail.length() -1)!= '.')){
            throw new StudentInvalidFieldException();
        }

        Student student = new Student(id_s, name, mail);
        StudentsList.put(id_s, student);
        

    }

    public void addCourseToSystem(int code, String name, String coordinator)throws CourseInvalidFieldException{
        if(coordinator.length() == 0 || coordinator.length() == 0) throw new CourseInvalidFieldException();
        Course course = new Course(code, name, coordinator);
        CourseList.put(code, course);
    }

    public void enroll(int idStudent, int courseCode)throws InvalidEnrollment{
        Student student = StudentsList.get(idStudent);
        Course course = CourseList.get(courseCode);
        
        if(!StudentsList.containsKey(idStudent) || !CourseList.containsKey(courseCode)
          || course.getNumberStudents()>=50 || course.isInCourse(student) ){
            throw new InvalidEnrollment();
        }

        course.enrollStudent(student);
    }

    
}
