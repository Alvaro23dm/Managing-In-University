package es.upm.pproject.miniproject.management;

import java.util.List;

import es.upm.pproject.miniproject.course.ICourse;
import es.upm.pproject.miniproject.student.IStudent;
import es.upm.pproject.miniproject.exception.UnivSystemException;

/**
 * The IUniversityManagement interface represents the management system for a university.
 * It defines methods to add students and courses to the system, enroll and unenroll students
 * from courses, and retrieve lists of enrolled students and registered courses.
 * @throws UnivSystemException if an error occurs while executing a method.
*/
public interface IUniversityManagement {

    /**
     * Adds a new student to the system with the given ID, name, and email address.
     * @param id the ID of the student.
     * @param name the name of the student.
     * @param email the email address of the student.
     * @throws UnivSystemException if an error occurs while adding the student.
    */
    public void addStudentToSystem(int id, String name, String email) throws UnivSystemException;

    /**
     * Adds a new course to the system with the given code, name, and coordinator.
     * @param code the code of the course.
     * @param name the name of the course.
     * @param coordinator the name of the course coordinator.
     * @throws UnivSystemException if an error occurs while adding the course.
    */
    public void addCourseToSystem(int code, String name, String coordinator) throws UnivSystemException;

    /**
     * Enrolls a student with the given ID in the course with the given code.
     * @param idStudent the ID of the student to enroll.
     * @param courseCode the code of the course to enroll the student in.
     * @throws UnivSystemException if an error occurs while enrolling the student.
    */
    public void enrollStudent(int idStudent, int courseCode) throws UnivSystemException;

    /**
     * Unenrolls a student with the given ID from the course with the given code.
     * @param idStudent the ID of the student to unenroll.
     * @param courseCode the code of the course to unenroll the student from.
     * @throws UnivSystemException if an error occurs while unenrolling the student.
    */
    public void unenrollStudent(int idStudent, int courseCode) throws UnivSystemException;

    /**
     * Returns a list of all students enrolled in the course with the given code.
     * @param courseCode the code of the course to retrieve the list of enrolled students for.
     * @return a list of all students enrolled in the course with the given code.
     * @throws UnivSystemException if an error occurs while retrieving the list of enrolled students.
    */
    public List<IStudent> matriculatedStudentsList(int courseCode) throws UnivSystemException;

    /**
     * Returns a list of all students registered in the system.
     * @return a list of all students registered in the system.
     * @throws UnivSystemException if an error occurs while retrieving the list of registered students.
    */
    public List<IStudent> registeredStudentsList() throws UnivSystemException;
    
    /**
     * Returns a list of all courses registered in the system.
     * @return a list of all courses registered in the system.
     * @throws UnivSystemException if an error occurs while retrieving the list of registered courses.
    */
    public List<ICourse> registeredCoursesList() throws UnivSystemException;

    /**
     * Returns a a course given his code.
     * @param courseCode the code of the course to retrieve the list of enrolled students for.
     * @return courses registered in the system.
    */
    public ICourse getCourse(int courseCode);
    }
