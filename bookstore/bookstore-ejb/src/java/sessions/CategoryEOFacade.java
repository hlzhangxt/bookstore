/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import ejb.CategoryEO;
import exceptions.BookStoreException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hongliang Zhang
 */
@Stateless
public class CategoryEOFacade extends AbstractFacade<CategoryEO> implements CategoryEOFacadeLocal {

    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryEOFacade() {
        super(CategoryEO.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public CategoryEO findCategory(String name) throws BookStoreException {

        List<CategoryEO> list = em.createQuery(
                " SELECT c FROM CategoryEO c WHERE c.cate_name = :name ")
                .setParameter("name", name).getResultList();

        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public CategoryEO create(CategoryEO categoryEO) throws BookStoreException {

        if (findCategory(categoryEO.getCate_name()) != null) {
            throw new BookStoreException("The Category " + categoryEO.getCate_name() + "alread exists");
        }

        em.persist(categoryEO);

        return categoryEO;
    }

    @Override
    public void remove(CategoryEO categoryEO) throws BookStoreException {

        CategoryEO t = findCategory(categoryEO.getCate_name());

        if (t.getSubCategories().size() > 0) {
            throw new BookStoreException("There are subcategories under " + categoryEO.getCate_name()
                    + ", you can not delete it, please delete the subcategories at first!");
        }

        if (!t.getBooks().isEmpty()) {
            throw new BookStoreException("There are books under " + categoryEO.getCate_name()
                    + ", you can not delete it, please delete the books at first!");
        }

        super.remove(t);

    }

    @Override
    public CategoryEO edit(CategoryEO catagoryEO) throws BookStoreException {

        List list = em.createQuery(
                " SELECT c FROM CategoryEO c WHERE c.cate_name = :name AND c.cate_id <> :id ")
                .setParameter("name", catagoryEO.getCate_name()).setParameter("id",
                catagoryEO.getCate_id()).getResultList();

        if (list.size() > 0) {
            throw new BookStoreException("The category：" + catagoryEO.getCate_name() + " already exists!");
        }

        em.merge(catagoryEO);

        return catagoryEO;
    }

    public List<CategoryEO> getRootCategoryEOList() {
        try {
            List<CategoryEO> list = em.createQuery(
                    "select c from CategoryEO c where c.parent = null").getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<CategoryEO>();



    }
}
