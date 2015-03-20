/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CartItemEO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class CartItemEOFacade extends AbstractFacade<CartItemEO> implements CartItemEOFacadeLocal {
    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartItemEOFacade() {
        super(CartItemEO.class);
    }
    
    
    
    
    
    
    
    
    
    
}
