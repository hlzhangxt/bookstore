/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "books")
public class bookEO implements Serializable {
    private static final long serialVersionUID = 1L;
        @Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer book_id;
	
	
	@Column(name = "book_name")
	private String book_name;
	
	
	@Column(name = "book_price")
	private double book_price;
	
	
	public CategoryEO getCategory() {
		return category;
	}
	public void setCategory(CategoryEO category) {
		this.category = category;
	}

	
	@Column(name = "book_author")
	private String book_author;


	@ManyToOne
	@JoinColumn(name = "cate_id")
	private CategoryEO category;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }
	

   
}
