package es.upm.pproject.miniproject;

import java.util.List;

import es.upm.pproject.miniproject.exception.UnivSystemException;
import es.upm.pproject.miniproject.management.*;
import es.upm.pproject.miniproject.student.IStudent;

public class Main {

    public static void main(String[] args) {

        IUniversityManagement system = new UniversityManagement();

        try {
            // Register students
            system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
            system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
            system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
            system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");

            // Register courses
            system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
            system.addCourseToSystem(102, "Data Structures and Algorithms", "Dr. Johnson");

            // Enroll students in courses
            system.enrollStudent(4, 101);
            system.enrollStudent(3, 101);
            system.enrollStudent(1, 101);
            system.enrollStudent(1, 102);
            system.enrollStudent(2, 101);
            
            // Get list of students enrolled in a course
            List<IStudent> students = system.matriculatedStudentsList(101);
            System.out.println("Students enrolled in course 101:");
            for (IStudent s : students) {
                System.out.println(s.getName());
            }

            // Unenroll a student from a course
            system.unenrollStudent(1, 101);

            // Get list of registered students
            List<IStudent> registeredStudents = system.registeredStudentsList();
            System.out.println("\nRegistered students:");
            for (IStudent s : registeredStudents) {
                System.out.println(s.getName());
            }

            System.out.println("\nStudents enrolled in course 101:");
            for (IStudent s : students) {
                System.out.println(s.getName());
            }

        } catch (UnivSystemException e) {
            System.out.println(e.getMessage());
        }
    }
}