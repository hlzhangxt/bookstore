/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import ejb.CategoryEO;
import ejb.CustomerEO;
import ejb.bookEO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.struts2.ServletActionContext;
import sessions.CategoryEOFacadeLocal;
import sessions.bookEOFacadeLocal;
import sessions.cartEOFacadeLocal;
import utilities.StringUtil;

/**
 *
 * @author Administrator
 */
public class BookAction extends BaseActionSupport {

    CategoryEOFacadeLocal categoryEOFacade = lookupCategoryEOFacadeLocal();
    cartEOFacadeLocal cartEOFacade = lookupcartEOFacadeLocal();
    bookEOFacadeLocal bookEOFacade = lookupbookEOFacadeLocal();
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String BUY = "buy";
    private CategoryEO category;
    private bookEO book;
    private int count;

    public BookAction() {
    }

    public String execute() throws Exception {
        if (ADD.equals(action)) {
            return add();
        }

        if (DELETE.equals(action)) {
            return delete();
        }

        if (BUY.equals(action)) {
            return buy();
        }

        return add();
    }

    public String add() {

        setTitle("Add Books");

        try {

            category = categoryEOFacade.find(category.getCate_id());

        } catch (Exception e) {
            setMessage(e.getMessage());
            e.printStackTrace();
        }

        if (book == null) {
            return ADD;
        }

        if (StringUtil.isNull(book.getBook_name())) {
            setMessage("Please input the book name");
            return ADD;
        }
        if (book.getBook_price() <= 0) {
            setMessage("Please input the book price");
            return ADD;
        }

        book.setCategory(category);
        category.getBooks().add(book);

        try {
            bookEOFacade.create(book);
            setMessage(book.getBook_name() + " is successfully saved!");
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            setMessage(e.getMessage());
        }

        return ADD;
    }

    public String buy() {

        setTitle("Buy");

        CustomerEO customer = (CustomerEO) ServletActionContext.getRequest().getSession(
                true).getAttribute("customer");

        if (customer == null) {
            setMessage("Please log in!");
            return LOGIN;
        }

        try {
            book = bookEOFacade.find(book.getBook_id());
        } catch (Exception e) {
            e.printStackTrace();
            setMessage(e.getMessage());
        }

        if (book == null || count == 0) {
            count = 1;
            return BUY;
        }

        try {
            cartEOFacade.addItem(customer.getLogin_name(),
                    book.getCategory().getCate_name(), book.getBook_name(),
                    book.getBook_price(), count);

            setMessage("You have successfully bought " + count + " of " + book.getBook_name());

            return "buySuccess";
        } catch (Exception e) {
           setMessage(e.toString());
         // setMessage("Errors when add books in the cart!");
           // e.printStackTrace();
            
            return ERROR;
        }
     //   return BUY;
    }

    public String delete() {
        return DELETE;
    }

    public CategoryEO getCategory() {
        return category;
    }

    public bookEO getBook() {
        return book;
    }

    public int getCount() {
        return count;
    }

    public void setCategory(CategoryEO category) {
        this.category = category;
    }

    public void setBook(bookEO book) {
        this.book = book;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private bookEOFacadeLocal lookupbookEOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (bookEOFacadeLocal) c.lookup("java:global/bookstore/bookstore-ejb/bookEOFacade!sessions.bookEOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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

    private CategoryEOFacadeLocal lookupCategoryEOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CategoryEOFacadeLocal) c.lookup("java:global/bookstore/bookstore-ejb/CategoryEOFacade!sessions.CategoryEOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public CategoryEOFacadeLocal getCategoryEOFacade() {
        return categoryEOFacade;
    }

    public void setCategoryEOFacade(CategoryEOFacadeLocal categoryEOFacade) {
        this.categoryEOFacade = categoryEOFacade;
    }

    public cartEOFacadeLocal getCartEOFacade() {
        return cartEOFacade;
    }

    public void setCartEOFacade(cartEOFacadeLocal cartEOFacade) {
        this.cartEOFacade = cartEOFacade;
    }

    public bookEOFacadeLocal getBookEOFacade() {
        return bookEOFacade;
    }

    public void setBookEOFacade(bookEOFacadeLocal bookEOFacade) {
        this.bookEOFacade = bookEOFacade;
    }
    
    
}