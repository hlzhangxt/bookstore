/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CategoryEO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface CategoryEOFacadeLocal {

    void create(CategoryEO categoryEO);

    void edit(CategoryEO categoryEO);

    void remove(CategoryEO categoryEO);

    CategoryEO find(Object id);

    List<CategoryEO> findAll();

    List<CategoryEO> findRange(int[] range);

    int count();
    
}
