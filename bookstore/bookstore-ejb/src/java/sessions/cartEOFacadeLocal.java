/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.cartEO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface cartEOFacadeLocal {

    void create(cartEO cartEO);

    void edit(cartEO cartEO);

    void remove(cartEO cartEO);

    cartEO find(Object id);

    List<cartEO> findAll();

    List<cartEO> findRange(int[] range);

    int count();
    
}
