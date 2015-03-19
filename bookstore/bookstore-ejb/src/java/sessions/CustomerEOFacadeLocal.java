/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CustomerEO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface CustomerEOFacadeLocal {

    void create(CustomerEO customerEO);

    void edit(CustomerEO customerEO);

    void remove(CustomerEO customerEO);

    CustomerEO find(Object id);

    List<CustomerEO> findAll();

    List<CustomerEO> findRange(int[] range);

    int count();
    
}
