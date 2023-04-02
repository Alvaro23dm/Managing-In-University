package es.upm.pproject.miniproject.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.upm.pproject.miniproject.course.*;
import es.upm.pproject.miniproject.student.*;
import es.upm.pproject.miniproject.exception.UnivSystemException;

public class UniversityManagement implements IUniversityManagement{
    private Map<Integer, ICourse> courseList;
    private Map<Integer, IStudent> studentsList;
    
    private static final Logger logger = LoggerFactory.getLogger(UniversityManagement.class);

    public UniversityManagement(){
        courseList = new HashMap<>();
        studentsList = new HashMap<>();
    }

    public void addStudentToSystem(int id, String name, String email) throws UnivSystemException{
        
        logger.info("Registering student with id={}, name={}, email={} ...", id, name, email);
        
        if(name != null && name.length() == 0){
            logger.error("The name introduced is blank");
            throw new UnivSystemException("Name field cannot be blank");
        }

        if(email != null && email.length() == 0){
            logger.error("The email introduced is blank");
            throw new UnivSystemException("Mail field cannot be blank");
        }

        if(email != null && !(email.contains("@") && email.charAt(email.length() - 1) != '.')){
            logger.error("The email address format is not correct");
            throw new UnivSystemException("The format of the email address must be correct");
        }

        IStudent student = new Student(id, name, email);
        studentsList.put(id, student); 
        logger.info("Registering of the student with id={}, name={}, email={} completed", id, name, email);

    }

    public void addCourseToSystem(int code, String name, String coordinator) throws UnivSystemException{

        logger.info("Registering course with id={}, name={}, email={} ...", code, name, coordinator);

        if(name != null && name.length() == 0){
            logger.error("The name introduced is blank");
            throw new UnivSystemException("Name field cannot be blank");
        }

        if(coordinator != null && coordinator.length() == 0){
            logger.error("The coordinator introduced is blank");
            throw new UnivSystemException("Coordinator field cannot be blank");
        }

        ICourse course = new Course(code, name, coordinator);
        courseList.put(code, course);
        logger.info("Registering of the course with id={}, name={}, email={} completed", code, name, coordinator);

    }

    public void enrollStudent(int idStudent, int courseCode) throws UnivSystemException{

        logger.info("Enrolling the student with id={} in course with code={} ...", idStudent, courseCode);

        IStudent student = studentsList.get(idStudent);
        ICourse course = courseList.get(courseCode);

        if(!studentsList.containsKey(idStudent)){
            logger.error("The student with id={} is not registered in the system", idStudent);
            throw new UnivSystemException("The student must be already registered in the system.");
        }

        if(!courseList.containsKey(courseCode)){
            logger.error("The course with code={} is not registered in the system", courseCode);
            throw new UnivSystemException("The course must be already registered in the system.");
        }

        if(course.getNumberStudents() >= 50){
            logger.error("The course with code={} has not more places available", courseCode);
            throw new UnivSystemException("No more places are available for the course");
        }

        if(course.isInCourse(student)){
            logger.error("The student with id={} is already enrolled in the course", idStudent);
            throw new UnivSystemException("A student cannot be enrolled in the same course twice");
        }

        course.enrollStudent(student);
        logger.info("The student with id={} has been succesfully enrolled in course with code={}", idStudent, courseCode);
    }
    
    public void unenrollStudent(int idStudent, int courseCode) throws UnivSystemException{

        logger.info("Unenrolling the student with id={} from course with code={} ...", idStudent, courseCode);

        IStudent student = studentsList.get(idStudent);
        ICourse course = courseList.get(courseCode);

        if(!studentsList.containsKey(idStudent)){
            logger.error("The student with id={} is not registered in the system", idStudent);
            throw new UnivSystemException("The student must be already registered in the system.");
        }

        if(!courseList.containsKey(courseCode)){
            logger.error("The course with code={} is not registered in the system", courseCode);
            throw new UnivSystemException("The course must be already registered in the system.");
        }

        if(!course.isInCourse(student)){
            logger.error("The student with id={} is not enrolled in the course", idStudent);
            throw new UnivSystemException("The student is not enrolled in the course.");
        }

        course.unenrollStudent(student);
        logger.info("The student with id={} has been succesfully unenrolled from course with code={}", idStudent, courseCode);
    }

    public List<IStudent> matriculatedStudentsList(int courseCode) throws UnivSystemException{
        logger.info("Loading list of students matriculated in course with id={}...", courseCode);
        ICourse course = courseList.get(courseCode);
        List<IStudent> students = course.getStudentsList();
        logger.debug("Sorting list by identification number...");
        students.sort(Comparator.comparing(IStudent::getId));
        logger.info("List of students matriculated in course with id={} ready to display", courseCode);
        return students;
    }

    public List<IStudent> registeredStudentsList(){
        logger.info("Loading list of students registered...");
        List<IStudent> students = new ArrayList<>(studentsList.values());
        logger.debug("Sorting list by identification number...");
        students.sort(Comparator.comparing(IStudent::getId));
        logger.info("List of students registered ready to display");
        return students;
    }

    public List<ICourse> registeredCoursesList(){
        logger.info("Loading list of courses registered...");
        List<ICourse> courses = new ArrayList<>(courseList.values());
        logger.debug("Sorting list by code...");
        courses.sort(Comparator.comparing(ICourse::getCode));
        logger.info("List of courses registered ready to display");
        return courses;
    }

    public ICourse getCourse(int courseCode){
        return courseList.get(courseCode);
    }

    

}
