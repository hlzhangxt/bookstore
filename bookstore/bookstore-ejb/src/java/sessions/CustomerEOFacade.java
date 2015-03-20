/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CustomerEO;
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

    @SuppressWarnings("unchecked")
    @Override
    public CustomerEO findCustomer(String login, String password) throws BookStoreException {

        List list = em.createQuery(" SELECT u FROM CustomerEO u WHERE u.login_name = :login  and u.login_pass = :password ")
                .setParameter("login", login.toLowerCase().trim())
                .setParameter("password", password)
                .getResultList();

        if (!list.isEmpty()) {
            return (CustomerEO) list.get(0);
        }

        return null;
    }

    @Override
    public CustomerEO create(CustomerEO customerEO) throws BookStoreException {

        List list = em.createQuery(
                " SELECT u FROM CustomerEO u WHERE u.login_name = :login ")
                .setParameter("login", customerEO.getLogin_name().toLowerCase().trim())
                .getResultList();

        if (!list.isEmpty()) {
            throw new BookStoreException("The login name " + customerEO.getLogin_name() + " already exists!");
        }

        em.persist(customerEO);
        return customerEO;

    }
}
