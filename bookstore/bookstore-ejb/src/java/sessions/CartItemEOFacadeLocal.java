/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CartItemEO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface CartItemEOFacadeLocal {

    void create(CartItemEO cartItemEO);

    void edit(CartItemEO cartItemEO);

    void remove(CartItemEO cartItemEO);

    CartItemEO find(Object id);

    List<CartItemEO> findAll();

    List<CartItemEO> findRange(int[] range);

    int count();
    
}
