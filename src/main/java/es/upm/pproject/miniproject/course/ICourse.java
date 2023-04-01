package es.upm.pproject.miniproject.course;

import java.util.List;

import es.upm.pproject.miniproject.student.IStudent;

/**
 * The ICourse interface represents a course object in the educational system.
 * It defines methods to retrieve and manipulate information about the course,
 * including its code, name, coordinator, list of enrolled students, and number of
 * enrolled students. It also provides methods to check if a student is currently
 * enrolled in the course, enroll and unenroll students, and restart the course.
 * */
public interface ICourse {

    /**
     * @return the code of the course.
    */
    public int getCode();

    /**
     * @return the name of the course.
    */
    public String getName();

    /**
     * @return the name of the course coordinator.
    */
    public String getCoordinator();

    /**
     * @return a list of all students currently enrolled in the course.
    */
    public List<IStudent> getStudentsList();

    /**
     * @return the number of students currently enrolled in the course.
    */
    public int getNumberStudents();

    /**
     * Checks if a given student is currently enrolled in the course.
     * @param student the student to check.
     * @return true if the student is currently enrolled in the course, false otherwise.
    */
    public boolean isInCourse(IStudent student);

    /**
     * Enrolls a student in the course.
     * @param student the student to enroll.
    */
    public void enrollStudent(IStudent student);

    /**
     * Unenrolls a student from the course.
     * @param student the student to unenroll.
    */
    public void unenrollStudent(IStudent student);
    
    /**
     * Restarts the course, removing all enrolled students.
    */
    public void restartCourse();

    }