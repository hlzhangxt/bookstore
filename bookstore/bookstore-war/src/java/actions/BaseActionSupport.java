/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import ejb.CategoryEO;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sessions.CategoryEOFacade;

/**
 *
 * @author Administrator
 */
public class BaseActionSupport extends ActionSupport {

    protected String action;
    protected String title;
    protected String message;
    
    protected CategoryEO rootCategoryEO;
    
    @Inject CategoryEOFacade bean;

    public BaseActionSupport() {
    }

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
            rootCategoryEO = new CategoryEO();
            rootCategoryEO.setCate_id(0);
            rootCategoryEO.setCate_name("All");
            rootCategoryEO.getSubCategories().addAll(getCategoryEOList());
        }


        return rootCategoryEO;
    }

    public List<CategoryEO> getCategoryEOList() {

        try {
           // return BOClient.lookupICategory().list(
           //         " from CategoryEO c where c.parent_id = null ");
           return bean.findAll();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<CategoryEO>();
    }

    public void setRootCategoryEO(CategoryEO rootCategoryEO) {
        this.rootCategoryEO = rootCategoryEO;
    }
}