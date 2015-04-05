/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CartItemEO;
import ejb.cartEO;
import exceptions.BookStoreException;
import java.util.Date;
import java.util.List;
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

    @Override
    public cartEO addItem(String login, String categoryName, String bookName,
            double price, int count) throws BookStoreException {

        cartEO cartEO = findCart(login);
        boolean contains = false;

        for (CartItemEO cartItemEO : cartEO.getCartItems()) {

            if (cartItemEO.getCate_name().equals(categoryName)
                    && cartItemEO.getBook_name().equals(bookName)) {

                cartItemEO.setCount(count + cartItemEO.getCount());
                cartItemEO.setItem_date(new Date());
                contains = true;
                break;
            }
        }

        if (!contains) {

            CartItemEO cartItemEO = new CartItemEO();
            cartItemEO.setCart(cartEO);
            cartItemEO.setCount(count);
            cartItemEO.setItem_date(new Date());
            cartItemEO.setCate_name(categoryName);
            cartItemEO.setBook_name(bookName);
            cartItemEO.setBook_price(price);
            
            cartEO.getCartItems().add(cartItemEO);
            
        }

        return em.merge(cartEO);
    }

    @Override
    public cartEO setItem(String login, String categoryName, String bookName,
            double price, int count) throws BookStoreException {

        cartEO cartEO = findCart(login);

        boolean contains = false;

        for (CartItemEO cartItemEO : cartEO.getCartItems()) {

            if (cartItemEO.getCate_name().equals(categoryName)
                    && cartItemEO.getBook_name().equals(bookName)) {

                cartItemEO.setCount(count);
                cartItemEO.setItem_date(new Date());
                contains = true;
                break;
            }
        }

        if (!contains) {

            CartItemEO cartItemEO = new CartItemEO();
            cartItemEO.setCount(count);
            cartItemEO.setItem_date(new Date());
            cartItemEO.setCate_name(categoryName);
            cartItemEO.setBook_name(bookName);
            cartItemEO.setBook_price(price);
         //   em.persist(cartItemEO);
            cartEO.getCartItems().add(cartItemEO);
        }

        return em.merge(cartEO);
    }

    @SuppressWarnings("unchecked")
    @Override
    public cartEO findCart(String login) throws BookStoreException {

        try{
        List<cartEO> cartList = em.createQuery(" SELECT c FROM cartEO c where c.login_name = :name and c.isPaid = false ")
                .setParameter("name", login).getResultList();

        if (cartList.size()>0) {
            return cartList.get(0);
        }

        cartEO cartEO = new cartEO();
        cartEO.setCart_date(new Date());
        cartEO.setLogin_name(login);
        cartEO.setIsPaid(false);
        cartEO.setUser(null);

        em.persist(cartEO);
         return cartEO;
        }catch(Exception e)
        {
            throw (new BookStoreException(e.toString()));
            
            
        }
       
    }

    @Override
    public cartEO payCart(cartEO cartEO) throws BookStoreException {

        cartEO.setIsPaid(true);

        return em.merge(cartEO);
    }
}
