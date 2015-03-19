/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CategoryEO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class CategoryEOFacade extends AbstractFacade<CategoryEO> implements CategoryEOFacadeLocal {
    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryEOFacade() {
        super(CategoryEO.class);
    }
    
}
