/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.cartEO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class cartEOFacade extends AbstractFacade<cartEO> implements cartEOFacadeLocal {
    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public cartEOFacade() {
        super(cartEO.class);
    }
    
}
