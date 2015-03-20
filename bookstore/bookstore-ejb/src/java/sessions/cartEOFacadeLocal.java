/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.cartEO;
import exceptions.BookStoreException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface cartEOFacadeLocal {

    cartEO create(cartEO cartEO) throws BookStoreException;

    cartEO edit(cartEO cartEO) throws BookStoreException;

    void remove(cartEO cartEO) throws BookStoreException;

    cartEO find(Object id);

    List<cartEO> findAll();

    List<cartEO> findRange(int[] range);

    int count();
    
    cartEO addItem(String login, String categoryName, String bookName,
            double price, int count) throws BookStoreException;
    
    public cartEO setItem(String login, String categoryName, String bookName,
            double price, int count) throws BookStoreException;
    
    cartEO findCart(String login) throws BookStoreException ;
    
    public cartEO payCart(cartEO cartEO) throws BookStoreException;
    
}
