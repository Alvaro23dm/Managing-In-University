package es.upm.pproject.miniproject.exception;

/**
 * The UnivSystemException class is a custom exception that is thrown when an error occurs in the
 * university management system.
*/
public class UnivSystemException extends Exception {

    /**
     * Constructs a new UnivSystemException with the specified detail message.
     * @param msg the detail message.
    */
    public UnivSystemException(String msg){
        super(msg);
    }
}