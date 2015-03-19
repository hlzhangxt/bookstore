/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.bookEO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class bookEOFacade extends AbstractFacade<bookEO> implements bookEOFacadeLocal {
    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public bookEOFacade() {
        super(bookEO.class);
    }
    
}
