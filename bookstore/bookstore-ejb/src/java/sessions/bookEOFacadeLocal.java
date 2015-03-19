/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.bookEO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface bookEOFacadeLocal {

    void create(bookEO bookEO);

    void edit(bookEO bookEO);

    void remove(bookEO bookEO);

    bookEO find(Object id);

    List<bookEO> findAll();

    List<bookEO> findRange(int[] range);

    int count();
    
}
