/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import ejb.CategoryEO;
import ejb.bookEO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessions.CategoryEOFacadeLocal;
import sessions.bookEOFacadeLocal;
import utilities.StringUtil;

/**
 *
 * @author Administrator
 */
public class CategoryAction extends BaseActionSupport {

    bookEOFacadeLocal bookEOFacade = lookupbookEOFacadeLocal();
    CategoryEOFacadeLocal categoryEOFacade = lookupCategoryEOFacadeLocal();
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String LIST = "list";
    
    public static final String ROOT = "root";
    
    private CategoryEO parent;
    private CategoryEO category;
    private List<bookEO> bookList;

    public CategoryAction() {
    }

    public String execute() throws Exception {
        if (action == null) return list();
        
        switch (action) {
            case ADD:
                return add();
            case DELETE:
                return delete();
            
            case ROOT:
                return LISTROOT;

            default:
                return list();

        }

    }

    public String add() {

        setTitle("Category");

        if (parent != null) {
            try {
                parent = categoryEOFacade.find(parent.getCate_id());
            } catch (Exception e) {
                e.printStackTrace();
                parent = null;
              }
        }

        if (category == null) {
            return ADD;
        }

        if (StringUtil.isNull(category.getCate_name())) {
            setMessage("Please input the category name!");
            return ADD;
        }

        category.setParent(parent);
        parent.getSubCategories().add(category);

        try {
            category = categoryEOFacade.create(category);
            parent = categoryEOFacade.edit(parent);
            
            
            setMessage(category.getCate_name() + " successfully saved");
            
        } catch (Exception e) {
            setMessage(e.getMessage());
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }

    public String delete() {

        if (parent != null) {
            try {
                parent = categoryEOFacade.find(parent.getCate_id());
                if (parent != null) {
                    parent.getParent().getSubCategories().remove(parent);
                    categoryEOFacade.remove(parent);
                                        
                    setTitle("Successfully deleted");
                    setMessage("The Category  " + parent.getCate_name() + " is successfuly deleted");
                    
                    return SUCCESS;
                }
            } catch (Exception e) {
                setMessage(e.getMessage());
                return ERROR;
                
            }
        }

        
       return SUCCESS;
        
    }

    public String list() {

        setTitle("Book List");

        if (parent != null) {
            try {
                parent = categoryEOFacade.find(parent.getCate_id());
            } catch (Exception e) {
                setMessage(e.getMessage());
            }
        }

        return LIST;
    }

    public CategoryEO getParent() {
        return parent;
    }

    public void setParent(CategoryEO parent) {
        this.parent = parent;
    }

    public CategoryEO getCategory() {
        return category;
    }

    public void setCategory(CategoryEO category) {
        this.category = category;
    }

    public List<bookEO> getBookList() {
       // if (bookList == null) {
            try {
                if (parent == null) {
                    bookList = bookEOFacade.findByCategory(0);
                } else {
                    bookList = bookEOFacade.findByCategory(parent.getCate_id());
                }
            } catch (Exception e) {
                setMessage(e.getMessage());
                e.printStackTrace();
                return null;
            }
      //  }

        return bookList;
    }

    public void setBookList(List<bookEO> bookList) {
        this.bookList = bookList;
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

    private bookEOFacadeLocal lookupbookEOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (bookEOFacadeLocal) c.lookup("java:global/bookstore/bookstore-ejb/bookEOFacade!sessions.bookEOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public bookEOFacadeLocal getBookEOFacade() {
        return bookEOFacade;
    }

    public void setBookEOFacade(bookEOFacadeLocal bookEOFacade) {
        this.bookEOFacade = bookEOFacade;
    }

    public CategoryEOFacadeLocal getCategoryEOFacade() {
        return categoryEOFacade;
    }

    public void setCategoryEOFacade(CategoryEOFacadeLocal categoryEOFacade) {
        this.categoryEOFacade = categoryEOFacade;
    }
    
}