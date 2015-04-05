/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CartItemEO;
import exceptions.BookStoreException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface CartItemEOFacadeLocal {

    CartItemEO create(CartItemEO cartItemEO) throws BookStoreException;

    CartItemEO edit(CartItemEO cartItemEO) throws BookStoreException;

    void remove(CartItemEO cartItemEO) throws BookStoreException;

    CartItemEO find(Object id);

    List<CartItemEO> findAll();

    List<CartItemEO> findRange(int[] range);

    int count();
}
