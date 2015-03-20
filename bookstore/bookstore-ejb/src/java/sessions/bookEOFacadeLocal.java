/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.bookEO;
import exceptions.BookStoreException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface bookEOFacadeLocal {

    bookEO create (bookEO bookEO) throws BookStoreException;
   
    bookEO edit(bookEO bookEO) throws BookStoreException;

    void remove(bookEO bookEO) throws BookStoreException;

    bookEO find(Object id);

    List<bookEO> findAll();

    List<bookEO> findRange(int[] range);
    
    List<bookEO> findByCategory(String category) throws BookStoreException;

    int count();
    
   
    
    
    
}
