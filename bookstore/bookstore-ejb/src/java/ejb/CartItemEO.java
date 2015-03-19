/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "cart_items")
public class CartItemEO implements Serializable {
    private static final long serialVersionUID = 1L;
        @Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer item_id;
		

	@Column(name = "cate_name")
	private String cate_name;
	
	@Column(name = "book_name")
	private String book_name;
	
	@Column(name = "count")
	private Integer count;
	
	@Column(name = "book_price")
	private Double book_price;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private cartEO cart;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "item_date")
	private Date item_date;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }

    public cartEO getCart() {
        return cart;
    }

    public void setCart(cartEO cart) {
        this.cart = cart;
    }

    public Date getItem_date() {
        return item_date;
    }

    public void setItem_date(Date item_date) {
        this.item_date = item_date;
    }
	

   

    
    
}
