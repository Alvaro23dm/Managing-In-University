package es.upm.pproject.miniproject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class System {
    private Map<Integer, Course> courseList;
    private Map<Integer, Student> studentsList;
    
    public System(){
        courseList = new HashMap<Integer, Course>();
        studentsList = new HashMap<Integer, Student>();
    }

    public void addStudentToSystem(int id_s, String name, String email) throws UnivSystemException{

        if(name != null && name.length() == 0){
            throw new UnivSystemException("Name field cannot be blank");
        }

        if(email != null && email.length() == 0){
            throw new UnivSystemException("Mail field cannot be blank");
        }

        if(!(email.contains("@") && email.charAt(email.length() - 1) != '.')){
            throw new UnivSystemException("The format of the email address must be correct");
        }

        Student student = new Student(id_s, name, email);
        studentsList.put(id_s, student); 
    }

    public void addCourseToSystem(int code, String name, String coordinator) throws UnivSystemException{
        if(name.length() == 0 || coordinator.length() == 0) throw new UnivSystemException("");
        if(name != null && name.length() == 0){
            throw new UnivSystemException("Name field cannot be blank");
        }
        if(coordinator != null && coordinator.length() == 0){
            throw new UnivSystemException("Coordinator field cannot be blank");
        }
        Course course = new Course(code, name, coordinator);
        courseList.put(code, course);
    }

    public void enrollStudent(int idStudent, int courseCode) throws UnivSystemException{
        Student student = studentsList.get(idStudent);
        Course course = courseList.get(courseCode);
        
        if(!studentsList.containsKey(idStudent) || !courseList.containsKey(courseCode)
          || course.getNumberStudents() >= 50 || course.isInCourse(student) ){
            throw new UnivSystemException("");
        }

        if(!studentsList.containsKey(idStudent)){
            throw new UnivSystemException("The student must be already registered in the system.");
        }

        if(!courseList.containsKey(courseCode)){
            throw new UnivSystemException("The course must be already registered in the system.");
        }

        if(course.getNumberStudents() >= 50){
            throw new UnivSystemException("Mo more places are available for the course.");
        }

        if(course.isInCourse(student)){
            throw new UnivSystemException("A student cannot be enrolled in the same course twice.");
        }
        course.enrollStudent(student);
    }
    
    public void unEnrollStudent(int idStudent, int courseCode) throws UnivSystemException{
        Student student = studentsList.get(idStudent);
        Course course = courseList.get(courseCode);

        if(!studentsList.containsKey(idStudent)){
            throw new UnivSystemException("The student must be already registered in the system.");
        }

        if(!courseList.containsKey(courseCode)){
            throw new UnivSystemException("The course must be already registered in the system.");
        }

        if(!course.isInCourse(student)){
            throw new UnivSystemException("The student is not enrolled in the course.");
        }

        course.unEnrollStudent(student);
    }

    public List<Student> matriculatedStudentsList(int courseCode) throws UnivSystemException{
        Course course = courseList.get(courseCode);
        List<Student> students = course.getStudentsList();
        students.sort(Comparator.comparing(Student::getId));
        return students;
    }

    public List<Student> registeredStudentsList(){
        List<Student> students = new ArrayList<>(studentsList.values());
        students.sort(Comparator.comparing(Student::getId));
        return students;
    }

    public List<Course> registeredCoursesList(){
        List<Course> courses = new ArrayList<>(courseList.values());
        courses.sort(Comparator.comparing(Course::getCode));
        return courses;
    }

}
