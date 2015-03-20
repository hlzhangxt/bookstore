/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CustomerEO;
import exceptions.BookStoreException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface CustomerEOFacadeLocal {

    CustomerEO create(CustomerEO customerEO) throws BookStoreException;

    CustomerEO edit(CustomerEO customerEO) throws BookStoreException;

    void remove(CustomerEO customerEO) throws BookStoreException;

    CustomerEO find(Object id);

    List<CustomerEO> findAll();

    List<CustomerEO> findRange(int[] range);

    int count();
    
    CustomerEO findCustomer(String login, String password) throws BookStoreException;
    
}
