/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CategoryEO;
import exceptions.BookStoreException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface CategoryEOFacadeLocal {

    CategoryEO create(CategoryEO categoryEO) throws BookStoreException;

    CategoryEO edit(CategoryEO categoryEO) throws BookStoreException;

    void remove(CategoryEO categoryEO) throws BookStoreException;

    CategoryEO find(Object id);

    List<CategoryEO> findAll();

    List<CategoryEO> findRange(int[] range);

    int count();
    
    public CategoryEO findCategory(String name) throws BookStoreException;

 
    
}
