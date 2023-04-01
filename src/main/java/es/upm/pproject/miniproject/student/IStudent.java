package es.upm.pproject.miniproject.student;

/**
 * The IStudent interface represents a student object in the educational system.
 * It defines methods to retrieve information about the student, including their
 * ID, name, and email address.
*/
public interface IStudent {

    /**
     * @return the ID of the student.
    */
    public int getId();

    /**
     * @return the name of the student.
    */
    public String getName();

    /**
     * @return the email address of the student.
    */
    public String getEmail();
    
    }