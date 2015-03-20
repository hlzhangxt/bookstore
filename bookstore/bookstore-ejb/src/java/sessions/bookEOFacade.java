/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.bookEO;
import exceptions.BookStoreException;
import java.util.List;
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

    @Override
    public bookEO create(bookEO entity) throws BookStoreException {
        List list = em.createQuery("SELECT b FROM bookEO b WHERE b.book_name = :name AND b.category.cate_id = :categoryId")
                .setParameter("name", entity.getBook_name()).setParameter("categoryId", entity.getCategory().getCate_id())
                .getResultList();

        if (list.size() > 0) {
            throw new BookStoreException("The Category" + entity.getCategory().getCate_name()
                    + " already includes" + entity.getBook_name());
        }

        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public bookEO edit(bookEO entity) throws BookStoreException {

        List list = em.createQuery("SELECT b FROM bookEO b  WHERE b.book_name = :name AND b.category.cate_id = :categoryId AND b.book_id <> :id ")
                .setParameter("name", entity.getBook_name())
                .setParameter("categoryId", entity.getCategory().getCate_id())
                .setParameter("id", entity.getBook_id()).getResultList();

        if (list.size() > 0) {
            throw new BookStoreException("The Category" + entity.getCategory().getCate_name() + " already includes" + entity.getBook_name());
        }

        getEntityManager().merge(entity);
        return entity;
    }
    
    
    @Override
    @SuppressWarnings("unchecked")
    public List<bookEO> findByCategory(String category) throws BookStoreException {
        
        return em.createQuery("SELECT b FROM bookEO b WHERE b.category.cate_name = :name ")
				.setParameter("name", category).getResultList();
        
        
        
        
    }
    
}
