/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "categories")
public class CategoryEO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cate_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cate_id;
    @Column(name = "cate_name")
    private String cate_name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private CategoryEO parent;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    private Set<CategoryEO> subCategories = new HashSet<CategoryEO>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<bookEO> books = new ArrayList<bookEO>();

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public CategoryEO getParent() {
        return parent;
    }

    public void setParent(CategoryEO parent) {
        this.parent = parent;
    }

    public Set<CategoryEO> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<CategoryEO> subCategories) {
        this.subCategories = subCategories;
    }

    public List<bookEO> getBooks() {
        return books;
    }

    public void setBooks(List<bookEO> books) {
        this.books = books;
    }
}
