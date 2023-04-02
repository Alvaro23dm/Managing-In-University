package es.upm.pproject.miniproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.upm.pproject.miniproject.course.*;
import es.upm.pproject.miniproject.exception.UnivSystemException;
import es.upm.pproject.miniproject.management.*;
import es.upm.pproject.miniproject.student.*;

public class UniManagTest {

    //Test part 1
    /**
     * Adding courses to system 1
     * @result This test tries to add courses to the sistem and no error is expexted
     * @throws UnivSystemException if the format of some parameters are not as especified.
    */
    @Test
    void test1() throws UnivSystemException {
        IUniversityManagement system = new UniversityManagement();
        system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
        system.addCourseToSystem(102, "Data Structures and Algorithms", "Dr. Johnson");
        assertEquals(
        "[(Course ID: 101, Name: Introduction to Computer Science, Coordinator: Dr. Smith), (Course ID: 102, Name: Data Structures and Algorithms, Coordinator: Dr. Johnson)]", system.registeredCoursesList().toString(),
        "Implementation in adding a course to the system does not work the way it should");
        
    }
    
    /**
     * Adding courses to system 2
     * @result This test tries to add courses to the sistem. Error is expected as name variable is blank.
     * @throws UnivSystemException if the format of some parameters are not as especified.
    */
    @Test
    void test2(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addCourseToSystem(101, "", "Dr. Smith");
            fail("Test fail while trying to add a course to the system when the name is blank. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }

    /**
     * Adding courses to system 3
     * @result This test tries to add courses to the sistem. Error is expected as coordinator variable is blank.
     * @throws UnivSystemException if the format of some parameters are not as especified.
    */
    @Test
    void test3(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addCourseToSystem(101, "Introduction to Computer Science", "");
            fail("Test fail while trying to add a course to the system when the coordinator parameter is blank. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }

    //Test part 2
    /**
     * Adding students to system 1
     * @result This test tries to add students to the sistem. Error is not expected.
     * @throws UnivSystemException if the format of some parameters are not as especified.
    */
    @Test
    void test4()throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
        system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
        system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
        system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");
        assertEquals("[(ID: 1, Name: John Smith, E-mail: john.smith@example.com), (ID: 2, Name: Emma Johnson, E-mail: emma.johnson@example.com), (ID: 3, Name: Michael Davis, E-mail: michael.davis@example.com), (ID: 4, Name: Samantha Martinez, E-mail: samantha.martinez@example.com)]",
        system.registeredStudentsList().toString(),
        "Implementation in adding a student to the system does not work the way it should");
            
        
    }

    /**
     * Adding students to system 2
     * @result This test tries to add students to the sistem. Error is expected as name variable is blank.
     * @throws UnivSystemException if the format of some parameters are not as especified.
    */
    @Test
    void test5(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addStudentToSystem(1, "", "john.smith@example.com");
            
            fail("Test fail while trying to add a course to the system when the name parameter is blank. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }

    /**
     * Adding students to system 3
     * @result This test tries to add students to the sistem. Error is expected as e-mail variable is blank.
     * @throws UnivSystemException if the format of some parameters are not as especified.
    */
    @Test
    void test6(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addStudentToSystem(1, "John Smith", "");
            fail("Test fail while trying to add a course to the system when the e-mail parameter is blank. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }

    /**
     * Adding students to system 4
     * @result This test tries to add students to the sistem. Error is expected as e-mail variable doesn't contain character @.
     * @throws UnivSystemException if the format of some parameters are not as especified.
    */
    @Test
    void test7(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addStudentToSystem(1, "John Smith", "john.smithexample.com");
            fail("Test fail while trying to add a course to the system when the e-mail parameter doesn't contain caracter '@'. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }

    /**
     * Adding students to system 5
     * @result This test tries to add students to the sistem. Error is expected as e-mail variable finishes with character '.'
     * @throws UnivSystemException if the format of some parameters are not as especified.
    */
    @Test
    void test8(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addStudentToSystem(1, "John Smith", "john.smithex@ample.com.");
            fail("Test fail while trying to add a course to the system when the e-mail parameter finishes with caracter '.'. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }

    //Test part 3

    /**
     * Adding students to course 1
     * @result This test tries to add students to the course. Error is not expected.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test9()throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
        
        system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
        system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
        system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
        system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");
        
        system.enrollStudent(1, 101);
        system.enrollStudent(2, 101);
        system.enrollStudent(3, 101);
        system.enrollStudent(4, 101);
        
        assertEquals("[(ID: 1, Name: John Smith, E-mail: john.smith@example.com), (ID: 2, Name: Emma Johnson, E-mail: emma.johnson@example.com), (ID: 3, Name: Michael Davis, E-mail: michael.davis@example.com), (ID: 4, Name: Samantha Martinez, E-mail: samantha.martinez@example.com)]"
        ,system.registeredStudentsList().toString()
        ,"Implementation in adding a student a course does not work the way it should");
            
        
    }

    /**
     * Adding students to course 2
     * @result This test tries to add students to the sistem. Error is expected as student is not registered in system.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test10(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
            system.enrollStudent(1, 101);
            fail("Test fail while trying to add a student to a course when the student isn't registered in the system. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
        
    }

    /**
     * Adding students to course 3
     * @result This test tries to add students to the sistem. Error is expected as course is not registered in system.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test11(){
        IUniversityManagement system = new UniversityManagement();
        try {    
            system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
            system.enrollStudent(1, 101);
            fail("Exception did not occur. The course must be already registered in the system.");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }
    
    /**
     * Adding students to course 4
     * @result This test tries to add students to the sistem. Error is expected as course is full.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test12(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
        
            system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
            system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
            system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
            system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");
            system.addStudentToSystem(5, "Emily Thompson", "emily.thompson@example.com");
            system.addStudentToSystem(6, "Jacob Brown", "jacob.brown@example.com");
            system.addStudentToSystem(7, "Olivia Garcia", "olivia.garcia@example.com");
            system.addStudentToSystem(8, "William Rodriguez", "william.rodriguez@example.com");
            system.addStudentToSystem(9, "Ava Hernandez", "ava.hernandez@example.com");
            system.addStudentToSystem(10, "Ethan Lee", "ethan.lee@example.com");
            system.addStudentToSystem(11, "Sophia Kim", "sophia.kim@example.com");
            system.addStudentToSystem(12, "Daniel Davis", "daniel.davis@example.com");
            system.addStudentToSystem(13, "Mia Taylor", "mia.taylor@example.com");
            system.addStudentToSystem(14, "Benjamin Adams", "benjamin.adams@example.com");
            system.addStudentToSystem(15, "Isabella Wright", "isabella.wright@example.com");
            system.addStudentToSystem(16, "Mason Campbell", "mason.campbell@example.com");
            system.addStudentToSystem(17, "Charlotte Mitchell", "charlotte.mitchell@example.com");
            system.addStudentToSystem(18, "Noah Perez", "noah.perez@example.com");
            system.addStudentToSystem(19, "Amelia Baker", "amelia.baker@example.com");
            system.addStudentToSystem(20, "Liam Parker", "liam.parker@example.com");
            system.addStudentToSystem(21, "Chloe Green", "chloe.green@example.com");
            system.addStudentToSystem(22, "Alexander Evans", "alexander.evans@example.com");
            system.addStudentToSystem(23, "Madison Torres", "madison.torres@example.com");
            system.addStudentToSystem(24, "Elijah Ramirez", "elijah.ramirez@example.com");
            system.addStudentToSystem(25, "Grace Collins", "grace.collins@example.com");
            system.addStudentToSystem(26, "Logan Wright", "logan.wright@example.com");
            system.addStudentToSystem(27, "Avery Cooper", "avery.cooper@example.com");
            system.addStudentToSystem(28, "Carter Reyes", "carter.reyes@example.com");
            system.addStudentToSystem(29, "Aria Mitchell", "aria.mitchell@example.com");
            system.addStudentToSystem(30, "Joshua Turner", "joshua.turner@example.com");
            system.addStudentToSystem(31, "Evelyn Scott", "evelyn.scott@example.com");
            system.addStudentToSystem(32, "Gabriel Flores", "gabriel.flores@example.com");
            system.addStudentToSystem(33, "Hannah Carter", "hannah.carter@example.com");
            system.addStudentToSystem(34, "Isaac Torres", "isaac.torres@example.com");
            system.addStudentToSystem(35, "Victoria Phillips", "victoria.phillips@example.com");
            system.addStudentToSystem(36, "Landon Cooper", "landon.cooper@example.com");
            system.addStudentToSystem(37, "Natalie Rivera", "natalie.rivera@example.com");
            system.addStudentToSystem(38, "Lucas Reed", "lucas.reed@example.com");
            system.addStudentToSystem(39, "Audrey Baker", "audrey.baker@example.com");
            system.addStudentToSystem(40, "Jackson Wright", "jackson.wright@example.com");
            system.addStudentToSystem(41, "Leah Mitchell", "leah.mitchell@example.com");
            system.addStudentToSystem(42, "David Robinson", "david.robinson@example.com");
            system.addStudentToSystem(43, "Sofia Cooper", "sofia.cooper@example.com");
            system.addStudentToSystem(44, "Andrew Sanders", "andrew.sanders@example.com");
            system.addStudentToSystem(45, "Aaliyah Johnson", "aaliyah.johnson@example.com");
            system.addStudentToSystem(46, "Christopher Rodriguez", "christopher.rodriguez@example.com");
            system.addStudentToSystem(47, "Avery Ramirez", "avery.ramirez@example.com");
            system.addStudentToSystem(48, "Makayla Green", "makayla.green@example.com");
            system.addStudentToSystem(49, "Jonathan Davis", "jonathan.davis@example.com");
            system.addStudentToSystem(50, "Sophie Hernandez", "sophie.hernandez@example.com");
            system.addStudentToSystem(51, "Daniel Martinez", "daniel.martinez@example.com");
            
            for(int i = 0; i<51; i++){
                system.enrollStudent(i+1, 101);
            }

            fail("Test fail while trying to add a course to the system when the course is full. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }

    /**
     * Adding students to course 5
     * @result This test tries to add students to the sistem. Error is expected as student is already in the course.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test13(){
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
            system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
            system.enrollStudent(1, 101);
            system.enrollStudent(1, 101);
            fail("Test fail while trying to add a student to a course while the student is already in the course. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
    }

    //Test part 4
    /**
     * Obtaining the list of students from a course
     * @result This test tries to obtain the list of students from a course. Error is not expected.
     * @throws UnivSystemException if course isn't registered in the system.
    */
    @Test
    void test14() throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
        
        system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
        system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
        system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
        system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");
        
        system.enrollStudent(3, 101);
        system.enrollStudent(1, 101);
        system.enrollStudent(4, 101);
        system.enrollStudent(2, 101);
        
        List<IStudent> studentList = system.matriculatedStudentsList(101);
        if(studentList.size() != 4) fail("The list doesn't contain all the matriculated students");
        else{
            IStudent pointer1, pointer2;
            boolean error = false;
            Iterator<IStudent>it = studentList.iterator();
            if(it.hasNext()){ 
                pointer1 = it.next();
                while(it.hasNext() && !error){
                    pointer2 = it.next();
                    if (pointer1.getId() < pointer2.getId()) pointer1 = pointer2;
                    else error= true;
                }   
            }
            if(!error) assertTrue(true);
            else fail("The list is not in order");
        }        
    }
        
    //Test part 5
    /**
     * Cancelling enrollment from a course 1
     * @result This test tries to cancell enrollment of a student from a course. Error is not expected.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test15() throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
        
        system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
        system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
        system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
        system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");
        
        system.enrollStudent(3, 101);
        system.enrollStudent(1, 101);
        system.enrollStudent(4, 101);
        system.enrollStudent(2, 101);

        system.unenrollStudent(2, 101);

        assertEquals("[(ID: 1, Name: John Smith, E-mail: john.smith@example.com), (ID: 3, Name: Michael Davis, E-mail: michael.davis@example.com), (ID: 4, Name: Samantha Martinez, E-mail: samantha.martinez@example.com)]"
        ,system.matriculatedStudentsList(101).toString()
        ,"Implementation in removing a student from a course does not work the way it should");

    }

    
    /**
     * Cancelling enrollment from a course 2
     * @result This test tries to cancell enrollment of a student from a course. Error is expected as the student is not registered in the system.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test16() throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
            system.unenrollStudent(2, 101);
            fail("Test fail while trying to remove a student from a course when the student isn't registered in the system. This action cannot succed");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
        
    }    
    
    /**
     * Cancelling enrollment from a course 3
     * @result This test tries to cancell enrollment of a student from a course. Error is expected as the student is not registered in the course.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test17() throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        try {
            system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
            system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
            system.unenrollStudent(2, 101);
            fail("A student must be enroll in a course to be able to cancel enrollment");
        } catch (UnivSystemException e) {
            assertTrue(true);
        }
        
    }

    //Test part 6
    /**
     * Reestarting a course 1
     * @result This test tries to reestart a course by removing all the students from it. Error is not expected.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test18() throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
        
        system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
        system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
        system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
        system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");
        
        system.enrollStudent(3, 101);
        system.enrollStudent(1, 101);
        system.enrollStudent(4, 101);
        system.enrollStudent(2, 101);
        
        ICourse course = system.getCourse(101);
        List<IStudent> studentList = course.getStudentsList();
        course.restartCourse();
        assertTrue(studentList.isEmpty(),"After this test, the number of students in a course must be 0");

    }

    /**
     * Reestarting a course 2
     * @result This test tries to reestart a course by removing all the students from it. Error is expected as the list of students is not empty.
     * @throws UnivSystemException if courses or students or added to a course are not registered in the system.
    */
    @Test
    void test19() throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
        
        system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
        system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
        system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
        system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");
        
        system.enrollStudent(3, 101);
        system.enrollStudent(1, 101);
        system.enrollStudent(4, 101);
        system.enrollStudent(2, 101);
        
        ICourse course = system.getCourse(101);
        List<IStudent> studentList = course.getStudentsList();
        course.restartCourse();
        system.enrollStudent(2, 101);
        assertEquals(1, studentList.size(), "After this test, the list of students cannot be empty");

    }

    //Test part 7
    /**
     * Obtaining the list of students from the system
     * @result This test tries to obtain the list of students registered in the system. Error is not expected.
     * @throws UnivSystemException if the format of some parameters are not as especified while adding students to system.
    */
    @Test
    void test20() throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        
        system.addStudentToSystem(1, "John Smith", "john.smith@example.com");
        system.addStudentToSystem(2, "Emma Johnson", "emma.johnson@example.com");
        system.addStudentToSystem(3, "Michael Davis", "michael.davis@example.com");
        system.addStudentToSystem(4, "Samantha Martinez", "samantha.martinez@example.com");
        
        List<IStudent> studentList = system.registeredStudentsList();

        if(studentList.size() != 4) fail("The list doesn't contain all the matriculated students");
        else{
            IStudent pointer1, pointer2;
            boolean error = false;
            Iterator<IStudent>it = studentList.iterator();
            if(it.hasNext()){ 
                pointer1 = it.next();
                while(it.hasNext() && !error){
                    pointer2 = it.next();
                    if (pointer1.getId() < pointer2.getId()) pointer1 = pointer2;
                    else error= true;
                }   
            }
            if(!error) assertTrue(true);
            else fail("The list is not in order");
        }        
    }

    //Test part 8
    /**
     * Obtaining the list of courses from the system
     * @result This test tries to obtain the list of courses registered in the system. Error is not expected.
     * @throws UnivSystemException if the format of some parameters are not as especified while adding courses to system.
    */
    @Test
    void test21() throws UnivSystemException{
        IUniversityManagement system = new UniversityManagement();
        system.addCourseToSystem(101, "Introduction to Computer Science", "Dr. Smith");
        system.addCourseToSystem(102, "Data Structures and Algorithms", "Dr. Johnson");
        
        List<ICourse> courseList = system.registeredCoursesList();

        if(courseList.size() != 2) fail("The list doesn't contain all the registered courses");
        else{
            ICourse pointer1, pointer2;
            boolean error = false;
            Iterator<ICourse>it = courseList.iterator();
            if(it.hasNext()){ 
                pointer1 = it.next();
                while(it.hasNext() && !error){
                    pointer2 = it.next();
                    if (pointer1.getCode() < pointer2.getCode()) pointer1 = pointer2;
                    else error= true;
                }   
            }
            if(!error) assertTrue(true);
            else fail("The list is not in order");
        }        
    }
        
}


