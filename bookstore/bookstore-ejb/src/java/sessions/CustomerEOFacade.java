/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CustomerEO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class CustomerEOFacade extends AbstractFacade<CustomerEO> implements CustomerEOFacadeLocal {
    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerEOFacade() {
        super(CustomerEO.class);
    }
    
}
