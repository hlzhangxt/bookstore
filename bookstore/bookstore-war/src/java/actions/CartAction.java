/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import ejb.CustomerEO;
import ejb.cartEO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import sessions.cartEOFacadeLocal;

/**
 *
 * @author Administrator
 */
public class CartAction extends BaseActionSupport {

    cartEOFacadeLocal cartEOFacade = lookupcartEOFacadeLocal();
    public static final String LIST = "list";
    public static final String PAY = "pay";
    private cartEO cart;

    public CartAction() {
    }

    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest()
                .getSession(true);

        CustomerEO customer = (CustomerEO) session.getAttribute("customer");

        if (customer == null) {
            setMessage("Please log in");
            return LOGIN;
        }

               
        if (PAY.equals(action)) {
            return pay();
        }

        return LIST;
    }

    public String pay() {

        try {
            cartEOFacade.payCart(getCart());
            setMessage("Thanks！");
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            setMessage(e.getMessage());
        }

        return LIST;
    }

    public cartEO getCart() {

        if (cart == null) {

            try {
                HttpSession session = ServletActionContext.getRequest()
                        .getSession(true);
                CustomerEO customer = (CustomerEO) session.getAttribute("customer");

                cart = cartEOFacade.findCart(customer.getLogin_name());
            } catch (Exception e) {
                setMessage(e.getMessage());
                
            }

        }

        return cart;
    }

    public void setCart(cartEO cart) {
        this.cart = cart;
    }

    private cartEOFacadeLocal lookupcartEOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (cartEOFacadeLocal) c.lookup("java:global/bookstore/bookstore-ejb/cartEOFacade!sessions.cartEOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public cartEOFacadeLocal getCartEOFacade() {
        return cartEOFacade;
    }

    public void setCartEOFacade(cartEOFacadeLocal cartEOFacade) {
        this.cartEOFacade = cartEOFacade;
    }

  
    
}