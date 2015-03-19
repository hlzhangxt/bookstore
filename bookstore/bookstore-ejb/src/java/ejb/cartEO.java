/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "carts")
public class cartEO implements Serializable {
    private static final long serialVersionUID = 1L;
        @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cart_id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEO user;
	
	
	@Column(name = "login_name")
	private String login_name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date cart_date;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cart")
	private Set<CartItemEO> cartItems = new HashSet<CartItemEO>();
	
	
	@Column(name = "isPaid")
	private Boolean isPaid;

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public CustomerEO getUser() {
        return user;
    }

    public void setUser(CustomerEO user) {
        this.user = user;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public Date getCart_date() {
        return cart_date;
    }

    public void setCart_date(Date cart_date) {
        this.cart_date = cart_date;
    }

    public Set<CartItemEO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItemEO> cartItems) {
        this.cartItems = cartItems;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

  
    
}
