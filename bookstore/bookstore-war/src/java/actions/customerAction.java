/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import ejb.CustomerEO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import sessions.CustomerEOFacadeLocal;
import utilities.StringUtil;

/**
 *
 * @author Administrator
 */
public class customerAction extends BaseActionSupport {

    CustomerEOFacadeLocal customerEOFacade = lookupCustomerEOFacadeLocal();
    public final static String REGI = "register";
    public final static String LOUT = "logout";
    public final static String LGIN = "login";
    private CustomerEO customer;
    private String confPass;

    public customerAction() {
    }

    @Override
    public String execute() throws Exception {
        switch (action) {
            case REGI:
                return register();

            case LOUT:
                return logout();

            case LGIN:
                return login();

            default:
                return login();


        }


    }

    public CustomerEOFacadeLocal getCustomerEOFacade() {
        return customerEOFacade;
    }

    public void setCustomerEOFacade(CustomerEOFacadeLocal customerEOFacade) {
        this.customerEOFacade = customerEOFacade;
    }

    public CustomerEO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEO customer) {
        this.customer = customer;
    }

    public String getConfPass() {
        return confPass;
    }

    public void setConfPass(String confPass) {
        this.confPass = confPass;
    }

    public String register() {

        setTitle("Customer Registration");

        if (customer == null) {
            return REGI;
        }
        if (StringUtil.isNull(customer.getLogin_name())
                || StringUtil.isNull(customer.getLogin_pass())) {
            setMessage("Please input login name and password!");
            return REGI;
        }
        if (!customer.getLogin_pass().equals(confPass)) {
            setMessage("Password Mismatch");
            return REGI;
        }

        try {
            customer = customerEOFacade.create(customer);

            HttpSession session = ServletActionContext.getRequest().getSession(
                    true);

            session.setAttribute("customer", customer);

            setMessage("Registration Succesful!");

            return SUCCESS;

        } catch (Exception e) {
            setMessage("Errors：" + e.getMessage());
        }

        return REGI;
    }

    public String login() {

        setTitle("Customer Login");

        if (customer == null) {
            setMessage("Customer information is null");
            return LOGIN;
        }
        if (StringUtil.isNull(customer.getLogin_name())
                || StringUtil.isNull(customer.getLogin_pass())) {
            setMessage("Please input your login name and password!");
            return LOGIN;
        }

        try {
            CustomerEO cust = customerEOFacade.findCustomer(customer.getLogin_name(),
                    customer.getLogin_pass());

            if (cust == null) {
                setMessage("Wrong login name or password");
                return LOGIN;
            } else {
                HttpSession session = ServletActionContext.getRequest()
                        .getSession(true);
                session.setAttribute("customer", cust);
                setMessage("Welcome" + cust.getLogin_name());
                return SUCCESS;
            }

        } catch (Exception e) {
            setMessage("Errors：" + e.getMessage());
        }

        return LOGIN;
    }

    public String logout() {

        HttpSession session = ServletActionContext.getRequest()
                .getSession(true);
        session.setAttribute("customer", null);

        setMessage("Log out successfully");

        return login();
    }

    private CustomerEOFacadeLocal lookupCustomerEOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomerEOFacadeLocal) c.lookup("java:global/bookstore/bookstore-ejb/CustomerEOFacade!sessions.CustomerEOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}