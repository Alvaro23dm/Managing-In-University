package es.upm.pproject.miniproject.management;

import java.util.List;

import es.upm.pproject.miniproject.course.ICourse;
import es.upm.pproject.miniproject.student.IStudent;
import es.upm.pproject.miniproject.exception.UnivSystemException;

public interface IUniversityManagement {
    
    public void addStudentToSystem(int id, String name, String email) throws UnivSystemException;

    public void addCourseToSystem(int code, String name, String coordinator) throws UnivSystemException;

    public void enrollStudent(int idStudent, int courseCode) throws UnivSystemException;

    public void unenrollStudent(int idStudent, int courseCode) throws UnivSystemException;

    public List<IStudent> matriculatedStudentsList(int courseCode) throws UnivSystemException;

    public List<IStudent> registeredStudentsList();

    public List<ICourse> registeredCoursesList();
}
