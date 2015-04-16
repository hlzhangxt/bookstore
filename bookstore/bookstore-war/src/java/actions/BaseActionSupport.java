/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import ejb.CategoryEO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessions.CategoryEOFacadeLocal;

/**
 *
 * @author Administrator
 */
public class BaseActionSupport extends ActionSupport {
    CategoryEOFacadeLocal categoryEOFacade = lookupCategoryEOFacadeLocal();

    protected String action;
    protected String title;
    protected String message;
    protected CategoryEO rootCategoryEO;
    
    protected final String LISTROOT = "root";
    
    public BaseActionSupport() {
    }

    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CategoryEO getRootCategoryEO() {
        if (rootCategoryEO == null) {
            rootCategoryEO = categoryEOFacade.getRootCategoryEOList().get(0);
            /*        new CategoryEO();
            rootCategoryEO.setCate_id(-1);
            rootCategoryEO.setCate_name("All");
            rootCategoryEO.getSubCategories().addAll(categoryEOFacade.getRootCategoryEOList());*/
        }


        return rootCategoryEO;
    }

    public void setRootCategoryEO(CategoryEO rootCategoryEO) {
        this.rootCategoryEO = rootCategoryEO;
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
    
    
}