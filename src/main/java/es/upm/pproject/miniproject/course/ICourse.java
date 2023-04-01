package es.upm.pproject.miniproject.course;

import java.util.List;

import es.upm.pproject.miniproject.student.IStudent;

public interface ICourse {
    
    public int getCode();

    public String getName();

    public String getCoordinator();

    public List<IStudent> getStudentsList();

    public int getNumberStudents();

    public boolean isInCourse(IStudent student);

    public void enrollStudent(IStudent student);

    public void unenrollStudent(IStudent student);

    public void restartCourse();
    
}
