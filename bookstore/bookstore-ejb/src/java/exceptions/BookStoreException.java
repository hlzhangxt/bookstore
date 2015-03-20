/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Administrator
 */
public class BookStoreException extends Exception {

    /**
     * Creates a new instance of
     * <code>BookStoreException</code> without detail message.
     */
    public BookStoreException() {
    }

    /**
     * Constructs an instance of
     * <code>BookStoreException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public BookStoreException(String msg) {
        super(msg);
    }
}
